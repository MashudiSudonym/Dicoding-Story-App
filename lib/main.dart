import 'package:flutter/material.dart';
import 'package:story_app/common/di/injection.dart';

void main() async {
  await configureDependencies();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {

    return const Center(
      child: Text('baseUrl'),
    );
  }
}
