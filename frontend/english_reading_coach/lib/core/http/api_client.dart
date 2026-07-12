import 'dart:convert';

import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:http/http.dart' as http;

import '../config/app_config.dart';
import '../errors/app_exception.dart';
import 'api_error_response.dart';

final Provider<http.Client> httpClientProvider = Provider<http.Client>((ref) {
  final client = http.Client();
  ref.onDispose(client.close);
  return client;
});

final Provider<ApiClient> apiClientProvider = Provider<ApiClient>((ref) {
  return ApiClient(
    baseUrl: ref.watch(appConfigProvider).apiBaseUrl,
    client: ref.watch(httpClientProvider),
  );
});

class ApiClient {
  const ApiClient({required this.baseUrl, required this.client});

  final String baseUrl;
  final http.Client client;

  Future<Map<String, Object?>> getJson(String path) {
    return _sendJson(() {
      return client.get(_uri(path), headers: _headers);
    });
  }

  Future<Map<String, Object?>> postJson(
    String path, {
    Map<String, Object?> body = const <String, Object?>{},
  }) {
    return _sendJson(() {
      return client.post(_uri(path), headers: _headers, body: jsonEncode(body));
    });
  }

  Future<Map<String, Object?>> _sendJson(
    Future<http.Response> Function() send,
  ) async {
    final response = await send();
    final decoded = _decodeBody(response.body);

    if (response.statusCode < 200 || response.statusCode >= 300) {
      final apiError = ApiErrorResponse.fromJson(decoded);
      throw AppException(
        code: apiError.code,
        message: apiError.message,
        details: apiError.details,
        traceId: apiError.traceId,
      );
    }

    return decoded;
  }

  Uri _uri(String path) {
    final normalizedBase = baseUrl.endsWith('/')
        ? baseUrl.substring(0, baseUrl.length - 1)
        : baseUrl;
    final normalizedPath = path.startsWith('/') ? path : '/$path';
    return Uri.parse('$normalizedBase$normalizedPath');
  }

  Map<String, String> get _headers {
    return const <String, String>{
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    };
  }

  Map<String, Object?> _decodeBody(String body) {
    if (body.isEmpty) {
      return const <String, Object?>{};
    }

    final Object? decoded = jsonDecode(body);
    if (decoded is Map<String, Object?>) {
      return decoded;
    }

    return <String, Object?>{'data': decoded};
  }
}
