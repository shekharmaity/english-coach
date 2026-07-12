class ApiErrorResponse {
  const ApiErrorResponse({
    required this.code,
    required this.message,
    required this.traceId,
    this.details = const <String, Object?>{},
  });

  factory ApiErrorResponse.fromJson(Map<String, Object?> json) {
    return ApiErrorResponse(
      code: json['code'] as String? ?? 'UNKNOWN_ERROR',
      message: json['message'] as String? ?? 'An unexpected error occurred.',
      traceId: json['traceId'] as String? ?? 'unknown',
      details: json['details'] is Map<String, Object?>
          ? json['details']! as Map<String, Object?>
          : const <String, Object?>{},
    );
  }

  final String code;
  final String message;
  final String traceId;
  final Map<String, Object?> details;
}
