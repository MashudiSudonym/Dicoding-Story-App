// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'story_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_StoryResponse _$$_StoryResponseFromJson(Map<String, dynamic> json) =>
    _$_StoryResponse(
      id: json['id'] as String,
      name: json['name'] as String,
      description: json['description'] as String,
      photoUrl: json['photoUrl'] as String,
      createAt: json['createAt'] as String,
    );

Map<String, dynamic> _$$_StoryResponseToJson(_$_StoryResponse instance) =>
    <String, dynamic>{
      'id': instance.id,
      'name': instance.name,
      'description': instance.description,
      'photoUrl': instance.photoUrl,
      'createAt': instance.createAt,
    };
