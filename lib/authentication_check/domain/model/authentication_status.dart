import 'package:freezed_annotation/freezed_annotation.dart';

part 'authentication_status.freezed.dart';
part 'authentication_status.g.dart';

@freezed
class AuthenticationStatus with _$AuthenticationStatus {
  const factory AuthenticationStatus({
    required bool isAuthenticated,
  }) = _AuthenticationStatus;

  factory AuthenticationStatus.fromJson(Map<String, dynamic> json) =>
      _$AuthenticationStatusFromJson(json);
}
