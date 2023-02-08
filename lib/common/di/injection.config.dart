// GENERATED CODE - DO NOT MODIFY BY HAND

// **************************************************************************
// InjectableConfigGenerator
// **************************************************************************

// ignore_for_file: no_leading_underscores_for_library_prefixes
import 'dart:io' as _i3;

import 'package:chopper/chopper.dart' as _i5;
import 'package:get_it/get_it.dart' as _i1;
import 'package:hive/hive.dart' as _i4;
import 'package:injectable/injectable.dart' as _i2;
import 'package:story_app/authentication_check/data/repository/authentication_check_repository_impl.dart'
    as _i10;
import 'package:story_app/authentication_check/domain/repository/authentication_check_repository.dart'
    as _i9;
import 'package:story_app/authentication_check/domain/use_case/check_authentication_use_case/check_authentication_use_case.dart'
    as _i11;
import 'package:story_app/authentication_check/domain/use_case/get_token_from_data_store_use_case/get_token_from_data_store_use_case.dart'
    as _i12;
import 'package:story_app/authentication_check/domain/use_case/logout_use_case/logout_use_case.dart'
    as _i17;
import 'package:story_app/authentication_check/domain/use_case/save_token_to_data_store_use_case/save_token_to_data_store_use_case.dart'
    as _i20;
import 'package:story_app/authentication_check/presentation/bloc/authentication_check_bloc.dart'
    as _i24;
import 'package:story_app/common/data/remote/api_services.dart' as _i8;
import 'package:story_app/common/di/api_services_network_module.dart' as _i28;
import 'package:story_app/common/di/network_module.dart' as _i29;
import 'package:story_app/data_store/data/repository/data_store_repository_impl.dart'
    as _i7;
import 'package:story_app/data_store/di/data_store_module.dart' as _i30;
import 'package:story_app/data_store/domain/repository/data_store_repository.dart'
    as _i6;
import 'package:story_app/list_story/data/repository/list_story_repository_impl.dart'
    as _i14;
import 'package:story_app/list_story/domain/repository/list_story_repository.dart'
    as _i13;
import 'package:story_app/list_story/domain/use_case/show_list_story_use_case.dart'
    as _i21;
import 'package:story_app/list_story/presentation/bloc/list_story_bloc.dart'
    as _i25;
import 'package:story_app/login/data/repository/login_repository_impl.dart'
    as _i16;
import 'package:story_app/login/domain/repository/login_repository.dart'
    as _i15;
import 'package:story_app/login/domain/use_case/user_login_use_case.dart'
    as _i22;
import 'package:story_app/login/presentation/bloc/login_bloc.dart' as _i26;
import 'package:story_app/register/data/repository/register_repository_impl.dart'
    as _i19;
import 'package:story_app/register/domain/repository/register_repository.dart'
    as _i18;
import 'package:story_app/register/domain/use_case/user_register_use_case.dart'
    as _i23;
import 'package:story_app/register/presentation/bloc/register_bloc.dart'
    as _i27;

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
    final apiServicesNetworkModule = _$ApiServicesNetworkModule();
    gh.factoryAsync<_i3.Directory>(
      () => dataStoreModule.directory,
      instanceName: 'dirPath',
    );
    gh.factory<String>(
      () => networkModule.baseUrl,
      instanceName: 'BaseUrl',
    );
    await gh.factoryAsync<_i4.BoxCollection>(
      () async => dataStoreModule.storyAppCollection(
          await getAsync<_i3.Directory>(instanceName: 'dirPath')),
      preResolve: true,
    );
    gh.lazySingleton<_i5.ChopperClient>(
        () => networkModule.chopperClient(gh<String>(instanceName: 'BaseUrl')));
    gh.factoryAsync<_i6.DataStoreRepository>(() async =>
        _i7.DataStoreRepositoryImpl(await getAsync<_i4.BoxCollection>()));
    gh.lazySingleton<_i8.ApiServices>(() =>
        apiServicesNetworkModule.loginServiceApi(gh<_i5.ChopperClient>()));
    gh.factoryAsync<_i9.AuthenticationCheckRepository>(() async =>
        _i10.AuthenticationCheckRepositoryImpl(
            await getAsync<_i6.DataStoreRepository>()));
    gh.factoryAsync<_i11.CheckAuthenticationUseCase>(() async =>
        _i11.CheckAuthenticationUseCase(
            await getAsync<_i9.AuthenticationCheckRepository>()));
    gh.factoryAsync<_i12.GetTokenFromDataStoreUseCase>(() async =>
        _i12.GetTokenFromDataStoreUseCase(
            await getAsync<_i9.AuthenticationCheckRepository>()));
    gh.factory<_i13.ListStoryRepository>(
        () => _i14.ListStoryRepositoryImpl(gh<_i8.ApiServices>()));
    gh.factory<_i15.LoginRepository>(
        () => _i16.LoginRepositoryImpl(gh<_i8.ApiServices>()));
    gh.factoryAsync<_i17.LogoutUseCase>(() async => _i17.LogoutUseCase(
        await getAsync<_i9.AuthenticationCheckRepository>()));
    gh.factory<_i18.RegisterRepository>(
        () => _i19.RegisterRepositoryImpl(gh<_i8.ApiServices>()));
    gh.factoryAsync<_i20.SaveTokenToDataStoreUseCase>(() async =>
        _i20.SaveTokenToDataStoreUseCase(
            await getAsync<_i9.AuthenticationCheckRepository>()));
    gh.factoryAsync<_i21.ShowListStoryUseCase>(
        () async => _i21.ShowListStoryUseCase(
              gh<_i13.ListStoryRepository>(),
              await getAsync<_i12.GetTokenFromDataStoreUseCase>(),
            ));
    gh.factoryAsync<_i22.UserLoginUseCase>(() async => _i22.UserLoginUseCase(
          gh<_i15.LoginRepository>(),
          await getAsync<_i20.SaveTokenToDataStoreUseCase>(),
        ));
    gh.factory<_i23.UserRegisterUseCase>(
        () => _i23.UserRegisterUseCase(gh<_i18.RegisterRepository>()));
    gh.factoryAsync<_i24.AuthenticationCheckBloc>(() async =>
        _i24.AuthenticationCheckBloc(
            await getAsync<_i11.CheckAuthenticationUseCase>()));
    gh.factoryAsync<_i25.ListStoryBloc>(() async =>
        _i25.ListStoryBloc(await getAsync<_i21.ShowListStoryUseCase>()));
    gh.factoryAsync<_i26.LoginBloc>(
        () async => _i26.LoginBloc(await getAsync<_i22.UserLoginUseCase>()));
    gh.factory<_i27.RegisterBloc>(
        () => _i27.RegisterBloc(gh<_i23.UserRegisterUseCase>()));
    return this;
  }
}

class _$ApiServicesNetworkModule extends _i28.ApiServicesNetworkModule {}

class _$NetworkModule extends _i29.NetworkModule {}

class _$DataStoreModule extends _i30.DataStoreModule {}
