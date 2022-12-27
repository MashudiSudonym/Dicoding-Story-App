import 'dart:async';
import 'package:chopper/chopper.dart';
import 'package:story_app/common/util/constants.dart';

part 'todo_list_service.chopper.dart';

@ChopperApi(baseUrl: Constants.storiesApi)
abstract class TodoListService extends ChopperService {
  static TodoListService create([ChopperClient? client]) =>
      _$TodoListService(client);

  @Get()
  Future<Response> getTodoList();
}
