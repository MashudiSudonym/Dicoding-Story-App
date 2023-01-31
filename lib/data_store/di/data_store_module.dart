import 'package:injectable/injectable.dart';
import 'package:hive/hive.dart';
import 'package:story_app/common/util/constants.dart';

@module
abstract class DataStoreModule {
  @preResolve
  Future<BoxCollection> storyAppCollection() => BoxCollection.open(
        Constants.hiveCollectionName,
        {
          Constants.boxCollectionLoginDataStore,
        },
        path: './',
      );
}
