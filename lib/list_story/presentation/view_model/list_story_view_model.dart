import 'package:flutter/foundation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/list_story/presentation/bloc/list_story_bloc.dart';

@injectable
class ListStoryViewModel extends ChangeNotifier {
  final ListStoryBloc _listStoryBloc;

  ListStoryViewModel(this._listStoryBloc);

  ListStoryState get listStoryState => _listStoryBloc.state;

  void getListStory() => _listStoryBloc.add(const LoadListStory());

  @override
  void dispose() {
    super.dispose();
    _listStoryBloc.close();
  }
}
