import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/domain/model/authentication_token.dart';
import 'package:story_app/authentication_check/domain/model/authentication_status.dart';
import 'package:story_app/authentication_check/domain/repository/authentication_check_repository.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/data_store/domain/repository/data_store_repository.dart';

@Injectable(as: AuthenticationCheckRepository)
class AuthenticationCheckRepositoryImpl extends AuthenticationCheckRepository {
  final DataStoreRepository _dataStoreRepository;

  AuthenticationCheckRepositoryImpl(this._dataStoreRepository);

  @override
  Future<Resource<AuthenticationStatus>> checkAuthentication() async {
    Resource<AuthenticationStatus> result;
    final getToken = await _dataStoreRepository.getLoginToken();

    if (getToken.isNotEmpty) {
      result = const Resource.success(
        AuthenticationStatus(isAuthenticated: true),
      );
    } else {
      result = const Resource.error(
        'token is empty',
        AuthenticationStatus(isAuthenticated: false),
      );
    }

    return result;
  }

  @override
  Future<Resource<AuthenticationToken>> getToken() async {
    Resource<AuthenticationToken> result;
    final getToken = await _dataStoreRepository.getLoginToken();

    if (getToken.isNotEmpty) {
      result = Resource.success(AuthenticationToken(token: getToken));
    } else {
      result = const Resource.error(
        'token is empty',
        AuthenticationToken(token: ''),
      );
    }

    return result;
  }

  @override
  Future<void> saveToken(String token) async {
    await _dataStoreRepository.postLoginToken(token);
  }
}
