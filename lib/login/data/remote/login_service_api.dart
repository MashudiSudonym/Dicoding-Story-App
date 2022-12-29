import 'dart:async';

import 'package:chopper/chopper.dart';
import 'package:story_app/common/util/constants.dart';

part 'login_service_api.chopper.dart';

@ChopperApi(baseUrl: Constants.loginApi)
abstract class LoginServiceApi extends ChopperService {
  static LoginServiceApi create([ChopperClient? client]) =>
      _$LoginServiceApi(client);

  @FactoryConverter(
    request: FormUrlEncodedConverter.requestFactory,
  )
  @Post()
  Future<Response> postLogin(
    @Field(Constants.email) String email,
    @Field(Constants.password) String password,
  );
}
