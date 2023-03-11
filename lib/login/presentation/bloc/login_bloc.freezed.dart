// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'login_bloc.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

/// @nodoc
mixin _$LoginEvent {
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function(String? email) LoginEmailChange,
    required TResult Function(String? password) LoginPasswordChange,
    required TResult Function() LoginSubmitted,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function(String? email)? LoginEmailChange,
    TResult? Function(String? password)? LoginPasswordChange,
    TResult? Function()? LoginSubmitted,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function(String? email)? LoginEmailChange,
    TResult Function(String? password)? LoginPasswordChange,
    TResult Function()? LoginSubmitted,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_LoginEmailChange value) LoginEmailChange,
    required TResult Function(_LoginPasswordChange value) LoginPasswordChange,
    required TResult Function(_LoginSubmitted value) LoginSubmitted,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_LoginEmailChange value)? LoginEmailChange,
    TResult? Function(_LoginPasswordChange value)? LoginPasswordChange,
    TResult? Function(_LoginSubmitted value)? LoginSubmitted,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_LoginEmailChange value)? LoginEmailChange,
    TResult Function(_LoginPasswordChange value)? LoginPasswordChange,
    TResult Function(_LoginSubmitted value)? LoginSubmitted,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $LoginEventCopyWith<$Res> {
  factory $LoginEventCopyWith(
          LoginEvent value, $Res Function(LoginEvent) then) =
      _$LoginEventCopyWithImpl<$Res, LoginEvent>;
}

/// @nodoc
class _$LoginEventCopyWithImpl<$Res, $Val extends LoginEvent>
    implements $LoginEventCopyWith<$Res> {
  _$LoginEventCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;
}

/// @nodoc
abstract class _$$_LoginEmailChangeCopyWith<$Res> {
  factory _$$_LoginEmailChangeCopyWith(
          _$_LoginEmailChange value, $Res Function(_$_LoginEmailChange) then) =
      __$$_LoginEmailChangeCopyWithImpl<$Res>;
  @useResult
  $Res call({String? email});
}

/// @nodoc
class __$$_LoginEmailChangeCopyWithImpl<$Res>
    extends _$LoginEventCopyWithImpl<$Res, _$_LoginEmailChange>
    implements _$$_LoginEmailChangeCopyWith<$Res> {
  __$$_LoginEmailChangeCopyWithImpl(
      _$_LoginEmailChange _value, $Res Function(_$_LoginEmailChange) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? email = freezed,
  }) {
    return _then(_$_LoginEmailChange(
      email: freezed == email
          ? _value.email
          : email // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _$_LoginEmailChange implements _LoginEmailChange {
  const _$_LoginEmailChange({this.email});

  @override
  final String? email;

  @override
  String toString() {
    return 'LoginEvent.LoginEmailChange(email: $email)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_LoginEmailChange &&
            (identical(other.email, email) || other.email == email));
  }

  @override
  int get hashCode => Object.hash(runtimeType, email);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_LoginEmailChangeCopyWith<_$_LoginEmailChange> get copyWith =>
      __$$_LoginEmailChangeCopyWithImpl<_$_LoginEmailChange>(this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function(String? email) LoginEmailChange,
    required TResult Function(String? password) LoginPasswordChange,
    required TResult Function() LoginSubmitted,
  }) {
    return LoginEmailChange(email);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function(String? email)? LoginEmailChange,
    TResult? Function(String? password)? LoginPasswordChange,
    TResult? Function()? LoginSubmitted,
  }) {
    return LoginEmailChange?.call(email);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function(String? email)? LoginEmailChange,
    TResult Function(String? password)? LoginPasswordChange,
    TResult Function()? LoginSubmitted,
    required TResult orElse(),
  }) {
    if (LoginEmailChange != null) {
      return LoginEmailChange(email);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_LoginEmailChange value) LoginEmailChange,
    required TResult Function(_LoginPasswordChange value) LoginPasswordChange,
    required TResult Function(_LoginSubmitted value) LoginSubmitted,
  }) {
    return LoginEmailChange(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_LoginEmailChange value)? LoginEmailChange,
    TResult? Function(_LoginPasswordChange value)? LoginPasswordChange,
    TResult? Function(_LoginSubmitted value)? LoginSubmitted,
  }) {
    return LoginEmailChange?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_LoginEmailChange value)? LoginEmailChange,
    TResult Function(_LoginPasswordChange value)? LoginPasswordChange,
    TResult Function(_LoginSubmitted value)? LoginSubmitted,
    required TResult orElse(),
  }) {
    if (LoginEmailChange != null) {
      return LoginEmailChange(this);
    }
    return orElse();
  }
}

abstract class _LoginEmailChange implements LoginEvent {
  const factory _LoginEmailChange({final String? email}) = _$_LoginEmailChange;

  String? get email;
  @JsonKey(ignore: true)
  _$$_LoginEmailChangeCopyWith<_$_LoginEmailChange> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class _$$_LoginPasswordChangeCopyWith<$Res> {
  factory _$$_LoginPasswordChangeCopyWith(_$_LoginPasswordChange value,
          $Res Function(_$_LoginPasswordChange) then) =
      __$$_LoginPasswordChangeCopyWithImpl<$Res>;
  @useResult
  $Res call({String? password});
}

/// @nodoc
class __$$_LoginPasswordChangeCopyWithImpl<$Res>
    extends _$LoginEventCopyWithImpl<$Res, _$_LoginPasswordChange>
    implements _$$_LoginPasswordChangeCopyWith<$Res> {
  __$$_LoginPasswordChangeCopyWithImpl(_$_LoginPasswordChange _value,
      $Res Function(_$_LoginPasswordChange) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? password = freezed,
  }) {
    return _then(_$_LoginPasswordChange(
      password: freezed == password
          ? _value.password
          : password // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _$_LoginPasswordChange implements _LoginPasswordChange {
  const _$_LoginPasswordChange({this.password});

  @override
  final String? password;

  @override
  String toString() {
    return 'LoginEvent.LoginPasswordChange(password: $password)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_LoginPasswordChange &&
            (identical(other.password, password) ||
                other.password == password));
  }

  @override
  int get hashCode => Object.hash(runtimeType, password);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_LoginPasswordChangeCopyWith<_$_LoginPasswordChange> get copyWith =>
      __$$_LoginPasswordChangeCopyWithImpl<_$_LoginPasswordChange>(
          this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function(String? email) LoginEmailChange,
    required TResult Function(String? password) LoginPasswordChange,
    required TResult Function() LoginSubmitted,
  }) {
    return LoginPasswordChange(password);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function(String? email)? LoginEmailChange,
    TResult? Function(String? password)? LoginPasswordChange,
    TResult? Function()? LoginSubmitted,
  }) {
    return LoginPasswordChange?.call(password);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function(String? email)? LoginEmailChange,
    TResult Function(String? password)? LoginPasswordChange,
    TResult Function()? LoginSubmitted,
    required TResult orElse(),
  }) {
    if (LoginPasswordChange != null) {
      return LoginPasswordChange(password);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_LoginEmailChange value) LoginEmailChange,
    required TResult Function(_LoginPasswordChange value) LoginPasswordChange,
    required TResult Function(_LoginSubmitted value) LoginSubmitted,
  }) {
    return LoginPasswordChange(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_LoginEmailChange value)? LoginEmailChange,
    TResult? Function(_LoginPasswordChange value)? LoginPasswordChange,
    TResult? Function(_LoginSubmitted value)? LoginSubmitted,
  }) {
    return LoginPasswordChange?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_LoginEmailChange value)? LoginEmailChange,
    TResult Function(_LoginPasswordChange value)? LoginPasswordChange,
    TResult Function(_LoginSubmitted value)? LoginSubmitted,
    required TResult orElse(),
  }) {
    if (LoginPasswordChange != null) {
      return LoginPasswordChange(this);
    }
    return orElse();
  }
}

abstract class _LoginPasswordChange implements LoginEvent {
  const factory _LoginPasswordChange({final String? password}) =
      _$_LoginPasswordChange;

  String? get password;
  @JsonKey(ignore: true)
  _$$_LoginPasswordChangeCopyWith<_$_LoginPasswordChange> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class _$$_LoginSubmittedCopyWith<$Res> {
  factory _$$_LoginSubmittedCopyWith(
          _$_LoginSubmitted value, $Res Function(_$_LoginSubmitted) then) =
      __$$_LoginSubmittedCopyWithImpl<$Res>;
}

/// @nodoc
class __$$_LoginSubmittedCopyWithImpl<$Res>
    extends _$LoginEventCopyWithImpl<$Res, _$_LoginSubmitted>
    implements _$$_LoginSubmittedCopyWith<$Res> {
  __$$_LoginSubmittedCopyWithImpl(
      _$_LoginSubmitted _value, $Res Function(_$_LoginSubmitted) _then)
      : super(_value, _then);
}

/// @nodoc

class _$_LoginSubmitted implements _LoginSubmitted {
  const _$_LoginSubmitted();

  @override
  String toString() {
    return 'LoginEvent.LoginSubmitted()';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType && other is _$_LoginSubmitted);
  }

  @override
  int get hashCode => runtimeType.hashCode;

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function(String? email) LoginEmailChange,
    required TResult Function(String? password) LoginPasswordChange,
    required TResult Function() LoginSubmitted,
  }) {
    return LoginSubmitted();
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function(String? email)? LoginEmailChange,
    TResult? Function(String? password)? LoginPasswordChange,
    TResult? Function()? LoginSubmitted,
  }) {
    return LoginSubmitted?.call();
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function(String? email)? LoginEmailChange,
    TResult Function(String? password)? LoginPasswordChange,
    TResult Function()? LoginSubmitted,
    required TResult orElse(),
  }) {
    if (LoginSubmitted != null) {
      return LoginSubmitted();
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_LoginEmailChange value) LoginEmailChange,
    required TResult Function(_LoginPasswordChange value) LoginPasswordChange,
    required TResult Function(_LoginSubmitted value) LoginSubmitted,
  }) {
    return LoginSubmitted(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_LoginEmailChange value)? LoginEmailChange,
    TResult? Function(_LoginPasswordChange value)? LoginPasswordChange,
    TResult? Function(_LoginSubmitted value)? LoginSubmitted,
  }) {
    return LoginSubmitted?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_LoginEmailChange value)? LoginEmailChange,
    TResult Function(_LoginPasswordChange value)? LoginPasswordChange,
    TResult Function(_LoginSubmitted value)? LoginSubmitted,
    required TResult orElse(),
  }) {
    if (LoginSubmitted != null) {
      return LoginSubmitted(this);
    }
    return orElse();
  }
}

abstract class _LoginSubmitted implements LoginEvent {
  const factory _LoginSubmitted() = _$_LoginSubmitted;
}

/// @nodoc
mixin _$LoginState {
  FormzSubmissionStatus get status => throw _privateConstructorUsedError;
  Email get email => throw _privateConstructorUsedError;
  Password get password => throw _privateConstructorUsedError;

  @JsonKey(ignore: true)
  $LoginStateCopyWith<LoginState> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $LoginStateCopyWith<$Res> {
  factory $LoginStateCopyWith(
          LoginState value, $Res Function(LoginState) then) =
      _$LoginStateCopyWithImpl<$Res, LoginState>;
  @useResult
  $Res call({FormzSubmissionStatus status, Email email, Password password});
}

/// @nodoc
class _$LoginStateCopyWithImpl<$Res, $Val extends LoginState>
    implements $LoginStateCopyWith<$Res> {
  _$LoginStateCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? status = null,
    Object? email = null,
    Object? password = null,
  }) {
    return _then(_value.copyWith(
      status: null == status
          ? _value.status
          : status // ignore: cast_nullable_to_non_nullable
              as FormzSubmissionStatus,
      email: null == email
          ? _value.email
          : email // ignore: cast_nullable_to_non_nullable
              as Email,
      password: null == password
          ? _value.password
          : password // ignore: cast_nullable_to_non_nullable
              as Password,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_LoginStateCopyWith<$Res>
    implements $LoginStateCopyWith<$Res> {
  factory _$$_LoginStateCopyWith(
          _$_LoginState value, $Res Function(_$_LoginState) then) =
      __$$_LoginStateCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call({FormzSubmissionStatus status, Email email, Password password});
}

/// @nodoc
class __$$_LoginStateCopyWithImpl<$Res>
    extends _$LoginStateCopyWithImpl<$Res, _$_LoginState>
    implements _$$_LoginStateCopyWith<$Res> {
  __$$_LoginStateCopyWithImpl(
      _$_LoginState _value, $Res Function(_$_LoginState) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? status = null,
    Object? email = null,
    Object? password = null,
  }) {
    return _then(_$_LoginState(
      status: null == status
          ? _value.status
          : status // ignore: cast_nullable_to_non_nullable
              as FormzSubmissionStatus,
      email: null == email
          ? _value.email
          : email // ignore: cast_nullable_to_non_nullable
              as Email,
      password: null == password
          ? _value.password
          : password // ignore: cast_nullable_to_non_nullable
              as Password,
    ));
  }
}

/// @nodoc

class _$_LoginState implements _LoginState {
  const _$_LoginState(
      {this.status = FormzSubmissionStatus.initial,
      this.email = const Email.pure(),
      this.password = const Password.pure()});

  @override
  @JsonKey()
  final FormzSubmissionStatus status;
  @override
  @JsonKey()
  final Email email;
  @override
  @JsonKey()
  final Password password;

  @override
  String toString() {
    return 'LoginState(status: $status, email: $email, password: $password)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_LoginState &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.email, email) || other.email == email) &&
            (identical(other.password, password) ||
                other.password == password));
  }

  @override
  int get hashCode => Object.hash(runtimeType, status, email, password);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_LoginStateCopyWith<_$_LoginState> get copyWith =>
      __$$_LoginStateCopyWithImpl<_$_LoginState>(this, _$identity);
}

abstract class _LoginState implements LoginState {
  const factory _LoginState(
      {final FormzSubmissionStatus status,
      final Email email,
      final Password password}) = _$_LoginState;

  @override
  FormzSubmissionStatus get status;
  @override
  Email get email;
  @override
  Password get password;
  @override
  @JsonKey(ignore: true)
  _$$_LoginStateCopyWith<_$_LoginState> get copyWith =>
      throw _privateConstructorUsedError;
}
