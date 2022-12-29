// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'login_error_response_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

LoginErrorResponseDTO _$LoginErrorResponseDTOFromJson(
    Map<String, dynamic> json) {
  return _LoginErrorResponseDTO.fromJson(json);
}

/// @nodoc
mixin _$LoginErrorResponseDTO {
  @JsonKey(name: 'error')
  bool get error => throw _privateConstructorUsedError;

  @JsonKey(name: 'message')
  String get message => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;

  @JsonKey(ignore: true)
  $LoginErrorResponseDTOCopyWith<LoginErrorResponseDTO> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $LoginErrorResponseDTOCopyWith<$Res> {
  factory $LoginErrorResponseDTOCopyWith(LoginErrorResponseDTO value,
          $Res Function(LoginErrorResponseDTO) then) =
      _$LoginErrorResponseDTOCopyWithImpl<$Res, LoginErrorResponseDTO>;

  @useResult
  $Res call(
      {@JsonKey(name: 'error') bool error,
      @JsonKey(name: 'message') String message});
}

/// @nodoc
class _$LoginErrorResponseDTOCopyWithImpl<$Res,
        $Val extends LoginErrorResponseDTO>
    implements $LoginErrorResponseDTOCopyWith<$Res> {
  _$LoginErrorResponseDTOCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;

  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? error = null,
    Object? message = null,
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
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_LoginErrorResponseDTOCopyWith<$Res>
    implements $LoginErrorResponseDTOCopyWith<$Res> {
  factory _$$_LoginErrorResponseDTOCopyWith(_$_LoginErrorResponseDTO value,
          $Res Function(_$_LoginErrorResponseDTO) then) =
      __$$_LoginErrorResponseDTOCopyWithImpl<$Res>;

  @override
  @useResult
  $Res call(
      {@JsonKey(name: 'error') bool error,
      @JsonKey(name: 'message') String message});
}

/// @nodoc
class __$$_LoginErrorResponseDTOCopyWithImpl<$Res>
    extends _$LoginErrorResponseDTOCopyWithImpl<$Res, _$_LoginErrorResponseDTO>
    implements _$$_LoginErrorResponseDTOCopyWith<$Res> {
  __$$_LoginErrorResponseDTOCopyWithImpl(_$_LoginErrorResponseDTO _value,
      $Res Function(_$_LoginErrorResponseDTO) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? error = null,
    Object? message = null,
  }) {
    return _then(_$_LoginErrorResponseDTO(
      error: null == error
          ? _value.error
          : error // ignore: cast_nullable_to_non_nullable
              as bool,
      message: null == message
          ? _value.message
          : message // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_LoginErrorResponseDTO implements _LoginErrorResponseDTO {
  const _$_LoginErrorResponseDTO(
      {@JsonKey(name: 'error') required this.error,
      @JsonKey(name: 'message') required this.message});

  factory _$_LoginErrorResponseDTO.fromJson(Map<String, dynamic> json) =>
      _$$_LoginErrorResponseDTOFromJson(json);

  @override
  @JsonKey(name: 'error')
  final bool error;
  @override
  @JsonKey(name: 'message')
  final String message;

  @override
  String toString() {
    return 'LoginErrorResponseDTO(error: $error, message: $message)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_LoginErrorResponseDTO &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.message, message) || other.message == message));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode => Object.hash(runtimeType, error, message);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_LoginErrorResponseDTOCopyWith<_$_LoginErrorResponseDTO> get copyWith =>
      __$$_LoginErrorResponseDTOCopyWithImpl<_$_LoginErrorResponseDTO>(
          this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_LoginErrorResponseDTOToJson(
      this,
    );
  }
}

abstract class _LoginErrorResponseDTO implements LoginErrorResponseDTO {
  const factory _LoginErrorResponseDTO(
          {@JsonKey(name: 'error') required final bool error,
          @JsonKey(name: 'message') required final String message}) =
      _$_LoginErrorResponseDTO;

  factory _LoginErrorResponseDTO.fromJson(Map<String, dynamic> json) =
      _$_LoginErrorResponseDTO.fromJson;

  @override
  @JsonKey(name: 'error')
  bool get error;

  @override
  @JsonKey(name: 'message')
  String get message;

  @override
  @JsonKey(ignore: true)
  _$$_LoginErrorResponseDTOCopyWith<_$_LoginErrorResponseDTO> get copyWith =>
      throw _privateConstructorUsedError;
}
