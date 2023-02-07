part of 'authentication_check_bloc.dart';

@freezed
class AuthenticationCheckEvent with _$AuthenticationCheckEvent {
  const factory AuthenticationCheckEvent.checkAuthentication() =
      _CheckAuthentication;
}