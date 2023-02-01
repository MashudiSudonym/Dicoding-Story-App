import 'package:dartz/dartz.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/domain/use_case/save_token_to_data_store_use_case/save_token_to_data_store_use_case.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/common/util/failure/failure.dart';
import 'package:story_app/common/util/failure/server_failure.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/login/domain/model/login_response.dart';
import 'package:story_app/login/domain/repository/login_repository.dart';

@injectable
class UserLoginUseCase {
  final LoginRepository _loginRepository;
  final SaveTokenToDataStoreUseCase _saveTokenToDataStoreUseCase;

  UserLoginUseCase(this._loginRepository, this._saveTokenToDataStoreUseCase);

  Future<Either<Failure, LoginResponse>> call(
      String email, String password) async {
    final resource = await _loginRepository.postLogin(email, password);
    final saveToken = await _saveTokenToDataStoreUseCase(
      resource.data?.loginResult?.token ?? Constants.blankString,
    );

    if (resource is Success) {
      saveToken;
      return Right(
        resource.data ??
            const LoginResponse(
              error: false,
              message: Constants.blankString,
            ),
      );
    } else {
      saveToken;
      return Left(ServerFailure(message: resource.message));
    }
  }
}
