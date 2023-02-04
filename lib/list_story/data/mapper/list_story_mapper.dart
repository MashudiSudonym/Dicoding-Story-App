import 'package:story_app/list_story/data/remote/dto/list_story_response_dto.dart';
import 'package:story_app/list_story/data/remote/dto/story_response_dto.dart';
import 'package:story_app/list_story/domain/model/list_story_response.dart';
import 'package:story_app/list_story/domain/model/story_response.dart';

extension StoryResponseDTOExtension on StoryResponseDTO {
  StoryResponse toStoryResponse() => StoryResponse(
        id: id,
        name: name,
        description: description,
        photoUrl: photoUrl,
        createAt: createAt,
      );
}

extension ListStoryResponseDTOExtension on ListStoryResponseDTO {
  ListStoryResponse toListStoryResponse() => ListStoryResponse(
        error: error,
        message: message,
        listStoryResponse: listStoryResponseDTO
            ?.map(
              (data) => data.toStoryResponse(),
            )
            .toList(),
      );
}
