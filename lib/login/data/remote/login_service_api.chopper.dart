// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'login_service_api.dart';

// **************************************************************************
// ChopperGenerator
// **************************************************************************

// ignore_for_file: always_put_control_body_on_new_line, always_specify_types, prefer_const_declarations, unnecessary_brace_in_string_interps
class _$LoginServiceApi extends LoginServiceApi {
  _$LoginServiceApi([ChopperClient? client]) {
    if (client == null) return;
    this.client = client;
  }

  @override
  final definitionType = LoginServiceApi;

  @override
  Future<Response<dynamic>> postLogin(
    String email,
    String password,
  ) {
    final Uri $url = Uri.parse('login');
    final $body = <String, dynamic>{
      'email': email,
      'password': password,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      body: $body,
    );
    return client.send<dynamic, dynamic>(
      $request,
      requestConverter: FormUrlEncodedConverter.requestFactory,
    );
  }
}
