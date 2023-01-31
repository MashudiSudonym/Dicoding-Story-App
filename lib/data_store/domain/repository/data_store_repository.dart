abstract class DataStoreRepository {
  Future<void> postLoginToken(String token);
  Future<String> getLoginToken();
}
