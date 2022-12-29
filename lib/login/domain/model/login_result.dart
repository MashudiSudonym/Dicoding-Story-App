import 'package:freezed_annotation/freezed_annotation.dart';

part 'login_result.freezed.dart';

part 'login_result.g.dart';

@freezed
class LoginResult with _$LoginResult {
  const factory LoginResult({
    @JsonKey(name: 'userId') required String userId,
    @JsonKey(name: 'name') required String name,
    @JsonKey(name: 'token') required String token,
  }) = _LoginResult;

  factory LoginResult.fromJson(Map<String, Object?> json) =>
      _$LoginResultFromJson(json);
}
