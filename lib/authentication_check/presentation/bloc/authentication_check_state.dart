part of 'authentication_check_bloc.dart';

@freezed
class AuthenticationCheckState with _$AuthenticationCheckState {
  const factory AuthenticationCheckState.initial() = Initial;
  const factory AuthenticationCheckState.loading() = Loading;
  const factory AuthenticationCheckState.failure(String message) = Failure;
  const factory AuthenticationCheckState.success(
      AuthenticationStatus authenticationStatus) = Success;
}
