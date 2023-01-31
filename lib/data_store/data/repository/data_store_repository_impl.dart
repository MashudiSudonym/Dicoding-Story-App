import 'package:hive/hive.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/data_store/domain/repository/data_store_repository.dart';

@Injectable(as: DataStoreRepository)
class DataStoreRepositoryImpl extends DataStoreRepository {
  final BoxCollection _dataStoreBoxCollection;

  DataStoreRepositoryImpl(this._dataStoreBoxCollection);

  @override
  Future<String> getLoginToken() async {
    final loginDataStore = await _dataStoreBoxCollection
        .openBox(Constants.boxCollectionLoginDataStore);
    final loginTokenData = await loginDataStore.get(Constants.keyLoginToken);

    return loginTokenData;
  }

  @override
  Future<void> postLoginToken(String token) async {
    final loginDataStore = await _dataStoreBoxCollection
        .openBox(Constants.boxCollectionLoginDataStore);
    await loginDataStore.put(Constants.keyLoginToken, token);
  }
}
