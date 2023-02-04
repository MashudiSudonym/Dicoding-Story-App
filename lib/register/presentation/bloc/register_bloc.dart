import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/register/domain/model/register_response.dart';
import 'package:story_app/register/domain/use_case/user_register_use_case.dart';

part 'register_bloc.freezed.dart';
part 'register_event.dart';
part 'register_state.dart';

class RegisterBloc extends Bloc<RegisterEvent, RegisterState> {
  final UserRegisterUseCase _userRegisterUseCase;

  RegisterBloc(this._userRegisterUseCase)
      : super(const RegisterState.initial());

  Stream<RegisterState> mapEventToState(RegisterEvent event) async* {
    if (event is RegisterButtonPressed) {
      yield const RegisterState.loading();

      final either = await _userRegisterUseCase(
        event.name ?? Constants.blankString,
        event.email ?? Constants.blankString,
        event.password ?? Constants.blankString,
      );

      yield either.fold(
        (failure) => RegisterState.failure(failure.message),
        (registerResponse) => RegisterState.success(registerResponse),
      );
    }
  }
}
