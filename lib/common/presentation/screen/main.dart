import 'package:flutter/material.dart';
import 'package:story_app/common/di/injection.dart';
import 'package:story_app/common/util/extension.dart';
import 'package:story_app/login/presentation/screen/login_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
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
      home: const LoginScreen(),
    );
  }
}
