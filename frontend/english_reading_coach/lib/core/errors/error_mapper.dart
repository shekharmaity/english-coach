import 'app_exception.dart';

String userMessageForError(Object error) {
  if (error is AppException) {
    return error.message;
  }

  return 'Something went wrong. Please try again.';
}
