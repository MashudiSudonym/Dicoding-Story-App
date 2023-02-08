import 'dart:io';

import 'package:hive/hive.dart';
import 'package:injectable/injectable.dart';
import 'package:path_provider/path_provider.dart';
import 'package:story_app/common/util/constants.dart';

@module
abstract class DataStoreModule {
  @Named('dirPath')
  Future<Directory> get directory => getApplicationDocumentsDirectory();

  @preResolve
  Future<BoxCollection> storyAppCollection(
          @Named('dirPath') Directory dirPath) =>
      BoxCollection.open(
        Constants.hiveCollectionName,
        {
          Constants.boxCollectionLoginDataStore,
        },
        path: dirPath.path,
      );
}
