import 'package:formz/formz.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:hydrated_bloc/hydrated_bloc.dart';
import 'package:injectable/injectable.dart';
import 'package:logger/logger.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/login/domain/use_case/user_login_use_case.dart';
import 'package:story_app/login/presentation/bloc/email.dart';
import 'package:story_app/login/presentation/bloc/password.dart';

part 'login_bloc.freezed.dart';
part 'login_event.dart';
part 'login_state.dart';

@injectable
class LoginBloc extends Bloc<LoginEvent, LoginState> {
  final UserLoginUseCase _userLoginUseCase;

  LoginBloc(this._userLoginUseCase) : super(const LoginState()) {
    on<LoginEvent>((event, emit) async {
      await event.when(
        LoginEmailChange: (email) {
          Logger().d(email);

          Logger().d(state.email);

          emit(
            state.copyWith(
              email: Email.dirty(email ?? Constants.blankString),
            ),
          );

          Logger().d(state.email);
        },
        LoginPasswordChange: (password) {
          emit(
            state.copyWith(
              password: Password.dirty(password ?? Constants.blankString),
              status: FormzSubmissionStatus.initial,
            ),
          );
        },
        LoginSubmitted: () async {
          emit(state.copyWith(status: FormzSubmissionStatus.inProgress));

          final either =
              await _userLoginUseCase(state.email.value, state.password.value);

          either.fold(
            (failure) => emit(
              state.copyWith(status: FormzSubmissionStatus.failure),
            ),
            (response) => emit(
              state.copyWith(status: FormzSubmissionStatus.success),
            ),
          );
        },
      );
    });
  }
}
