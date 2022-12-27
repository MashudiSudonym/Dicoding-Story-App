// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:story_app/common/di/injection.dart';

void main() async {
  await configureDependencies();

  // final chopper = getIt<ChopperClient>();
  //
  // final response = await TodoListService.create(chopper).getTodoList();
  //
  // Constants.logger.d(response.error);
  //
  // final response2 = getIt<Response>();
  //
  // Constants.logger.d(response2.error);
}
