// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'story_response_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

StoryResponseDTO _$StoryResponseDTOFromJson(Map<String, dynamic> json) {
  return _StoryResponseDTO.fromJson(json);
}

/// @nodoc
mixin _$StoryResponseDTO {
  @JsonKey(name: 'id')
  String get id => throw _privateConstructorUsedError;
  @JsonKey(name: 'name')
  String get name => throw _privateConstructorUsedError;
  @JsonKey(name: 'description')
  String get description => throw _privateConstructorUsedError;
  @JsonKey(name: 'photoUrl')
  String get photoUrl => throw _privateConstructorUsedError;
  @JsonKey(name: 'createAt')
  String get createAt => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $StoryResponseDTOCopyWith<StoryResponseDTO> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $StoryResponseDTOCopyWith<$Res> {
  factory $StoryResponseDTOCopyWith(
          StoryResponseDTO value, $Res Function(StoryResponseDTO) then) =
      _$StoryResponseDTOCopyWithImpl<$Res, StoryResponseDTO>;
  @useResult
  $Res call(
      {@JsonKey(name: 'id') String id,
      @JsonKey(name: 'name') String name,
      @JsonKey(name: 'description') String description,
      @JsonKey(name: 'photoUrl') String photoUrl,
      @JsonKey(name: 'createAt') String createAt});
}

/// @nodoc
class _$StoryResponseDTOCopyWithImpl<$Res, $Val extends StoryResponseDTO>
    implements $StoryResponseDTOCopyWith<$Res> {
  _$StoryResponseDTOCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? name = null,
    Object? description = null,
    Object? photoUrl = null,
    Object? createAt = null,
  }) {
    return _then(_value.copyWith(
      id: null == id
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      name: null == name
          ? _value.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      description: null == description
          ? _value.description
          : description // ignore: cast_nullable_to_non_nullable
              as String,
      photoUrl: null == photoUrl
          ? _value.photoUrl
          : photoUrl // ignore: cast_nullable_to_non_nullable
              as String,
      createAt: null == createAt
          ? _value.createAt
          : createAt // ignore: cast_nullable_to_non_nullable
              as String,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_StoryResponseDTOCopyWith<$Res>
    implements $StoryResponseDTOCopyWith<$Res> {
  factory _$$_StoryResponseDTOCopyWith(
          _$_StoryResponseDTO value, $Res Function(_$_StoryResponseDTO) then) =
      __$$_StoryResponseDTOCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {@JsonKey(name: 'id') String id,
      @JsonKey(name: 'name') String name,
      @JsonKey(name: 'description') String description,
      @JsonKey(name: 'photoUrl') String photoUrl,
      @JsonKey(name: 'createAt') String createAt});
}

/// @nodoc
class __$$_StoryResponseDTOCopyWithImpl<$Res>
    extends _$StoryResponseDTOCopyWithImpl<$Res, _$_StoryResponseDTO>
    implements _$$_StoryResponseDTOCopyWith<$Res> {
  __$$_StoryResponseDTOCopyWithImpl(
      _$_StoryResponseDTO _value, $Res Function(_$_StoryResponseDTO) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? name = null,
    Object? description = null,
    Object? photoUrl = null,
    Object? createAt = null,
  }) {
    return _then(_$_StoryResponseDTO(
      id: null == id
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      name: null == name
          ? _value.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      description: null == description
          ? _value.description
          : description // ignore: cast_nullable_to_non_nullable
              as String,
      photoUrl: null == photoUrl
          ? _value.photoUrl
          : photoUrl // ignore: cast_nullable_to_non_nullable
              as String,
      createAt: null == createAt
          ? _value.createAt
          : createAt // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_StoryResponseDTO implements _StoryResponseDTO {
  const _$_StoryResponseDTO(
      {@JsonKey(name: 'id') required this.id,
      @JsonKey(name: 'name') required this.name,
      @JsonKey(name: 'description') required this.description,
      @JsonKey(name: 'photoUrl') required this.photoUrl,
      @JsonKey(name: 'createAt') required this.createAt});

  factory _$_StoryResponseDTO.fromJson(Map<String, dynamic> json) =>
      _$$_StoryResponseDTOFromJson(json);

  @override
  @JsonKey(name: 'id')
  final String id;
  @override
  @JsonKey(name: 'name')
  final String name;
  @override
  @JsonKey(name: 'description')
  final String description;
  @override
  @JsonKey(name: 'photoUrl')
  final String photoUrl;
  @override
  @JsonKey(name: 'createAt')
  final String createAt;

  @override
  String toString() {
    return 'StoryResponseDTO(id: $id, name: $name, description: $description, photoUrl: $photoUrl, createAt: $createAt)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_StoryResponseDTO &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.description, description) ||
                other.description == description) &&
            (identical(other.photoUrl, photoUrl) ||
                other.photoUrl == photoUrl) &&
            (identical(other.createAt, createAt) ||
                other.createAt == createAt));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode =>
      Object.hash(runtimeType, id, name, description, photoUrl, createAt);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_StoryResponseDTOCopyWith<_$_StoryResponseDTO> get copyWith =>
      __$$_StoryResponseDTOCopyWithImpl<_$_StoryResponseDTO>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_StoryResponseDTOToJson(
      this,
    );
  }
}

abstract class _StoryResponseDTO implements StoryResponseDTO {
  const factory _StoryResponseDTO(
          {@JsonKey(name: 'id') required final String id,
          @JsonKey(name: 'name') required final String name,
          @JsonKey(name: 'description') required final String description,
          @JsonKey(name: 'photoUrl') required final String photoUrl,
          @JsonKey(name: 'createAt') required final String createAt}) =
      _$_StoryResponseDTO;

  factory _StoryResponseDTO.fromJson(Map<String, dynamic> json) =
      _$_StoryResponseDTO.fromJson;

  @override
  @JsonKey(name: 'id')
  String get id;
  @override
  @JsonKey(name: 'name')
  String get name;
  @override
  @JsonKey(name: 'description')
  String get description;
  @override
  @JsonKey(name: 'photoUrl')
  String get photoUrl;
  @override
  @JsonKey(name: 'createAt')
  String get createAt;
  @override
  @JsonKey(ignore: true)
  _$$_StoryResponseDTOCopyWith<_$_StoryResponseDTO> get copyWith =>
      throw _privateConstructorUsedError;
}
