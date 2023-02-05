// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'list_story_response_dto.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_ListStoryResponseDTO _$$_ListStoryResponseDTOFromJson(
        Map<String, dynamic> json) =>
    _$_ListStoryResponseDTO(
      error: json['error'] as bool,
      message: json['message'] as String,
      listStoryResponseDTO: (json['listStory'] as List<dynamic>?)
          ?.map((e) => e == null
              ? null
              : StoryResponseDTO.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$$_ListStoryResponseDTOToJson(
        _$_ListStoryResponseDTO instance) =>
    <String, dynamic>{
      'error': instance.error,
      'message': instance.message,
      'listStory': instance.listStoryResponseDTO,
    };
