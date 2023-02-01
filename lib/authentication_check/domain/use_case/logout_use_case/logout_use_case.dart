import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/domain/repository/authentication_check_repository.dart';
import 'package:story_app/common/util/constants.dart';

@injectable
class LogoutUseCase {
  final AuthenticationCheckRepository _authenticationCheckRepository;

  LogoutUseCase(this._authenticationCheckRepository);

  Future<void> call() async {
    await _authenticationCheckRepository.saveToken(Constants.blankString);
  }
}
