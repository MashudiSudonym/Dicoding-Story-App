import 'package:dartz/dartz.dart';
import 'package:injectable/injectable.dart';
import 'package:story_app/authentication_check/domain/model/authentication_token.dart';
import 'package:story_app/authentication_check/domain/use_case/get_token_from_data_store_use_case/get_token_from_data_store_use_case.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/common/util/failure/failure.dart';
import 'package:story_app/common/util/failure/server_failure.dart';
import 'package:story_app/common/util/resource.dart';
import 'package:story_app/list_story/domain/model/list_story_response.dart';
import 'package:story_app/list_story/domain/model/story_response.dart';
import 'package:story_app/list_story/domain/repository/list_story_repository.dart';

@injectable
class ShowListStoryUseCase {
  final ListStoryRepository _listStoryRepository;
  final GetTokenFromDataStoreUseCase _getTokenFromDataStoreUseCase;

  ShowListStoryUseCase(
    this._listStoryRepository,
    this._getTokenFromDataStoreUseCase,
  );

  Future<Either<Failure, ListStoryResponse>> call() async {
    final getToken = await _getTokenFromDataStoreUseCase();
    final resultGetToken = getToken.fold(
      (failure) => const AuthenticationToken(token: Constants.blankString),
      (response) => response,
    );
    final resource =
        await _listStoryRepository.getListStory(resultGetToken.token);

    if (resource is Success) {
      return Right(
        resource.data ??
            const ListStoryResponse(
              error: false,
              message: Constants.blankString,
              listStoryResponse: <StoryResponse>[],
            ),
      );
    } else {
      return Left(ServerFailure(message: resource.message));
    }
  }
}
