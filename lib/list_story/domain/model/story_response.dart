import 'package:freezed_annotation/freezed_annotation.dart';

part 'story_response.freezed.dart';
part 'story_response.g.dart';

@freezed
class StoryResponse with _$StoryResponse {
  const factory StoryResponse({
    required String id,
    required String name,
    required String description,
    required String photoUrl,
    required String createdAt,
  }) = _StoryResponse;

  factory StoryResponse.fromJson(Map<String, dynamic> json) =>
      _$StoryResponseFromJson(json);
}
