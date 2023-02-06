// GENERATED CODE - DO NOT MODIFY BY HAND

// **************************************************************************
// InjectableConfigGenerator
// **************************************************************************

// ignore_for_file: no_leading_underscores_for_library_prefixes
import 'package:chopper/chopper.dart' as _i9;
import 'package:get_it/get_it.dart' as _i1;
import 'package:hive/hive.dart' as _i3;
import 'package:injectable/injectable.dart' as _i2;
import 'package:story_app/authentication_check/data/repository/authentication_check_repository_impl.dart'
    as _i7;
import 'package:story_app/authentication_check/domain/repository/authentication_check_repository.dart'
    as _i6;
import 'package:story_app/authentication_check/domain/use_case/check_authentication_use_case/check_authentication_use_case.dart'
    as _i8;
import 'package:story_app/authentication_check/domain/use_case/get_token_from_data_store_use_case/get_token_from_data_store_use_case.dart'
    as _i10;
import 'package:story_app/authentication_check/domain/use_case/logout_use_case/logout_use_case.dart'
    as _i11;
import 'package:story_app/authentication_check/domain/use_case/save_token_to_data_store_use_case/save_token_to_data_store_use_case.dart'
    as _i12;
import 'package:story_app/authentication_check/presentation/bloc/authentication_check_bloc.dart'
    as _i14;
import 'package:story_app/authentication_check/presentation/view_model/authentication_check_view_model.dart'
    as _i15;
import 'package:story_app/common/data/remote/api_services.dart' as _i13;
import 'package:story_app/common/di/api_services_network_module.dart' as _i31;
import 'package:story_app/common/di/network_module.dart' as _i32;
import 'package:story_app/data_store/data/repository/data_store_repository_impl.dart'
    as _i5;
import 'package:story_app/data_store/di/data_store_module.dart' as _i33;
import 'package:story_app/data_store/domain/repository/data_store_repository.dart'
    as _i4;
import 'package:story_app/list_story/data/repository/list_story_repository_impl.dart'
    as _i17;
import 'package:story_app/list_story/domain/repository/list_story_repository.dart'
    as _i16;
import 'package:story_app/list_story/domain/use_case/show_list_story_use_case.dart'
    as _i22;
import 'package:story_app/list_story/presentation/bloc/list_story_bloc.dart'
    as _i25;
import 'package:story_app/list_story/presentation/view_model/list_story_view_model.dart'
    as _i26;
import 'package:story_app/login/data/repository/login_repository_impl.dart'
    as _i19;
import 'package:story_app/login/domain/repository/login_repository.dart'
    as _i18;
import 'package:story_app/login/domain/use_case/user_login_use_case.dart'
    as _i23;
import 'package:story_app/login/presentation/bloc/login_bloc.dart' as _i27;
import 'package:story_app/login/presentation/view_model/login_view_model.dart'
    as _i28;
import 'package:story_app/register/data/repository/register_repository_impl.dart'
    as _i21;
import 'package:story_app/register/domain/repository/register_repository.dart'
    as _i20;
import 'package:story_app/register/domain/use_case/user_register_use_case.dart'
    as _i24;
import 'package:story_app/register/presentation/bloc/register_bloc.dart'
    as _i29;
import 'package:story_app/register/presentation/view_model/register_view_model.dart'
    as _i30;

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
    gh.factory<_i8.CheckAuthenticationUseCase>(() =>
        _i8.CheckAuthenticationUseCase(
            gh<_i6.AuthenticationCheckRepository>()));
    gh.lazySingleton<_i9.ChopperClient>(
        () => networkModule.chopperClient(gh<String>(instanceName: 'BaseUrl')));
    gh.factory<_i10.GetTokenFromDataStoreUseCase>(() =>
        _i10.GetTokenFromDataStoreUseCase(
            gh<_i6.AuthenticationCheckRepository>()));
    gh.factory<_i11.LogoutUseCase>(
        () => _i11.LogoutUseCase(gh<_i6.AuthenticationCheckRepository>()));
    gh.factory<_i12.SaveTokenToDataStoreUseCase>(() =>
        _i12.SaveTokenToDataStoreUseCase(
            gh<_i6.AuthenticationCheckRepository>()));
    gh.lazySingleton<_i13.ApiServices>(() =>
        apiServicesNetworkModule.loginServiceApi(gh<_i9.ChopperClient>()));
    gh.factory<_i14.AuthenticationCheckBloc>(() =>
        _i14.AuthenticationCheckBloc(gh<_i8.CheckAuthenticationUseCase>()));
    gh.factory<_i15.AuthenticationCheckViewModel>(() =>
        _i15.AuthenticationCheckViewModel(gh<_i14.AuthenticationCheckBloc>()));
    gh.factory<_i16.ListStoryRepository>(
        () => _i17.ListStoryRepositoryImpl(gh<_i13.ApiServices>()));
    gh.factory<_i18.LoginRepository>(
        () => _i19.LoginRepositoryImpl(gh<_i13.ApiServices>()));
    gh.factory<_i20.RegisterRepository>(
        () => _i21.RegisterRepositoryImpl(gh<_i13.ApiServices>()));
    gh.factory<_i22.ShowListStoryUseCase>(() => _i22.ShowListStoryUseCase(
          gh<_i16.ListStoryRepository>(),
          gh<_i10.GetTokenFromDataStoreUseCase>(),
        ));
    gh.factory<_i23.UserLoginUseCase>(() => _i23.UserLoginUseCase(
          gh<_i18.LoginRepository>(),
          gh<_i12.SaveTokenToDataStoreUseCase>(),
        ));
    gh.factory<_i24.UserRegisterUseCase>(
        () => _i24.UserRegisterUseCase(gh<_i20.RegisterRepository>()));
    gh.factory<_i25.ListStoryBloc>(
        () => _i25.ListStoryBloc(gh<_i22.ShowListStoryUseCase>()));
    gh.factory<_i26.ListStoryViewModel>(
        () => _i26.ListStoryViewModel(gh<_i25.ListStoryBloc>()));
    gh.factory<_i27.LoginBloc>(
        () => _i27.LoginBloc(gh<_i23.UserLoginUseCase>()));
    gh.factory<_i28.LoginViewModel>(
        () => _i28.LoginViewModel(gh<_i27.LoginBloc>()));
    gh.factory<_i29.RegisterBloc>(
        () => _i29.RegisterBloc(gh<_i24.UserRegisterUseCase>()));
    gh.factory<_i30.RegisterViewModel>(
        () => _i30.RegisterViewModel(gh<_i29.RegisterBloc>()));
    return this;
  }
}

class _$ApiServicesNetworkModule extends _i31.ApiServicesNetworkModule {}

class _$NetworkModule extends _i32.NetworkModule {}

class _$DataStoreModule extends _i33.DataStoreModule {}
