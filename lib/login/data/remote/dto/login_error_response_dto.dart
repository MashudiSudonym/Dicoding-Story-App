import 'package:freezed_annotation/freezed_annotation.dart';

part 'login_error_response_dto.freezed.dart';

part 'login_error_response_dto.g.dart';

@freezed
class LoginErrorResponseDTO with _$LoginErrorResponseDTO {
  const factory LoginErrorResponseDTO({
    @JsonKey(name: 'error') required bool error,
    @JsonKey(name: 'message') required String message,
  }) = _LoginErrorResponseDTO;

  factory LoginErrorResponseDTO.fromJson(Map<String, Object?> json) =>
      _$LoginErrorResponseDTOFromJson(json);
}
