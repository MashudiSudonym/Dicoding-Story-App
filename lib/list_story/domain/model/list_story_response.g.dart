// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'list_story_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_ListStoryResponse _$$_ListStoryResponseFromJson(Map<String, dynamic> json) =>
    _$_ListStoryResponse(
      error: json['error'] as bool,
      message: json['message'] as String,
      listStoryResponse: (json['listStoryResponse'] as List<dynamic>?)
          ?.map((e) => StoryResponse.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$$_ListStoryResponseToJson(
        _$_ListStoryResponse instance) =>
    <String, dynamic>{
      'error': instance.error,
      'message': instance.message,
      'listStoryResponse': instance.listStoryResponse,
    };
