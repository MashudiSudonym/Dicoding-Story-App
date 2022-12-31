import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/login/domain/model/login_response.dart';
import 'package:story_app/login/domain/repository/login_repository.dart';

@injectable
class UserLoginUseCase {
  final LoginRepository _loginRepository;

  UserLoginUseCase(this._loginRepository);

  Future<Resource<LoginResponse>> call(String email, String password) async {
    return _loginRepository.postLogin(email, password);
  }
}
