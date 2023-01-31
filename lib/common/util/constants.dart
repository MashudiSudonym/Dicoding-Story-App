import 'package:logger/logger.dart';

class Constants {
  static final logger = Logger();
  static const baseUrlApi = 'https://story-api.dicoding.dev/v1';
  static const rootUrlApi = '/';
  static const registerApi = 'register';
  static const loginApi = 'login';
  static const storiesApi = 'stories';
  static const paramLocation = 'stories?location=1';
  static const email = 'email';
  static const password = 'password';
  static const hiveCollectionName = 'story_app_collection';
  static const boxCollectionLoginDataStore = 'login_data_store';
  static const keyLoginToken = 'login_token';
}
