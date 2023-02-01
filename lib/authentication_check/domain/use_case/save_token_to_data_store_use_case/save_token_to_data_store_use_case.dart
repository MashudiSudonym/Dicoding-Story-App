import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/domain/repository/authentication_check_repository.dart';

@injectable
class SaveTokenToDataStoreUseCase {
  final AuthenticationCheckRepository _authenticationCheckRepository;

  SaveTokenToDataStoreUseCase(this._authenticationCheckRepository);

  Future<void> call(String token) async {
    await _authenticationCheckRepository.saveToken(token);
  }
}
