import 'package:chopper/chopper.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/constants.dart';

@module
abstract class NetworkModule {
  @Named('BaseUrl')
  String get baseUrl => Constants.baseUrlApi;

  @lazySingleton
  ChopperClient chopperClient(@Named('BaseUrl') String url) => ChopperClient(
        baseUrl: Uri.parse(url),
        interceptors: [
          HttpLoggingInterceptor(),
        ],
        converter: const JsonConverter(),
        errorConverter: const JsonConverter(),
      );
}
