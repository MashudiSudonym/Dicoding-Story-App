// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'todo_list_service.dart';

// **************************************************************************
// ChopperGenerator
// **************************************************************************

// ignore_for_file: always_put_control_body_on_new_line, always_specify_types, prefer_const_declarations, unnecessary_brace_in_string_interps
class _$TodoListService extends TodoListService {
  _$TodoListService([ChopperClient? client]) {
    if (client == null) return;
    this.client = client;
  }

  @override
  final definitionType = TodoListService;

  @override
  Future<Response<dynamic>> getTodoList() {
    final Uri $url = Uri.parse('stories');
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<dynamic, dynamic>($request);
  }
}
