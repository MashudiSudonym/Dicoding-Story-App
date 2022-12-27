import 'package:freezed_annotation/freezed_annotation.dart';

part 'login_result_dto.freezed.dart';

part 'login_result_dto.g.dart';

@freezed
class LoginResultDTO with _$LoginResultDTO {
  const factory LoginResultDTO({
    @JsonKey(name: 'userId') required String userId,
    @JsonKey(name: 'name') required String name,
    @JsonKey(name: 'token') required String token,
  }) = _LoginResultDTO;

  factory LoginResultDTO.fromJson(Map<String, Object?> json) =>
      _$LoginResultDTOFromJson(json);
}
