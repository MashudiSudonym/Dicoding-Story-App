// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:story_app/authentication_check/domain/model/authentication_status.dart';
import 'package:story_app/authentication_check/domain/model/authentication_token.dart';
import 'package:story_app/authentication_check/domain/use_case/check_authentication_use_case/check_authentication_use_case.dart';
import 'package:story_app/authentication_check/domain/use_case/get_token_from_data_store_use_case/get_token_from_data_store_use_case.dart';
import 'package:story_app/common/di/injection.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/common/util/extension.dart';
import 'package:story_app/list_story/domain/model/list_story_response.dart';
import 'package:story_app/list_story/domain/use_case/show_list_story_use_case.dart';
import 'package:story_app/login/domain/model/login_response.dart';
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

  final failureOrResponse =
      await userLoginUseCase('masrobot6969@gmail.com', '123tes');

  final a = failureOrResponse.fold(
    (failure) => LoginResponse(error: true, message: failure.message),
    (response) => response,
  );

  Constants.logger.d(a.message);

  // final hive = getIt<BoxCollection>();

  // hive.boxNames.add('example');
  // final exampleBox = await hive.openBox('example');
  // await exampleBox.put('key', 'val2');
  // final exampleBoxData = await exampleBox.get('key');

  // Constants.logger.d(exampleBoxData);

  // final dataStoreRepository = getIt<DataStoreRepository>();

  // dataStoreRepository.postLoginToken('token');

  // final getLoginToken = await dataStoreRepository.getLoginToken();

  // Constants.logger.d(getLoginToken);

  // final authenticationCheckRepository = getIt<AuthenticationCheckRepository>();

  // await authenticationCheckRepository.saveToken('token');

  // final a = await authenticationCheckRepository.getToken();

  // if (a.data?.token != '') {
  //   Constants.logger.d(a.data?.token);
  // } else {
  //   Constants.logger.e(a.message);
  // }

  final getTokenFromDataStoreUseCase = getIt<GetTokenFromDataStoreUseCase>();

  final failureOrResponseGetToken = await getTokenFromDataStoreUseCase();

  final resultGetToken = failureOrResponseGetToken.fold(
    (failure) => const AuthenticationToken(token: Constants.blankString),
    (response) => response,
  );

  Constants.logger.d(resultGetToken.token);

  final checkAuthenticationUseCase = getIt<CheckAuthenticationUseCase>();

  final failureOrResponseAuth = await checkAuthenticationUseCase();

  final resultAuth = failureOrResponseAuth.fold(
    (failure) => const AuthenticationStatus(
      isAuthenticated: !Constants.isAuthenticated,
    ),
    (response) => response,
  );

  Constants.logger.d(resultAuth.isAuthenticated);

  final showListStoryUseCase = getIt<ShowListStoryUseCase>();

  final showListStoryResponse = await showListStoryUseCase();

  final resultShowListStory = showListStoryResponse.fold(
    (failure) => ListStoryResponse(
      error: true,
      message: failure.message,
    ),
    (response) => response,
  );

  Constants.logger.d(resultShowListStory);
}
