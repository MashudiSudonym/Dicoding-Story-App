import 'dart:async';
import 'dart:io';

import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/app_error.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/login/data/mapper/login_mapper.dart';
import 'package:story_app/login/data/remote/dto/login_response_dto.dart';
import 'package:story_app/login/data/remote/login_service_api.dart';
import 'package:story_app/login/domain/model/login_response.dart';
import 'package:story_app/login/domain/repository/login_repository.dart';

@Injectable(as: LoginRepository)
class LoginRepositoryImpl implements LoginRepository {
  final LoginServiceApi _loginServiceApi;

  LoginRepositoryImpl(this._loginServiceApi);

  @override
  Future<Resource<LoginResponse>> postLogin(
      String email, String password) async {
    try {
      final responseLogin = await _loginServiceApi.postLogin(email, password);

      if (responseLogin.isSuccessful) {
        return Resource(
          success: true,
          value:
              LoginResponseDTO.fromJson(responseLogin.body).toLoginResponse(),
        );
      } else {
        return Resource(
          success: false,
          error: AppError.NO_RESULTS,
          message: LoginResponseDTO.fromJson(
                  responseLogin.error as Map<String, Object?>)
              .toLoginResponse()
              .message,
        );
      }
    } on HttpException {
      return const Resource(success: false, error: AppError.NETWORK);
    } catch (e) {
      return const Resource(success: false, error: AppError.UNEXPECTED);
    } finally {
      _loginServiceApi.client.dispose();
    }
  }
}
