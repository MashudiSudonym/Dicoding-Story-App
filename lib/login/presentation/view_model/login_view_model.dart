import 'package:flutter/foundation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/login/presentation/bloc/login_bloc.dart';

@injectable
class LoginViewModel extends ChangeNotifier {
  final LoginBloc _loginBloc;

  LoginViewModel(this._loginBloc);

  void submitLogin({String? email, String? password}) {
    _loginBloc.add(
      LoginEvent.loginButtonPressed(email: email, password: password),
    );
  }

  LoginState get loginState => _loginBloc.state;

  @override
  void dispose() {
    super.dispose();
    _loginBloc.close();
  }
}
