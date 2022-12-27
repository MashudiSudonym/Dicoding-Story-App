import 'package:freezed_annotation/freezed_annotation.dart';

part 'resource.freezed.dart';

@freezed
class Resource<T> with _$Resource<T> {
  const factory Resource.loading(bool isLoading) = Loading<T>;
  const factory Resource.error(String message, T? data) = Error<T>;
  const factory Resource.success(T? data) = Success<T>;
}
