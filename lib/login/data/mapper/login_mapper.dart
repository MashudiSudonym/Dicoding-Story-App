import 'package:story_app/login/data/remote/dto/login_response_dto.dart';
import 'package:story_app/login/data/remote/dto/login_result_dto.dart';
import 'package:story_app/login/domain/model/login_response.dart';
import 'package:story_app/login/domain/model/login_result.dart';

extension LoginResultDTOExtension on LoginResultDTO {
  LoginResult toLoginResult() => LoginResult(
        userId: userId,
        name: name,
        token: token,
      );
}

extension LoginResponseDTOExtension on LoginResponseDTO {
  LoginResponse toLoginResponse() => LoginResponse(
      error: error,
      message: message,
      loginResult: loginResultDTO?.toLoginResult());
}
