part of 'login_bloc.dart';

@freezed
class LoginEvent with _$LoginEvent {
  const factory LoginEvent.LoginEmailChange({@required String? email}) =
      _LoginEmailChange;
  const factory LoginEvent.LoginPasswordChange({@required String? password}) =
      _LoginPasswordChange;
  const factory LoginEvent.LoginSubmitted() = _LoginSubmitted;
}
