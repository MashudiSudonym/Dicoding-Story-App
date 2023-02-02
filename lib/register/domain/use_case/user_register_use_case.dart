import 'package:dartz/dartz.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/common/util/failure/failure.dart';
import 'package:story_app/common/util/failure/server_failure.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/register/domain/model/register_response.dart';
import 'package:story_app/register/domain/repository/register_repository.dart';

@injectable
class UserRegisterUseCase {
  final RegisterRepository _registerRepository;

  UserRegisterUseCase(this._registerRepository);

  Future<Either<Failure, RegisterResponse>> call(
    String name,
    String email,
    String password,
  ) async {
    final resource = await _registerRepository.postRegister(
      name,
      email,
      password,
    );

    if (resource is Success) {
      return Right(
        resource.data ??
            const RegisterResponse(
              error: false,
              message: Constants.blankString,
            ),
      );
    } else {
      return Left(ServerFailure(message: resource.message));
    }
  }
}
