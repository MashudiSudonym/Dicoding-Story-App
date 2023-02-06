part of 'list_story_bloc.dart';

@freezed
class ListStoryState with _$ListStoryState {
  const factory ListStoryState.loading() = Loading;

  const factory ListStoryState.success(ListStoryResponse listStoryResponse) =
      Success;

  const factory ListStoryState.failure(String message) = Failure;
}
