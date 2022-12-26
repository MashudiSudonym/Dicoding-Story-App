import 'package:logger/logger.dart';

class Constants {
  final logger = Logger();
  static const baseUrlApi = 'https://story-api.dicoding.dev/v1';
  static const registerApi = 'register';
  static const loginApi = 'login';
  static const storiesApi = 'stories';
  static const paramLocation = 'stories?location=1';
}
