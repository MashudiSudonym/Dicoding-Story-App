// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'authentication_status.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

AuthenticationStatus _$AuthenticationStatusFromJson(Map<String, dynamic> json) {
  return _AuthenticationStatus.fromJson(json);
}

/// @nodoc
mixin _$AuthenticationStatus {
  bool get isAuthenticated => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $AuthenticationStatusCopyWith<AuthenticationStatus> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $AuthenticationStatusCopyWith<$Res> {
  factory $AuthenticationStatusCopyWith(AuthenticationStatus value,
          $Res Function(AuthenticationStatus) then) =
      _$AuthenticationStatusCopyWithImpl<$Res, AuthenticationStatus>;
  @useResult
  $Res call({bool isAuthenticated});
}

/// @nodoc
class _$AuthenticationStatusCopyWithImpl<$Res,
        $Val extends AuthenticationStatus>
    implements $AuthenticationStatusCopyWith<$Res> {
  _$AuthenticationStatusCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? isAuthenticated = null,
  }) {
    return _then(_value.copyWith(
      isAuthenticated: null == isAuthenticated
          ? _value.isAuthenticated
          : isAuthenticated // ignore: cast_nullable_to_non_nullable
              as bool,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_AuthenticationStatusCopyWith<$Res>
    implements $AuthenticationStatusCopyWith<$Res> {
  factory _$$_AuthenticationStatusCopyWith(_$_AuthenticationStatus value,
          $Res Function(_$_AuthenticationStatus) then) =
      __$$_AuthenticationStatusCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call({bool isAuthenticated});
}

/// @nodoc
class __$$_AuthenticationStatusCopyWithImpl<$Res>
    extends _$AuthenticationStatusCopyWithImpl<$Res, _$_AuthenticationStatus>
    implements _$$_AuthenticationStatusCopyWith<$Res> {
  __$$_AuthenticationStatusCopyWithImpl(_$_AuthenticationStatus _value,
      $Res Function(_$_AuthenticationStatus) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? isAuthenticated = null,
  }) {
    return _then(_$_AuthenticationStatus(
      isAuthenticated: null == isAuthenticated
          ? _value.isAuthenticated
          : isAuthenticated // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_AuthenticationStatus implements _AuthenticationStatus {
  const _$_AuthenticationStatus({required this.isAuthenticated});

  factory _$_AuthenticationStatus.fromJson(Map<String, dynamic> json) =>
      _$$_AuthenticationStatusFromJson(json);

  @override
  final bool isAuthenticated;

  @override
  String toString() {
    return 'AuthenticationStatus(isAuthenticated: $isAuthenticated)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_AuthenticationStatus &&
            (identical(other.isAuthenticated, isAuthenticated) ||
                other.isAuthenticated == isAuthenticated));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode => Object.hash(runtimeType, isAuthenticated);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_AuthenticationStatusCopyWith<_$_AuthenticationStatus> get copyWith =>
      __$$_AuthenticationStatusCopyWithImpl<_$_AuthenticationStatus>(
          this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_AuthenticationStatusToJson(
      this,
    );
  }
}

abstract class _AuthenticationStatus implements AuthenticationStatus {
  const factory _AuthenticationStatus({required final bool isAuthenticated}) =
      _$_AuthenticationStatus;

  factory _AuthenticationStatus.fromJson(Map<String, dynamic> json) =
      _$_AuthenticationStatus.fromJson;

  @override
  bool get isAuthenticated;
  @override
  @JsonKey(ignore: true)
  _$$_AuthenticationStatusCopyWith<_$_AuthenticationStatus> get copyWith =>
      throw _privateConstructorUsedError;
}
