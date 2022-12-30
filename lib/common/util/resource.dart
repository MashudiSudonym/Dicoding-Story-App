import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:story_app/common/util/app_error.dart';

part 'resource.freezed.dart';

@freezed
abstract class Resource<T> with _$Resource<T> {
  const factory Resource({
    required bool success,
    AppError? error,
    String? msg,
    T? value,
  }) = _Resource<T>;
}