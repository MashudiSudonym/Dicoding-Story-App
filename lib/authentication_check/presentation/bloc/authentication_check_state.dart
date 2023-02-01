part of 'authentication_check_bloc.dart';

@freezed
class AuthenticationCheckState with _$AuthenticationCheckState {
  const factory AuthenticationCheckState.initial() = _Initial;
  const factory AuthenticationCheckState.loading() = _Loading;
  const factory AuthenticationCheckState.failure(String message) = _Failure;
  const factory AuthenticationCheckState.success(
      AuthenticationStatus authenticationStatus) = _Success;
}
