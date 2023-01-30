import 'dart:async';

import 'package:injectable/injectable.dart';
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
    Resource<LoginResponse> result;

    try {
      final responseLogin = await _loginServiceApi.postLogin(email, password);

      if (responseLogin.isSuccessful) {
        result = Resource.success(
          LoginResponseDTO.fromJson(responseLogin.body).toLoginResponse(),
        );
      } else {
        result = Resource.error(
          LoginResponseDTO.fromJson(responseLogin.error as Map<String, Object?>)
              .toLoginResponse()
              .message,
          LoginResponseDTO.fromJson(responseLogin.error as Map<String, Object?>)
              .toLoginResponse(),
        );
      }
    } catch (e) {
      result = Resource.error(e.toString(), null);
    } finally {
      _loginServiceApi.client.dispose();
    }

    return result;
  }
}
