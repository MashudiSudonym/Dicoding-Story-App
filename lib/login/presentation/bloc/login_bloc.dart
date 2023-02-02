import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/login/domain/model/login_response.dart';
import 'package:story_app/login/domain/use_case/user_login_use_case.dart';

part 'login_bloc.freezed.dart';
part 'login_event.dart';
part 'login_state.dart';

@injectable
class LoginBloc extends Bloc<LoginEvent, LoginState> {
  final UserLoginUseCase _userLoginUseCase;

  LoginBloc(this._userLoginUseCase) : super(const LoginState.initial());

  Stream<LoginState> mapEventToState(LoginEvent event) async* {
    if (event is LoginButtonPressed) {
      yield const LoginState.loading();

      final either = await _userLoginUseCase(
        event.email ?? Constants.blankString,
        event.password ?? Constants.blankString,
      );

      yield either.fold(
        (failure) => LoginState.failure(failure.message),
        (loginResponse) => LoginState.success(loginResponse),
      );
    }
  }
}
