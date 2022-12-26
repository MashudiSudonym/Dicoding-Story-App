import 'package:freezed_annotation/freezed_annotation.dart';

part 'resource.freezed.dart';

@freezed
abstract class Resource<T> with _$Resource<T> {
  const factory Resource.loading(bool isLoading) = Loading<T>;
}
