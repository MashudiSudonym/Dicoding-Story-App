// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'story_response_dto.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_StoryResponseDTO _$$_StoryResponseDTOFromJson(Map<String, dynamic> json) =>
    _$_StoryResponseDTO(
      id: json['id'] as String,
      name: json['name'] as String,
      description: json['description'] as String,
      photoUrl: json['photoUrl'] as String,
      createdAt: json['createdAt'] as String,
    );

Map<String, dynamic> _$$_StoryResponseDTOToJson(_$_StoryResponseDTO instance) =>
    <String, dynamic>{
      'id': instance.id,
      'name': instance.name,
      'description': instance.description,
      'photoUrl': instance.photoUrl,
      'createdAt': instance.createdAt,
    };
