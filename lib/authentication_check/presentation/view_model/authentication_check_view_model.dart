import 'package:flutter/foundation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/presentation/bloc/authentication_check_bloc.dart';

@injectable
class AuthenticationCheckViewModel extends ChangeNotifier {
  final AuthenticationCheckBloc authenticationCheckBloc;

  AuthenticationCheckViewModel(this.authenticationCheckBloc);

  AuthenticationCheckState get authenticationCheckState =>
      authenticationCheckBloc.state;

  @override
  void dispose() {
    authenticationCheckBloc.close();
    super.dispose();
  }
}
