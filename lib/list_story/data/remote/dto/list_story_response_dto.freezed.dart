// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'list_story_response_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

ListStoryResponseDTO _$ListStoryResponseDTOFromJson(Map<String, dynamic> json) {
  return _ListStoryResponseDTO.fromJson(json);
}

/// @nodoc
mixin _$ListStoryResponseDTO {
  @JsonKey(name: 'error')
  bool get error => throw _privateConstructorUsedError;
  @JsonKey(name: 'message')
  String get message => throw _privateConstructorUsedError;
  @JsonKey(name: 'listStory')
  List<StoryResponseDTO?>? get listStoryResponseDTO =>
      throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $ListStoryResponseDTOCopyWith<ListStoryResponseDTO> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $ListStoryResponseDTOCopyWith<$Res> {
  factory $ListStoryResponseDTOCopyWith(ListStoryResponseDTO value,
          $Res Function(ListStoryResponseDTO) then) =
      _$ListStoryResponseDTOCopyWithImpl<$Res, ListStoryResponseDTO>;
  @useResult
  $Res call(
      {@JsonKey(name: 'error')
          bool error,
      @JsonKey(name: 'message')
          String message,
      @JsonKey(name: 'listStory')
          List<StoryResponseDTO?>? listStoryResponseDTO});
}

/// @nodoc
class _$ListStoryResponseDTOCopyWithImpl<$Res,
        $Val extends ListStoryResponseDTO>
    implements $ListStoryResponseDTOCopyWith<$Res> {
  _$ListStoryResponseDTOCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? error = null,
    Object? message = null,
    Object? listStoryResponseDTO = freezed,
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
      listStoryResponseDTO: freezed == listStoryResponseDTO
          ? _value.listStoryResponseDTO
          : listStoryResponseDTO // ignore: cast_nullable_to_non_nullable
              as List<StoryResponseDTO?>?,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_ListStoryResponseDTOCopyWith<$Res>
    implements $ListStoryResponseDTOCopyWith<$Res> {
  factory _$$_ListStoryResponseDTOCopyWith(_$_ListStoryResponseDTO value,
          $Res Function(_$_ListStoryResponseDTO) then) =
      __$$_ListStoryResponseDTOCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {@JsonKey(name: 'error')
          bool error,
      @JsonKey(name: 'message')
          String message,
      @JsonKey(name: 'listStory')
          List<StoryResponseDTO?>? listStoryResponseDTO});
}

/// @nodoc
class __$$_ListStoryResponseDTOCopyWithImpl<$Res>
    extends _$ListStoryResponseDTOCopyWithImpl<$Res, _$_ListStoryResponseDTO>
    implements _$$_ListStoryResponseDTOCopyWith<$Res> {
  __$$_ListStoryResponseDTOCopyWithImpl(_$_ListStoryResponseDTO _value,
      $Res Function(_$_ListStoryResponseDTO) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? error = null,
    Object? message = null,
    Object? listStoryResponseDTO = freezed,
  }) {
    return _then(_$_ListStoryResponseDTO(
      error: null == error
          ? _value.error
          : error // ignore: cast_nullable_to_non_nullable
              as bool,
      message: null == message
          ? _value.message
          : message // ignore: cast_nullable_to_non_nullable
              as String,
      listStoryResponseDTO: freezed == listStoryResponseDTO
          ? _value._listStoryResponseDTO
          : listStoryResponseDTO // ignore: cast_nullable_to_non_nullable
              as List<StoryResponseDTO?>?,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_ListStoryResponseDTO implements _ListStoryResponseDTO {
  const _$_ListStoryResponseDTO(
      {@JsonKey(name: 'error')
          required this.error,
      @JsonKey(name: 'message')
          required this.message,
      @JsonKey(name: 'listStory')
          final List<StoryResponseDTO?>? listStoryResponseDTO})
      : _listStoryResponseDTO = listStoryResponseDTO;

  factory _$_ListStoryResponseDTO.fromJson(Map<String, dynamic> json) =>
      _$$_ListStoryResponseDTOFromJson(json);

  @override
  @JsonKey(name: 'error')
  final bool error;
  @override
  @JsonKey(name: 'message')
  final String message;
  final List<StoryResponseDTO?>? _listStoryResponseDTO;
  @override
  @JsonKey(name: 'listStory')
  List<StoryResponseDTO?>? get listStoryResponseDTO {
    final value = _listStoryResponseDTO;
    if (value == null) return null;
    if (_listStoryResponseDTO is EqualUnmodifiableListView)
      return _listStoryResponseDTO;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  String toString() {
    return 'ListStoryResponseDTO(error: $error, message: $message, listStoryResponseDTO: $listStoryResponseDTO)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_ListStoryResponseDTO &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.message, message) || other.message == message) &&
            const DeepCollectionEquality()
                .equals(other._listStoryResponseDTO, _listStoryResponseDTO));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode => Object.hash(runtimeType, error, message,
      const DeepCollectionEquality().hash(_listStoryResponseDTO));

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_ListStoryResponseDTOCopyWith<_$_ListStoryResponseDTO> get copyWith =>
      __$$_ListStoryResponseDTOCopyWithImpl<_$_ListStoryResponseDTO>(
          this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_ListStoryResponseDTOToJson(
      this,
    );
  }
}

abstract class _ListStoryResponseDTO implements ListStoryResponseDTO {
  const factory _ListStoryResponseDTO(
          {@JsonKey(name: 'error')
              required final bool error,
          @JsonKey(name: 'message')
              required final String message,
          @JsonKey(name: 'listStory')
              final List<StoryResponseDTO?>? listStoryResponseDTO}) =
      _$_ListStoryResponseDTO;

  factory _ListStoryResponseDTO.fromJson(Map<String, dynamic> json) =
      _$_ListStoryResponseDTO.fromJson;

  @override
  @JsonKey(name: 'error')
  bool get error;
  @override
  @JsonKey(name: 'message')
  String get message;
  @override
  @JsonKey(name: 'listStory')
  List<StoryResponseDTO?>? get listStoryResponseDTO;
  @override
  @JsonKey(ignore: true)
  _$$_ListStoryResponseDTOCopyWith<_$_ListStoryResponseDTO> get copyWith =>
      throw _privateConstructorUsedError;
}
