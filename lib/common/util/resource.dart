import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:story_app/common/util/app_error.dart';

part 'resource.freezed.dart';

@freezed
class Resource<T> with _$Resource<T> {
  const factory Resource({
    @Default(false) bool success,
    AppError? error,
    String? message,
    T? value,
  }) = _Resource<T>;
}
