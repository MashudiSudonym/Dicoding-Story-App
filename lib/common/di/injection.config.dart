// GENERATED CODE - DO NOT MODIFY BY HAND

// **************************************************************************
// InjectableConfigGenerator
// **************************************************************************

// ignore_for_file: no_leading_underscores_for_library_prefixes
import 'package:chopper/chopper.dart' as _i8;
import 'package:get_it/get_it.dart' as _i1;
import 'package:hive/hive.dart' as _i3;
import 'package:injectable/injectable.dart' as _i2;
import 'package:story_app/authentication_check/data/repository/authentication_check_repository_impl.dart'
    as _i7;
import 'package:story_app/authentication_check/domain/repository/authentication_check_repository.dart'
    as _i6;
import 'package:story_app/common/di/network_module.dart' as _i15;
import 'package:story_app/data_store/data/repository/data_store_repository_impl.dart'
    as _i5;
import 'package:story_app/data_store/di/data_store_module.dart' as _i17;
import 'package:story_app/data_store/domain/repository/data_store_repository.dart'
    as _i4;
import 'package:story_app/login/data/remote/login_service_api.dart' as _i9;
import 'package:story_app/login/data/repository/login_repository_impl.dart'
    as _i11;
import 'package:story_app/login/di/login_network_module.dart' as _i16;
import 'package:story_app/login/domain/repository/login_repository.dart'
    as _i10;
import 'package:story_app/login/domain/use_case/user_login_use_case.dart'
    as _i12;
import 'package:story_app/login/presentation/bloc/login_bloc.dart' as _i13;
import 'package:story_app/login/presentation/view_model/login_view_model.dart'
    as _i14;

/// ignore_for_file: unnecessary_lambdas
/// ignore_for_file: lines_longer_than_80_chars
extension GetItInjectableX on _i1.GetIt {
  /// initializes the registration of main-scope dependencies inside of [GetIt]
  Future<_i1.GetIt> init({
    String? environment,
    _i2.EnvironmentFilter? environmentFilter,
  }) async {
    final gh = _i2.GetItHelper(
      this,
      environment,
      environmentFilter,
    );
    final dataStoreModule = _$DataStoreModule();
    final networkModule = _$NetworkModule();
    final loginNetworkModule = _$LoginNetworkModule();
    await gh.factoryAsync<_i3.BoxCollection>(
      () => dataStoreModule.storyAppCollection(),
      preResolve: true,
    );
    gh.factory<_i4.DataStoreRepository>(
        () => _i5.DataStoreRepositoryImpl(gh<_i3.BoxCollection>()));
    gh.factory<String>(
      () => networkModule.baseUrl,
      instanceName: 'BaseUrl',
    );
    gh.factory<_i6.AuthenticationCheckRepository>(() =>
        _i7.AuthenticationCheckRepositoryImpl(gh<_i4.DataStoreRepository>()));
    gh.lazySingleton<_i8.ChopperClient>(
        () => networkModule.chopperClient(gh<String>(instanceName: 'BaseUrl')));
    gh.lazySingleton<_i9.LoginServiceApi>(
        () => loginNetworkModule.loginServiceApi(gh<_i8.ChopperClient>()));
    gh.factory<_i10.LoginRepository>(
        () => _i11.LoginRepositoryImpl(gh<_i9.LoginServiceApi>()));
    gh.factory<_i12.UserLoginUseCase>(
        () => _i12.UserLoginUseCase(gh<_i10.LoginRepository>()));
    gh.factory<_i13.LoginBloc>(
        () => _i13.LoginBloc(gh<_i12.UserLoginUseCase>()));
    gh.factory<_i14.LoginViewModel>(
        () => _i14.LoginViewModel(loginBloc: gh<_i13.LoginBloc>()));
    return this;
  }
}

class _$NetworkModule extends _i15.NetworkModule {}

class _$LoginNetworkModule extends _i16.LoginNetworkModule {}

class _$DataStoreModule extends _i17.DataStoreModule {}
