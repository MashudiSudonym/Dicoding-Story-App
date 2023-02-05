import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:story_app/list_story/domain/model/story_response.dart';

part 'list_story_response.freezed.dart';
part 'list_story_response.g.dart';

@freezed
class ListStoryResponse with _$ListStoryResponse {
  const factory ListStoryResponse({
    required bool error,
    required String message,
    List<StoryResponse?>? listStoryResponse,
  }) = _ListStoryResponse;

  factory ListStoryResponse.fromJson(Map<String, dynamic> json) =>
      _$ListStoryResponseFromJson(json);
}
