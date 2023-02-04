import 'package:story_app/common/util/resource.dart';
import 'package:story_app/list_story/domain/model/list_story_response.dart';

abstract class ListStoryRepository {
  Future<Resource<ListStoryResponse>> getListStory(String token);
}
