import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:story_app/common/di/injection.dart';
import 'package:story_app/common/util/extension.dart';
import 'package:story_app/login/presentation/screen/login_screen.dart';

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
    return ScreenUtilInit(
      builder: (context, child) => MaterialApp(
        title: "Story App",
        theme: ThemeData(primarySwatch: Colors.deepPurple),
        home: child,
      ),
      splitScreenMode: true,
      minTextAdapt: true,
      child: const SafeArea(
        child: LoginScreen(),
      ),
    );
  }
}
