// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:story_app/common/di/injection.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/common/util/extention.dart';
import 'package:story_app/login/data/remote/login_service_api.dart';
import 'package:story_app/login/data/repository/login_repository_impl.dart';

void main() async {
  await configureDependencies();
  setupLogging();

  final loginServiceApi = getIt<LoginServiceApi>();
  //
  // final response =
  //     await loginServiceApi.postLogin('masrobot6969@gmail.com', '123tes');
  //
  // Constants.logger.d(response.base.statusCode);
  //
  // if (response.statusCode == 200) {
  //   final loginResponseSuccess =
  //       LoginResponseDTO.fromJson(response.body as Map<String, Object?>);
  //
  //   Constants.logger.d(loginResponseSuccess.toLoginResponse());
  // } else {
  //   final loginResponseError =
  //       LoginResponseDTO.fromJson(response.error as Map<String, Object?>);
  //
  //   Constants.logger.e(loginResponseError.toLoginResponse());
  // }

  LoginRepositoryImpl(loginServiceApi)
      .postLogin('masrobot6969@gmail.com', '123tes')
      .then((value) {
    if (value.success) {
      Constants.logger.d(value.value);
    }
  });

  Constants.logger.d('tes');
}
