import 'package:bloc/bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/list_story/domain/model/list_story_response.dart';
import 'package:story_app/list_story/domain/use_case/show_list_story_use_case.dart';

part 'list_story_bloc.freezed.dart';
part 'list_story_event.dart';
part 'list_story_state.dart';

@injectable
class ListStoryBloc extends Bloc<ListStoryEvent, ListStoryState> {
  final ShowListStoryUseCase _showListStoryUseCase;

  ListStoryBloc(this._showListStoryUseCase) : super(const _Loading());

  Stream<ListStoryState> mapEventToState(ListStoryEvent event) async* {
    if (event is _LoadListStory) {
      yield* _mapLoadListStoryToState();
    }
  }

  Stream<ListStoryState> _mapLoadListStoryToState() async* {
    yield const ListStoryState.loading();

    final either = await _showListStoryUseCase();

    yield* either.fold(
      (failure) async* {
        yield ListStoryState.failure(failure.message);
      },
      (response) async* {
        if (response.error) {
          yield ListStoryState.failure(response.message);
        } else {
          yield ListStoryState.success(response);
        }
      },
    );
  }
}
