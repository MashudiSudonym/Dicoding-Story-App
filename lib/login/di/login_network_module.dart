import 'package:chopper/chopper.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/login/data/remote/login_service_api.dart';

@module
abstract class LoginNetworkModule {
  @lazySingleton
  LoginServiceApi loginServiceApi(ChopperClient chopperClient) =>
      LoginServiceApi.create(chopperClient);
}
