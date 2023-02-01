import 'package:dartz/dartz.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/domain/model/authentication_token.dart';
import 'package:story_app/authentication_check/domain/repository/authentication_check_repository.dart';
import 'package:story_app/common/util/failure/failure.dart';
import 'package:story_app/common/util/failure/server_failure.dart';
import 'package:story_app/common/util/resource.dart';

@injectable
class GetTokenFromDataStoreUseCase {
  final AuthenticationCheckRepository _authenticationCheckRepository;

  GetTokenFromDataStoreUseCase(this._authenticationCheckRepository);

  Future<Either<Failure, AuthenticationToken>> call() async {
    final resource = await _authenticationCheckRepository.getToken();

    if (resource is Success) {
      return Right(resource.data ?? const AuthenticationToken(token: ''));
    } else {
      return Left(ServerFailure(message: resource.message));
    }
  }
}
