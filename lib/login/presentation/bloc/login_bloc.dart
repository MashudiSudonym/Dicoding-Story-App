import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/login/domain/model/login_response.dart';
import 'package:story_app/login/domain/use_case/user_login_use_case.dart';

part 'login_bloc.freezed.dart';
part 'login_event.dart';
part 'login_state.dart';

@Injectable()
class LoginBloc extends Bloc<LoginEvent, LoginState> {
  final UserLoginUseCase _userLoginUseCase;

  LoginBloc(this._userLoginUseCase) : super(const LoginState.initial());

  Stream<LoginState> mapEventToState(LoginEvent event) async* {
    if (event is _LoginButtonPressed) {
      yield const LoginState.loading();
      final either =
          await _userLoginUseCase(event.email ?? "", event.password ?? "");
      yield either.fold(
        (failure) => LoginState.failure(failure.message),
        (loginResponse) => LoginState.success(loginResponse),
      );
    }
  }
}
