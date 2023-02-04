// GENERATED CODE - DO NOT MODIFY BY HAND

// **************************************************************************
// InjectableConfigGenerator
// **************************************************************************

// ignore_for_file: no_leading_underscores_for_library_prefixes
import 'package:chopper/chopper.dart' as _i11;
import 'package:get_it/get_it.dart' as _i1;
import 'package:hive/hive.dart' as _i3;
import 'package:injectable/injectable.dart' as _i2;
import 'package:story_app/authentication_check/data/repository/authentication_check_repository_impl.dart'
    as _i9;
import 'package:story_app/authentication_check/domain/repository/authentication_check_repository.dart'
    as _i8;
import 'package:story_app/authentication_check/domain/use_case/check_authentication_use_case/check_authentication_use_case.dart'
    as _i10;
import 'package:story_app/authentication_check/domain/use_case/get_token_from_data_store_use_case/get_token_from_data_store_use_case.dart'
    as _i12;
import 'package:story_app/authentication_check/domain/use_case/logout_use_case/logout_use_case.dart'
    as _i13;
import 'package:story_app/authentication_check/domain/use_case/save_token_to_data_store_use_case/save_token_to_data_store_use_case.dart'
    as _i14;
import 'package:story_app/authentication_check/presentation/bloc/authentication_check_bloc.dart'
    as _i16;
import 'package:story_app/authentication_check/presentation/view_model/authentication_check_view_model.dart'
    as _i17;
import 'package:story_app/common/data/remote/api_services.dart' as _i15;
import 'package:story_app/common/di/api_services_network_module.dart' as _i28;
import 'package:story_app/common/di/network_module.dart' as _i26;
import 'package:story_app/data_store/data/repository/data_store_repository_impl.dart'
    as _i5;
import 'package:story_app/data_store/di/data_store_module.dart' as _i27;
import 'package:story_app/data_store/domain/repository/data_store_repository.dart'
    as _i4;
import 'package:story_app/login/data/repository/login_repository_impl.dart'
    as _i19;
import 'package:story_app/login/domain/repository/login_repository.dart'
    as _i18;
import 'package:story_app/login/domain/use_case/user_login_use_case.dart'
    as _i22;
import 'package:story_app/login/presentation/bloc/login_bloc.dart' as _i24;
import 'package:story_app/login/presentation/view_model/login_view_model.dart'
    as _i25;
import 'package:story_app/register/data/repository/register_repository_impl.dart'
    as _i21;
import 'package:story_app/register/domain/repository/register_repository.dart'
    as _i20;
import 'package:story_app/register/domain/use_case/user_register_use_case.dart'
    as _i23;
import 'package:story_app/register/presentation/bloc/register_bloc.dart' as _i7;
import 'package:story_app/register/presentation/view_model/register_view_model.dart'
    as _i6;

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
    gh.factory<_i6.RegisterViewModel>(
        () => _i6.RegisterViewModel(gh<_i7.RegisterBloc>()));
    gh.factory<String>(
      () => networkModule.baseUrl,
      instanceName: 'BaseUrl',
    );
    gh.factory<_i8.AuthenticationCheckRepository>(() =>
        _i9.AuthenticationCheckRepositoryImpl(gh<_i4.DataStoreRepository>()));
    gh.factory<_i10.CheckAuthenticationUseCase>(() =>
        _i10.CheckAuthenticationUseCase(
            gh<_i8.AuthenticationCheckRepository>()));
    gh.lazySingleton<_i11.ChopperClient>(
        () => networkModule.chopperClient(gh<String>(instanceName: 'BaseUrl')));
    gh.factory<_i12.GetTokenFromDataStoreUseCase>(() =>
        _i12.GetTokenFromDataStoreUseCase(
            gh<_i8.AuthenticationCheckRepository>()));
    gh.factory<_i13.LogoutUseCase>(
        () => _i13.LogoutUseCase(gh<_i8.AuthenticationCheckRepository>()));
    gh.factory<_i14.SaveTokenToDataStoreUseCase>(() =>
        _i14.SaveTokenToDataStoreUseCase(
            gh<_i8.AuthenticationCheckRepository>()));
    gh.lazySingleton<_i15.ApiServices>(() =>
        apiServicesNetworkModule.loginServiceApi(gh<_i11.ChopperClient>()));
    gh.factory<_i16.AuthenticationCheckBloc>(() =>
        _i16.AuthenticationCheckBloc(gh<_i10.CheckAuthenticationUseCase>()));
    gh.factory<_i17.AuthenticationCheckViewModel>(() =>
        _i17.AuthenticationCheckViewModel(gh<_i16.AuthenticationCheckBloc>()));
    gh.factory<_i18.LoginRepository>(
        () => _i19.LoginRepositoryImpl(gh<_i15.ApiServices>()));
    gh.factory<_i20.RegisterRepository>(
        () => _i21.RegisterRepositoryImpl(gh<_i15.ApiServices>()));
    gh.factory<_i22.UserLoginUseCase>(() => _i22.UserLoginUseCase(
          gh<_i18.LoginRepository>(),
          gh<_i14.SaveTokenToDataStoreUseCase>(),
        ));
    gh.factory<_i23.UserRegisterUseCase>(
        () => _i23.UserRegisterUseCase(gh<_i20.RegisterRepository>()));
    gh.factory<_i24.LoginBloc>(
        () => _i24.LoginBloc(gh<_i22.UserLoginUseCase>()));
    gh.factory<_i25.LoginViewModel>(
        () => _i25.LoginViewModel(gh<_i24.LoginBloc>()));
    return this;
  }
}

class _$NetworkModule extends _i26.NetworkModule {}

class _$DataStoreModule extends _i27.DataStoreModule {}

class _$ApiServicesNetworkModule extends _i28.ApiServicesNetworkModule {}
