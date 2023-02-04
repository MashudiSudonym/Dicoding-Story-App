import 'package:flutter/material.dart';
import 'package:story_app/common/di/injection.dart';
import 'package:story_app/common/util/extension.dart';

void main() async {
  await configureDependencies();
  setupLogging();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Story App",
      theme: ThemeData(
        useMaterial3: true,
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepOrange),
      ),
      home: const Scaffold(
        body: Center(
          child: Text('data'),
        ),
      ),
    );
  }
}
