// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'login_error_response_dto.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_LoginErrorResponseDTO _$$_LoginErrorResponseDTOFromJson(
        Map<String, dynamic> json) =>
    _$_LoginErrorResponseDTO(
      error: json['error'] as bool,
      message: json['message'] as String,
    );

Map<String, dynamic> _$$_LoginErrorResponseDTOToJson(
        _$_LoginErrorResponseDTO instance) =>
    <String, dynamic>{
      'error': instance.error,
      'message': instance.message,
    };
