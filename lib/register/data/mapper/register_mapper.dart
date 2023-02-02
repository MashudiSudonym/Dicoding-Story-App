import 'package:story_app/register/data/remote/dto/register_response_dto.dart';
import 'package:story_app/register/domain/model/register_response.dart';

extension RegisterResultDTOExtension on RegisterResponseDTO {
  RegisterResponse toRegisterResponse() => RegisterResponse(
        error: error,
        message: message,
      );
}
