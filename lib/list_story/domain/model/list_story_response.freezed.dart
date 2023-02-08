// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'list_story_response.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

ListStoryResponse _$ListStoryResponseFromJson(Map<String, dynamic> json) {
  return _ListStoryResponse.fromJson(json);
}

/// @nodoc
mixin _$ListStoryResponse {
  bool get error => throw _privateConstructorUsedError;
  String get message => throw _privateConstructorUsedError;
  List<StoryResponse?>? get listStoryResponse =>
      throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $ListStoryResponseCopyWith<ListStoryResponse> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $ListStoryResponseCopyWith<$Res> {
  factory $ListStoryResponseCopyWith(
          ListStoryResponse value, $Res Function(ListStoryResponse) then) =
      _$ListStoryResponseCopyWithImpl<$Res, ListStoryResponse>;
  @useResult
  $Res call(
      {bool error, String message, List<StoryResponse?>? listStoryResponse});
}

/// @nodoc
class _$ListStoryResponseCopyWithImpl<$Res, $Val extends ListStoryResponse>
    implements $ListStoryResponseCopyWith<$Res> {
  _$ListStoryResponseCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? error = null,
    Object? message = null,
    Object? listStoryResponse = freezed,
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
      listStoryResponse: freezed == listStoryResponse
          ? _value.listStoryResponse
          : listStoryResponse // ignore: cast_nullable_to_non_nullable
              as List<StoryResponse?>?,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_ListStoryResponseCopyWith<$Res>
    implements $ListStoryResponseCopyWith<$Res> {
  factory _$$_ListStoryResponseCopyWith(_$_ListStoryResponse value,
          $Res Function(_$_ListStoryResponse) then) =
      __$$_ListStoryResponseCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {bool error, String message, List<StoryResponse?>? listStoryResponse});
}

/// @nodoc
class __$$_ListStoryResponseCopyWithImpl<$Res>
    extends _$ListStoryResponseCopyWithImpl<$Res, _$_ListStoryResponse>
    implements _$$_ListStoryResponseCopyWith<$Res> {
  __$$_ListStoryResponseCopyWithImpl(
      _$_ListStoryResponse _value, $Res Function(_$_ListStoryResponse) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? error = null,
    Object? message = null,
    Object? listStoryResponse = freezed,
  }) {
    return _then(_$_ListStoryResponse(
      error: null == error
          ? _value.error
          : error // ignore: cast_nullable_to_non_nullable
              as bool,
      message: null == message
          ? _value.message
          : message // ignore: cast_nullable_to_non_nullable
              as String,
      listStoryResponse: freezed == listStoryResponse
          ? _value._listStoryResponse
          : listStoryResponse // ignore: cast_nullable_to_non_nullable
              as List<StoryResponse?>?,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_ListStoryResponse implements _ListStoryResponse {
  const _$_ListStoryResponse(
      {required this.error,
      required this.message,
      final List<StoryResponse?>? listStoryResponse})
      : _listStoryResponse = listStoryResponse;

  factory _$_ListStoryResponse.fromJson(Map<String, dynamic> json) =>
      _$$_ListStoryResponseFromJson(json);

  @override
  final bool error;
  @override
  final String message;
  final List<StoryResponse?>? _listStoryResponse;
  @override
  List<StoryResponse?>? get listStoryResponse {
    final value = _listStoryResponse;
    if (value == null) return null;
    if (_listStoryResponse is EqualUnmodifiableListView)
      return _listStoryResponse;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  String toString() {
    return 'ListStoryResponse(error: $error, message: $message, listStoryResponse: $listStoryResponse)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_ListStoryResponse &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.message, message) || other.message == message) &&
            const DeepCollectionEquality()
                .equals(other._listStoryResponse, _listStoryResponse));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode => Object.hash(runtimeType, error, message,
      const DeepCollectionEquality().hash(_listStoryResponse));

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_ListStoryResponseCopyWith<_$_ListStoryResponse> get copyWith =>
      __$$_ListStoryResponseCopyWithImpl<_$_ListStoryResponse>(
          this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_ListStoryResponseToJson(
      this,
    );
  }
}

abstract class _ListStoryResponse implements ListStoryResponse {
  const factory _ListStoryResponse(
      {required final bool error,
      required final String message,
      final List<StoryResponse?>? listStoryResponse}) = _$_ListStoryResponse;

  factory _ListStoryResponse.fromJson(Map<String, dynamic> json) =
      _$_ListStoryResponse.fromJson;

  @override
  bool get error;
  @override
  String get message;
  @override
  List<StoryResponse?>? get listStoryResponse;
  @override
  @JsonKey(ignore: true)
  _$$_ListStoryResponseCopyWith<_$_ListStoryResponse> get copyWith =>
      throw _privateConstructorUsedError;
}
