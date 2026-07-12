class AppException implements Exception {
  const AppException({
    required this.code,
    required this.message,
    this.details = const <String, Object?>{},
  });

  final String code;
  final String message;
  final Map<String, Object?> details;

  @override
  String toString() {
    return 'AppException(code: $code, message: $message)';
  }
}
