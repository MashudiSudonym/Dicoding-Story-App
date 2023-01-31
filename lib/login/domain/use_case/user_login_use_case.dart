import 'package:dartz/dartz.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/failure/failure.dart';
import 'package:story_app/common/util/failure/server_failure.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/data_store/domain/repository/data_store_repository.dart';
import 'package:story_app/login/domain/model/login_response.dart';
import 'package:story_app/login/domain/repository/login_repository.dart';

@injectable
class UserLoginUseCase {
  final LoginRepository _loginRepository;
  final DataStoreRepository _dataStoreRepository;

  UserLoginUseCase(this._loginRepository, this._dataStoreRepository);

  Future<Either<Failure, LoginResponse>> call(
      String email, String password) async {
    final resource = await _loginRepository.postLogin(email, password);
    final saveLoginToken = await _dataStoreRepository
        .postLoginToken(resource.data?.loginResult?.token ?? '');

    if (resource is Success) {
      saveLoginToken;

      return Right(
        resource.data ?? const LoginResponse(error: false, message: ''),
      );
    } else {
      saveLoginToken;

      return Left(ServerFailure(message: resource.message));
    }
  }
}
