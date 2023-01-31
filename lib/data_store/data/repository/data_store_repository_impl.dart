import 'package:hive/hive.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/data_store/domain/repository/data_store_repository.dart';

@Injectable(as: DataStoreRepository)
class DataStoreRepositoryImpl extends DataStoreRepository {
  final BoxCollection _dataStoreBoxCollection;

  DataStoreRepositoryImpl(this._dataStoreBoxCollection);

  @override
  Future<String> getLoginToken() async {
    final loginDataStore =
        await _dataStoreBoxCollection.openBox('login_data_store');
    final loginTokenData = await loginDataStore.get('login_token');

    return loginTokenData;
  }

  @override
  Future<void> postLoginToken(String token) async {
    final loginDataStore =
        await _dataStoreBoxCollection.openBox('login_data_store');
    await loginDataStore.put('login_token', token);
  }
}
