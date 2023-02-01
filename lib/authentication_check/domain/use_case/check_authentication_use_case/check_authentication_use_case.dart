import 'package:dartz/dartz.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/domain/model/authentication_status.dart';
import 'package:story_app/authentication_check/domain/repository/authentication_check_repository.dart';
import 'package:story_app/common/util/failure/failure.dart';
import 'package:story_app/common/util/failure/server_failure.dart';
import 'package:story_app/common/util/resource.dart';

@injectable
class CheckAuthenticationUseCase {
  final AuthenticationCheckRepository _authenticationCheckRepository;

  CheckAuthenticationUseCase(this._authenticationCheckRepository);

  Future<Either<Failure, AuthenticationStatus>> call() async {
    final resource = await _authenticationCheckRepository.checkAuthentication();

    if (resource is Success) {
      return Right(
          resource.data ?? const AuthenticationStatus(isAuthenticated: false));
    } else {
      return Left(ServerFailure(message: resource.message));
    }
  }
}
