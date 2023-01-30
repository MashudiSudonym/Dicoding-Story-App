import 'package:story_app/common/util/failure/failure.dart';

class ServerFailure implements Failure {
  @override
  final String message;

  ServerFailure({required this.message});

  @override
  String toString() => 'ServerFailure { message: $message }';
}
