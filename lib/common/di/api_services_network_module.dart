import 'package:chopper/chopper.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/common/data/remote/api_services.dart';

@module
abstract class ApiServicesNetworkModule {
  @lazySingleton
  ApiServices loginServiceApi(ChopperClient chopperClient) =>
      ApiServices.create(chopperClient);
}
