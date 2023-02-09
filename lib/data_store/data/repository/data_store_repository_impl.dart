import 'package:hive/hive.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/data_store/domain/repository/data_store_repository.dart';

@Injectable(as: DataStoreRepository)
class DataStoreRepositoryImpl extends DataStoreRepository {
  final Box<dynamic> _dataStoreBox;

  DataStoreRepositoryImpl(this._dataStoreBox);

  @override
  Future<String> getLoginToken() async {
    final loginDataStore = _dataStoreBox;
    final loginTokenData = await loginDataStore.get(Constants.keyLoginToken);
    return loginTokenData;
  }

  @override
  Future<void> postLoginToken(String token) async {
    final loginDataStore = _dataStoreBox;
    await loginDataStore.put(Constants.keyLoginToken, token);
  }
}
