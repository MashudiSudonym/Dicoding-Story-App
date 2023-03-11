import 'package:hive/hive.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/constants.dart';

@module
abstract class DataStoreModule {
  @preResolve
  Future<Box<dynamic>> storyAppCollection() =>
      Hive.openBox(Constants.boxCollectionLoginDataStore);
}
