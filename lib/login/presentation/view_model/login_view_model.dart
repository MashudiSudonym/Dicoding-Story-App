import 'package:injectable/injectable.dart';
import 'package:story_app/login/domain/use_case/user_login_use_case.dart';

@injectable
class LoginViewModel {
  final UserLoginUseCase _userLoginUseCase;

  LoginViewModel(this._userLoginUseCase);

  void init() async {
    final a = await _userLoginUseCase('masrobot6969@gmail.com', '123tes');
  }
}
