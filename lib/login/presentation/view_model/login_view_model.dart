import 'package:flutter/foundation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/login/presentation/bloc/login_bloc.dart';

@injectable
class LoginViewModel extends ChangeNotifier {
  final LoginBloc loginBloc;

  LoginViewModel(this.loginBloc);

  void submitLogin({String? email, String? password}) {
    loginBloc.add(
      LoginEvent.loginButtonPressed(email: email, password: password),
    );
  }

  LoginState get loginState => loginBloc.state;

  @override
  void dispose() {
    super.dispose();
    loginBloc.close();
  }
}
