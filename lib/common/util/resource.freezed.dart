// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'resource.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

/// @nodoc
mixin _$Resource<T> {
  bool get success => throw _privateConstructorUsedError;

  AppError? get error => throw _privateConstructorUsedError;

  String? get msg => throw _privateConstructorUsedError;

  T? get value => throw _privateConstructorUsedError;

  @JsonKey(ignore: true)
  $ResourceCopyWith<T, Resource<T>> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $ResourceCopyWith<T, $Res> {
  factory $ResourceCopyWith(
          Resource<T> value, $Res Function(Resource<T>) then) =
      _$ResourceCopyWithImpl<T, $Res, Resource<T>>;

  @useResult
  $Res call({bool success, AppError? error, String? msg, T? value});
}

/// @nodoc
class _$ResourceCopyWithImpl<T, $Res, $Val extends Resource<T>>
    implements $ResourceCopyWith<T, $Res> {
  _$ResourceCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? success = null,
    Object? error = freezed,
    Object? msg = freezed,
    Object? value = freezed,
  }) {
    return _then(_value.copyWith(
      success: null == success
          ? _value.success
          : success // ignore: cast_nullable_to_non_nullable
              as bool,
      error: freezed == error
          ? _value.error
          : error // ignore: cast_nullable_to_non_nullable
              as AppError?,
      msg: freezed == msg
          ? _value.msg
          : msg // ignore: cast_nullable_to_non_nullable
              as String?,
      value: freezed == value
          ? _value.value
          : value // ignore: cast_nullable_to_non_nullable
              as T?,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_ResourceCopyWith<T, $Res>
    implements $ResourceCopyWith<T, $Res> {
  factory _$$_ResourceCopyWith(
          _$_Resource<T> value, $Res Function(_$_Resource<T>) then) =
      __$$_ResourceCopyWithImpl<T, $Res>;

  @override
  @useResult
  $Res call({bool success, AppError? error, String? msg, T? value});
}

/// @nodoc
class __$$_ResourceCopyWithImpl<T, $Res>
    extends _$ResourceCopyWithImpl<T, $Res, _$_Resource<T>>
    implements _$$_ResourceCopyWith<T, $Res> {
  __$$_ResourceCopyWithImpl(
      _$_Resource<T> _value, $Res Function(_$_Resource<T>) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? success = null,
    Object? error = freezed,
    Object? msg = freezed,
    Object? value = freezed,
  }) {
    return _then(_$_Resource<T>(
      success: null == success
          ? _value.success
          : success // ignore: cast_nullable_to_non_nullable
              as bool,
      error: freezed == error
          ? _value.error
          : error // ignore: cast_nullable_to_non_nullable
              as AppError?,
      msg: freezed == msg
          ? _value.msg
          : msg // ignore: cast_nullable_to_non_nullable
              as String?,
      value: freezed == value
          ? _value.value
          : value // ignore: cast_nullable_to_non_nullable
              as T?,
    ));
  }
}

/// @nodoc

class _$_Resource<T> implements _Resource<T> {
  const _$_Resource({required this.success, this.error, this.msg, this.value});

  @override
  final bool success;
  @override
  final AppError? error;
  @override
  final String? msg;
  @override
  final T? value;

  @override
  String toString() {
    return 'Resource<$T>(success: $success, error: $error, msg: $msg, value: $value)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_Resource<T> &&
            (identical(other.success, success) || other.success == success) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.msg, msg) || other.msg == msg) &&
            const DeepCollectionEquality().equals(other.value, value));
  }

  @override
  int get hashCode => Object.hash(runtimeType, success, error, msg,
      const DeepCollectionEquality().hash(value));

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_ResourceCopyWith<T, _$_Resource<T>> get copyWith =>
      __$$_ResourceCopyWithImpl<T, _$_Resource<T>>(this, _$identity);
}

abstract class _Resource<T> implements Resource<T> {
  const factory _Resource(
      {required final bool success,
      final AppError? error,
      final String? msg,
      final T? value}) = _$_Resource<T>;

  @override
  bool get success;

  @override
  AppError? get error;

  @override
  String? get msg;

  @override
  T? get value;

  @override
  @JsonKey(ignore: true)
  _$$_ResourceCopyWith<T, _$_Resource<T>> get copyWith =>
      throw _privateConstructorUsedError;
}
