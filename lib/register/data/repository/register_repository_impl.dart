import 'package:injectable/injectable.dart';
import 'package:story_app/common/data/remote/api_services.dart';
import 'package:story_app/register/data/mapper/register_mapper.dart';
import 'package:story_app/register/data/remote/dto/register_response_dto.dart';
import 'package:story_app/register/domain/model/register_response.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/register/domain/repository/register_repository.dart';

@Injectable(as: RegisterRepository)
class RegisterRepositoryImpl implements RegisterRepository {
  final ApiServices _apiServices;

  RegisterRepositoryImpl(this._apiServices);

  @override
  Future<Resource<RegisterResponse>> postRegister(
    String name,
    String email,
    String password,
  ) async {
    Resource<RegisterResponse> result;

    try {
      final responseRegister =
          await _apiServices.postRegister(name, email, password);

      if (responseRegister.isSuccessful) {
        result = Resource.success(
          RegisterResponseDTO.fromJson(responseRegister.body)
              .toRegisterResponse(),
        );
      } else {
        result = Resource.error(
          RegisterResponseDTO.fromJson(
                  responseRegister.error as Map<String, Object?>)
              .toRegisterResponse()
              .message,
          RegisterResponseDTO.fromJson(
                  responseRegister.error as Map<String, Object?>)
              .toRegisterResponse(),
        );
      }
    } catch (e) {
      result = Resource.error(e.toString(), null);
    } finally {
      _apiServices.client.dispose();
    }

    return result;
  }
}
