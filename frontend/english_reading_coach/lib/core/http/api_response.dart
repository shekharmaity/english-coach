class ApiResponse<T> {
  const ApiResponse({
    required this.success,
    required this.data,
    required this.traceId,
  });

  factory ApiResponse.fromJson(
    Map<String, Object?> json,
    T Function(Object? json) parseData,
  ) {
    return ApiResponse<T>(
      success: json['success'] as bool? ?? false,
      data: parseData(json['data']),
      traceId: json['traceId'] as String? ?? 'unknown',
    );
  }

  final bool success;
  final T data;
  final String traceId;
}
