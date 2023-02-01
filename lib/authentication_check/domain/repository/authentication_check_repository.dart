import 'package:story_app/authentication_check/domain/model/authentication_status.dart';
import 'package:story_app/authentication_check/domain/model/authentication_token.dart';
import 'package:story_app/common/util/resource.dart';

abstract class AuthenticationCheckRepository {
  Future<void> saveToken(String token);
  Future<Resource<AuthenticationStatus>> checkAuthentication();
  Future<Resource<AuthenticationToken>> getToken();
}
