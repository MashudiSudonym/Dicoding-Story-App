import 'package:logger/logger.dart';

class Constants {
  static final logger = Logger();
  static const baseUrlApi = 'https://story-api.dicoding.dev/v1';
  static const registerApi = 'register';
  static const loginApi = 'login';
  static const storiesApi = 'stories';
  static const paramLocation = 'stories?location=1';
  static const name = 'name';
  static const email = 'email';
  static const password = 'password';
  static const hiveCollectionName = 'story_app_collection';
  static const boxCollectionLoginDataStore = 'login_data_store';
  static const keyLoginToken = 'login_token';
  static const blankString = '';
  static const authenticationFailedMessage = 'authentication failed';
  static const tokenIsEmptyMessage = 'token is empty';
  static const isAuthenticated = true;
  static const authorization = "Authorization";
  static const bearer = "Bearer ";
  static const contentType = 'Content-Type';
  static const applicationJson = 'application/json';
  static const smallScreenWidth = 600;
  static const expandedScreenWidth = 840;
  static const smallScreenHeight = 480;
  static const expandedScreenHeight = 900;
}
