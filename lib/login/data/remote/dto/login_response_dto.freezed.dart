// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'login_response_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

LoginResponseDTO _$LoginResponseDTOFromJson(Map<String, dynamic> json) {
  return _LoginResponseDTO.fromJson(json);
}

/// @nodoc
mixin _$LoginResponseDTO {
  @JsonKey(name: 'error')
  bool get error => throw _privateConstructorUsedError;

  @JsonKey(name: 'message')
  String get message => throw _privateConstructorUsedError;

  @JsonKey(name: 'loginResult')
  LoginResultDTO get loginResultDTO => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;

  @JsonKey(ignore: true)
  $LoginResponseDTOCopyWith<LoginResponseDTO> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $LoginResponseDTOCopyWith<$Res> {
  factory $LoginResponseDTOCopyWith(
          LoginResponseDTO value, $Res Function(LoginResponseDTO) then) =
      _$LoginResponseDTOCopyWithImpl<$Res, LoginResponseDTO>;

  @useResult
  $Res call(
      {@JsonKey(name: 'error') bool error,
      @JsonKey(name: 'message') String message,
      @JsonKey(name: 'loginResult') LoginResultDTO loginResultDTO});

  $LoginResultDTOCopyWith<$Res> get loginResultDTO;
}

/// @nodoc
class _$LoginResponseDTOCopyWithImpl<$Res, $Val extends LoginResponseDTO>
    implements $LoginResponseDTOCopyWith<$Res> {
  _$LoginResponseDTOCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;

  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? error = null,
    Object? message = null,
    Object? loginResultDTO = null,
  }) {
    return _then(_value.copyWith(
      error: null == error
          ? _value.error
          : error // ignore: cast_nullable_to_non_nullable
              as bool,
      message: null == message
          ? _value.message
          : message // ignore: cast_nullable_to_non_nullable
              as String,
      loginResultDTO: null == loginResultDTO
          ? _value.loginResultDTO
          : loginResultDTO // ignore: cast_nullable_to_non_nullable
              as LoginResultDTO,
    ) as $Val);
  }

  @override
  @pragma('vm:prefer-inline')
  $LoginResultDTOCopyWith<$Res> get loginResultDTO {
    return $LoginResultDTOCopyWith<$Res>(_value.loginResultDTO, (value) {
      return _then(_value.copyWith(loginResultDTO: value) as $Val);
    });
  }
}

/// @nodoc
abstract class _$$_LoginResponseDTOCopyWith<$Res>
    implements $LoginResponseDTOCopyWith<$Res> {
  factory _$$_LoginResponseDTOCopyWith(
          _$_LoginResponseDTO value, $Res Function(_$_LoginResponseDTO) then) =
      __$$_LoginResponseDTOCopyWithImpl<$Res>;

  @override
  @useResult
  $Res call(
      {@JsonKey(name: 'error') bool error,
      @JsonKey(name: 'message') String message,
      @JsonKey(name: 'loginResult') LoginResultDTO loginResultDTO});

  @override
  $LoginResultDTOCopyWith<$Res> get loginResultDTO;
}

/// @nodoc
class __$$_LoginResponseDTOCopyWithImpl<$Res>
    extends _$LoginResponseDTOCopyWithImpl<$Res, _$_LoginResponseDTO>
    implements _$$_LoginResponseDTOCopyWith<$Res> {
  __$$_LoginResponseDTOCopyWithImpl(
      _$_LoginResponseDTO _value, $Res Function(_$_LoginResponseDTO) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? error = null,
    Object? message = null,
    Object? loginResultDTO = null,
  }) {
    return _then(_$_LoginResponseDTO(
      error: null == error
          ? _value.error
          : error // ignore: cast_nullable_to_non_nullable
              as bool,
      message: null == message
          ? _value.message
          : message // ignore: cast_nullable_to_non_nullable
              as String,
      loginResultDTO: null == loginResultDTO
          ? _value.loginResultDTO
          : loginResultDTO // ignore: cast_nullable_to_non_nullable
              as LoginResultDTO,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_LoginResponseDTO implements _LoginResponseDTO {
  const _$_LoginResponseDTO(
      {@JsonKey(name: 'error') required this.error,
      @JsonKey(name: 'message') required this.message,
      @JsonKey(name: 'loginResult') required this.loginResultDTO});

  factory _$_LoginResponseDTO.fromJson(Map<String, dynamic> json) =>
      _$$_LoginResponseDTOFromJson(json);

  @override
  @JsonKey(name: 'error')
  final bool error;
  @override
  @JsonKey(name: 'message')
  final String message;
  @override
  @JsonKey(name: 'loginResult')
  final LoginResultDTO loginResultDTO;

  @override
  String toString() {
    return 'LoginResponseDTO(error: $error, message: $message, loginResultDTO: $loginResultDTO)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_LoginResponseDTO &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.message, message) || other.message == message) &&
            (identical(other.loginResultDTO, loginResultDTO) ||
                other.loginResultDTO == loginResultDTO));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode => Object.hash(runtimeType, error, message, loginResultDTO);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_LoginResponseDTOCopyWith<_$_LoginResponseDTO> get copyWith =>
      __$$_LoginResponseDTOCopyWithImpl<_$_LoginResponseDTO>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_LoginResponseDTOToJson(
      this,
    );
  }
}

abstract class _LoginResponseDTO implements LoginResponseDTO {
  const factory _LoginResponseDTO(
      {@JsonKey(name: 'error')
          required final bool error,
      @JsonKey(name: 'message')
          required final String message,
      @JsonKey(name: 'loginResult')
          required final LoginResultDTO loginResultDTO}) = _$_LoginResponseDTO;

  factory _LoginResponseDTO.fromJson(Map<String, dynamic> json) =
      _$_LoginResponseDTO.fromJson;

  @override
  @JsonKey(name: 'error')
  bool get error;

  @override
  @JsonKey(name: 'message')
  String get message;

  @override
  @JsonKey(name: 'loginResult')
  LoginResultDTO get loginResultDTO;

  @override
  @JsonKey(ignore: true)
  _$$_LoginResponseDTOCopyWith<_$_LoginResponseDTO> get copyWith =>
      throw _privateConstructorUsedError;
}
