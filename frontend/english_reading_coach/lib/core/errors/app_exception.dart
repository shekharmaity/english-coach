class AppException implements Exception {
  const AppException({
    required this.code,
    required this.message,
    this.details = const <String, Object?>{},
    this.traceId,
  });

  final String code;
  final String message;
  final Map<String, Object?> details;
  final String? traceId;

  @override
  String toString() {
    return 'AppException(code: $code, message: $message)';
  }
}
