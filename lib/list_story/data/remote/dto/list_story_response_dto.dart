import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:story_app/list_story/data/remote/dto/story_response_dto.dart';

part 'list_story_response_dto.freezed.dart';
part 'list_story_response_dto.g.dart';

@freezed
class ListStoryResponseDTO with _$ListStoryResponseDTO {
  const factory ListStoryResponseDTO({
    @JsonKey(name: 'error') required bool error,
    @JsonKey(name: 'message') required String message,
    @JsonKey(name: 'listStory') List<StoryResponseDTO>? listStoryResponseDTO,
  }) = _ListStoryResponseDTO;

  factory ListStoryResponseDTO.fromJson(Map<String, dynamic> json) =>
      _$ListStoryResponseDTOFromJson(json);
}
