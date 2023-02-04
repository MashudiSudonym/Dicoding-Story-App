import 'package:flutter/foundation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/register/presentation/bloc/register_bloc.dart';

@injectable
class RegisterViewModel extends ChangeNotifier {
  final RegisterBloc registerBloc;

  RegisterViewModel(this.registerBloc);

  void submitRegister(String? name, String? email, String? password) {
    registerBloc.add(
      RegisterEvent.registerButtonPressed(
        name: name,
        email: email,
        password: password,
      ),
    );
  }

  RegisterState get registerState => registerBloc.state;

  @override
  void dispose() {
    super.dispose();
    registerBloc.close();
  }
}
