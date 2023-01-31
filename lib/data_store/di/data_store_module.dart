import 'package:injectable/injectable.dart';
import 'package:hive/hive.dart';

@module
abstract class DataStoreModule {
  @preResolve
  Future<BoxCollection> storyAppCollection() => BoxCollection.open(
        'story_app_collection',
        {
          'login_data_store',
        },
        path: './',
      );
}
