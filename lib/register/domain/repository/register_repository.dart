import 'package:story_app/common/util/resource.dart';
import 'package:story_app/register/domain/model/register_response.dart';

abstract class RegisterRepository {
  Future<Resource<RegisterResponse>> postRegister(
    String name,
    String email,
    String password,
  );
}
