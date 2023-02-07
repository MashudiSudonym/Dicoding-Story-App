part of 'register_bloc.dart';

@freezed
class RegisterEvent with _$RegisterEvent {
  const factory RegisterEvent.registerButtonPressed({
    @required String? name,
    @required String? email,
    @required String? password,
  }) = _RegisterButtonPressed;
}
