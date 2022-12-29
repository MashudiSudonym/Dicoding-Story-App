// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'login_result_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

LoginResultDTO _$LoginResultDTOFromJson(Map<String, dynamic> json) {
  return _LoginResultDTO.fromJson(json);
}

/// @nodoc
mixin _$LoginResultDTO {
  @JsonKey(name: 'userId')
  String get userId => throw _privateConstructorUsedError;
  @JsonKey(name: 'name')
  String get name => throw _privateConstructorUsedError;
  @JsonKey(name: 'token')
  String get token => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $LoginResultDTOCopyWith<LoginResultDTO> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $LoginResultDTOCopyWith<$Res> {
  factory $LoginResultDTOCopyWith(
          LoginResultDTO value, $Res Function(LoginResultDTO) then) =
      _$LoginResultDTOCopyWithImpl<$Res, LoginResultDTO>;
  @useResult
  $Res call(
      {@JsonKey(name: 'userId') String userId,
      @JsonKey(name: 'name') String name,
      @JsonKey(name: 'token') String token});
}

/// @nodoc
class _$LoginResultDTOCopyWithImpl<$Res, $Val extends LoginResultDTO>
    implements $LoginResultDTOCopyWith<$Res> {
  _$LoginResultDTOCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? userId = null,
    Object? name = null,
    Object? token = null,
  }) {
    return _then(_value.copyWith(
      userId: null == userId
          ? _value.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String,
      name: null == name
          ? _value.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      token: null == token
          ? _value.token
          : token // ignore: cast_nullable_to_non_nullable
              as String,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_LoginResultDTOCopyWith<$Res>
    implements $LoginResultDTOCopyWith<$Res> {
  factory _$$_LoginResultDTOCopyWith(
          _$_LoginResultDTO value, $Res Function(_$_LoginResultDTO) then) =
      __$$_LoginResultDTOCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {@JsonKey(name: 'userId') String userId,
      @JsonKey(name: 'name') String name,
      @JsonKey(name: 'token') String token});
}

/// @nodoc
class __$$_LoginResultDTOCopyWithImpl<$Res>
    extends _$LoginResultDTOCopyWithImpl<$Res, _$_LoginResultDTO>
    implements _$$_LoginResultDTOCopyWith<$Res> {
  __$$_LoginResultDTOCopyWithImpl(
      _$_LoginResultDTO _value, $Res Function(_$_LoginResultDTO) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? userId = null,
    Object? name = null,
    Object? token = null,
  }) {
    return _then(_$_LoginResultDTO(
      userId: null == userId
          ? _value.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String,
      name: null == name
          ? _value.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      token: null == token
          ? _value.token
          : token // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_LoginResultDTO implements _LoginResultDTO {
  const _$_LoginResultDTO(
      {@JsonKey(name: 'userId') required this.userId,
      @JsonKey(name: 'name') required this.name,
      @JsonKey(name: 'token') required this.token});

  factory _$_LoginResultDTO.fromJson(Map<String, dynamic> json) =>
      _$$_LoginResultDTOFromJson(json);

  @override
  @JsonKey(name: 'userId')
  final String userId;
  @override
  @JsonKey(name: 'name')
  final String name;
  @override
  @JsonKey(name: 'token')
  final String token;

  @override
  String toString() {
    return 'LoginResultDTO(userId: $userId, name: $name, token: $token)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_LoginResultDTO &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.token, token) || other.token == token));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode => Object.hash(runtimeType, userId, name, token);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_LoginResultDTOCopyWith<_$_LoginResultDTO> get copyWith =>
      __$$_LoginResultDTOCopyWithImpl<_$_LoginResultDTO>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_LoginResultDTOToJson(
      this,
    );
  }
}

abstract class _LoginResultDTO implements LoginResultDTO {
  const factory _LoginResultDTO(
      {@JsonKey(name: 'userId') required final String userId,
      @JsonKey(name: 'name') required final String name,
      @JsonKey(name: 'token') required final String token}) = _$_LoginResultDTO;

  factory _LoginResultDTO.fromJson(Map<String, dynamic> json) =
      _$_LoginResultDTO.fromJson;

  @override
  @JsonKey(name: 'userId')
  String get userId;
  @override
  @JsonKey(name: 'name')
  String get name;
  @override
  @JsonKey(name: 'token')
  String get token;
  @override
  @JsonKey(ignore: true)
  _$$_LoginResultDTOCopyWith<_$_LoginResultDTO> get copyWith =>
      throw _privateConstructorUsedError;
}
