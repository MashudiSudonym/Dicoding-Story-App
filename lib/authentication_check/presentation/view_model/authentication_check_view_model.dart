import 'package:flutter/foundation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/presentation/bloc/authentication_check_bloc.dart';

@injectable
class AuthenticationCheckViewModel extends ChangeNotifier {
  final AuthenticationCheckBloc _authenticationCheckBloc;

  AuthenticationCheckViewModel(this._authenticationCheckBloc);

  AuthenticationCheckState get authenticationCheckState =>
      _authenticationCheckBloc.state;

  @override
  void dispose() {
    _authenticationCheckBloc.close();
    super.dispose();
  }
}
