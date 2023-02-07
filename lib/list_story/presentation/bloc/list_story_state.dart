part of 'list_story_bloc.dart';

@freezed
class ListStoryState with _$ListStoryState {
  const factory ListStoryState.loading() = _Loading;

  const factory ListStoryState.success(ListStoryResponse listStoryResponse) =
      _Success;

  const factory ListStoryState.failure(String message) = _Failure;
}
