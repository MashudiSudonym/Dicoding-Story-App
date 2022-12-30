import 'package:story_app/common/util/resource.dart';
import 'package:story_app/login/domain/model/login_response.dart';

abstract class LoginRepository {
  Future<Resource<LoginResponse>> postLogin(String email, String password);
}
