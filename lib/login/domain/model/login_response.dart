import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:story_app/login/domain/model/login_result.dart';

part 'login_response.freezed.dart';
part 'login_response.g.dart';

@freezed
class LoginResponse with _$LoginResponse {
  const factory LoginResponse({
    required bool error,
    required String message,
    LoginResult? loginResult,
  }) = _LoginResponse;

  factory LoginResponse.fromJson(Map<String, dynamic> json) =>
      _$LoginResponseFromJson(json);
}
