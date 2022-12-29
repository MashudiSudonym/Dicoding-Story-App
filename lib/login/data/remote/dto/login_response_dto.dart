import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:story_app/login/data/remote/dto/login_result_dto.dart';

part 'login_response_dto.freezed.dart';
part 'login_response_dto.g.dart';

@freezed
class LoginResponseDTO with _$LoginResponseDTO {
  const factory LoginResponseDTO({
    @JsonKey(name: 'error') required bool error,
    @JsonKey(name: 'message') required String message,
    @JsonKey(name: 'loginResult') LoginResultDTO? loginResultDTO,
  }) = _LoginResponseDTO;

  factory LoginResponseDTO.fromJson(Map<String, Object?> json) =>
      _$LoginResponseDTOFromJson(json);
}
