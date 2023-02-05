import 'package:freezed_annotation/freezed_annotation.dart';

part 'story_response_dto.freezed.dart';
part 'story_response_dto.g.dart';

@freezed
class StoryResponseDTO with _$StoryResponseDTO {
  const factory StoryResponseDTO({
    @JsonKey(name: 'id') required String id,
    @JsonKey(name: 'name') required String name,
    @JsonKey(name: 'description') required String description,
    @JsonKey(name: 'photoUrl') required String photoUrl,
    @JsonKey(name: 'createdAt') required String createdAt,
  }) = _StoryResponseDTO;

  factory StoryResponseDTO.fromJson(Map<String, dynamic> json) =>
      _$StoryResponseDTOFromJson(json);
}
