// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'login_response_dto.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_LoginResponseDTO _$$_LoginResponseDTOFromJson(Map<String, dynamic> json) =>
    _$_LoginResponseDTO(
      error: json['error'] as bool,
      message: json['message'] as String,
      loginResultDTO: json['loginResult'] == null
          ? null
          : LoginResultDTO.fromJson(
              json['loginResult'] as Map<String, dynamic>),
    );

Map<String, dynamic> _$$_LoginResponseDTOToJson(_$_LoginResponseDTO instance) =>
    <String, dynamic>{
      'error': instance.error,
      'message': instance.message,
      'loginResult': instance.loginResultDTO,
    };
