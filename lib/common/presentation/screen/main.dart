import 'package:flutter/material.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:story_app/common/di/injection.dart';
import 'package:story_app/common/util/extension.dart';
import 'package:story_app/dummy/dummy_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Hive.initFlutter();
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
      theme: ThemeData(primarySwatch: Colors.deepPurple),
      home: const SafeArea(
        child: DummyScreen(),
      ),
    );
  }
}
