import 'dart:async';

import 'package:chopper/chopper.dart';
import 'package:story_app/common/util/constants.dart';

part 'api_services.chopper.dart';

@ChopperApi()
abstract class ApiServices extends ChopperService {
  static ApiServices create([ChopperClient? client]) => _$ApiServices(client);

  // Login Api Services
  @FactoryConverter(
    request: FormUrlEncodedConverter.requestFactory,
  )
  @Post(path: Constants.loginApi)
  Future<Response> postLogin(
    @Field(Constants.email) String email,
    @Field(Constants.password) String password,
  );

  // Register Api Services
  @FactoryConverter(
    request: FormUrlEncodedConverter.requestFactory,
  )
  @Post(path: Constants.registerApi)
  Future<Response> postRegister(
    @Field(Constants.name) String name,
    @Field(Constants.email) String email,
    @Field(Constants.password) String password,
  );
}
