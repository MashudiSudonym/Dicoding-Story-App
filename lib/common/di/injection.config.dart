// GENERATED CODE - DO NOT MODIFY BY HAND

// **************************************************************************
// InjectableConfigGenerator
// **************************************************************************

// ignore_for_file: no_leading_underscores_for_library_prefixes
import 'package:chopper/chopper.dart' as _i3;
import 'package:get_it/get_it.dart' as _i1;
import 'package:injectable/injectable.dart' as _i2;
import 'package:story_app/common/di/network_module.dart' as _i5;
import 'package:story_app/login/data/remote/login_service_api.dart' as _i4;
import 'package:story_app/login/di/login_network_module.dart' as _i6;

/// ignore_for_file: unnecessary_lambdas
/// ignore_for_file: lines_longer_than_80_chars
extension GetItInjectableX on _i1.GetIt {
  /// initializes the registration of main-scope dependencies inside of [GetIt]
  _i1.GetIt init({
    String? environment,
    _i2.EnvironmentFilter? environmentFilter,
  }) {
    final gh = _i2.GetItHelper(
      this,
      environment,
      environmentFilter,
    );
    final networkModule = _$NetworkModule();
    final loginNetworkModule = _$LoginNetworkModule();
    gh.factory<String>(
      () => networkModule.baseUrl,
      instanceName: 'BaseUrl',
    );
    gh.lazySingleton<_i3.ChopperClient>(
        () => networkModule.chopperClient(gh<String>(instanceName: 'BaseUrl')));
    gh.lazySingleton<_i4.LoginServiceApi>(
        () => loginNetworkModule.loginServiceApi(gh<_i3.ChopperClient>()));
    return this;
  }
}

class _$NetworkModule extends _i5.NetworkModule {}

class _$LoginNetworkModule extends _i6.LoginNetworkModule {}
