import 'package:dartz/dartz.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/failure/failure.dart';
import 'package:story_app/common/util/failure/server_failure.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/login/domain/model/login_response.dart';
import 'package:story_app/login/domain/repository/login_repository.dart';

@injectable
class UserLoginUseCase {
  final LoginRepository _loginRepository;

  UserLoginUseCase(this._loginRepository);

  Future<Either<Failure, LoginResponse>> call(
      String email, String password) async {
    final resource = await _loginRepository.postLogin(email, password);

    if (resource is Success) {
      return Right(
        resource.data ?? const LoginResponse(error: false, message: ''),
      );
    } else {
      return Left(ServerFailure(message: resource.message));
    }
  }
}
