// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:story_app/common/di/injection.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/common/util/extension.dart';
import 'package:story_app/login/domain/use_case/user_login_use_case.dart';

void main() async {
  await configureDependencies();
  setupLogging();

  //final loginServiceApi = getIt<LoginServiceApi>();
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

  // final loginRepository = getIt<LoginRepository>();
  // final postLogin =
  //     await loginRepository.postLogin('masrobot6969@gmail.com', '123tes');
  //
  // if (postLogin.success) {
  //   Constants.logger.d(postLogin.value?.loginResult?.token);
  // } else {
  //   Constants.logger.d(postLogin.msg);
  //   Constants.logger.d(postLogin.error);
  // }

  final userLoginUseCase = getIt<UserLoginUseCase>();

  final result = await userLoginUseCase('masrobot6969@gmail.com', 'sad');

  if (result.success) {
    Constants.logger.d(result.value?.loginResult?.token);
  } else {
    Constants.logger.d(result.message);
    Constants.logger.d(result.error);
  }

  Constants.logger.d('tes');
}
