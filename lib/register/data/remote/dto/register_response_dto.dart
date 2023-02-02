import 'package:freezed_annotation/freezed_annotation.dart';

part 'register_response_dto.freezed.dart';
part 'register_response_dto.g.dart';

@freezed
class RegisterResponseDTO with _$RegisterResponseDTO {
  const factory RegisterResponseDTO({
    @JsonKey(name: 'error') required bool error,
    @JsonKey(name: 'message') required String message,
  }) = _RegisterResponseDTO;

  factory RegisterResponseDTO.fromJson(Map<String, dynamic> json) =>
      _$RegisterResponseDTOFromJson(json);
}
