import 'package:bloc/bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/domain/model/authentication_status.dart';
import 'package:story_app/authentication_check/domain/use_case/check_authentication_use_case/check_authentication_use_case.dart';

part 'authentication_check_bloc.freezed.dart';
part 'authentication_check_event.dart';
part 'authentication_check_state.dart';

@injectable
class AuthenticationCheckBloc
    extends Bloc<AuthenticationCheckEvent, AuthenticationCheckState> {
  final CheckAuthenticationUseCase _checkAuthenticationUseCase;

  AuthenticationCheckBloc(this._checkAuthenticationUseCase)
      : super(const _Initial());

  Stream<AuthenticationCheckState> mapEventToState(
      AuthenticationCheckEvent event) async* {
    if (event is _CheckAuthentication) {
      yield const AuthenticationCheckState.loading();

      final either = await _checkAuthenticationUseCase();

      yield either.fold(
        (failure) => AuthenticationCheckState.failure(failure.message),
        (authenticationCheckResponse) =>
            AuthenticationCheckState.success(authenticationCheckResponse),
      );
    }
  }
}
