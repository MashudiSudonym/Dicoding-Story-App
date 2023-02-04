import 'package:injectable/injectable.dart';
import 'package:story_app/common/data/remote/api_services.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/list_story/data/mapper/list_story_mapper.dart';
import 'package:story_app/list_story/data/remote/dto/list_story_response_dto.dart';
import 'package:story_app/list_story/domain/model/list_story_response.dart';
import 'package:story_app/list_story/domain/repository/list_story_repository.dart';

@Injectable(as: ListStoryRepository)
class ListStoryRepositoryImpl implements ListStoryRepository {
  final ApiServices _apiServices;

  ListStoryRepositoryImpl(this._apiServices);

  @override
  Future<Resource<ListStoryResponse>> getListStory(String token) async {
    Resource<ListStoryResponse> result;

    try {
      final responseListStory =
          await _apiServices.getListStory('${Constants.bearer}$token');

      if (responseListStory.isSuccessful) {
        result = Resource.success(
          ListStoryResponseDTO.fromJson(responseListStory.body)
              .toListStoryResponse(),
        );
      } else {
        result = Resource.error(
          ListStoryResponseDTO.fromJson(
                  responseListStory.error as Map<String, Object?>)
              .toListStoryResponse()
              .message,
          ListStoryResponseDTO.fromJson(
                  responseListStory.error as Map<String, Object?>)
              .toListStoryResponse(),
        );
      }
    } catch (e) {
      result = Resource.error(e.toString(), null);
    }

    return result;
  }
}
