import 'package:flutter/material.dart';
import 'package:story_app/common/presentation/util/adaptive_screen.dart';
import 'package:story_app/dummy/android_screen/dummy_android_screen.dart';
import 'package:story_app/dummy/example_screen/dummy_large_screen.dart';
import 'package:story_app/dummy/example_screen/dummy_small_screen.dart';
import 'package:story_app/dummy/windows_screen/dummy_windows_screen.dart';

class DummyScreen extends StatefulWidget {
  const DummyScreen({Key? key}) : super(key: key);

  @override
  State<DummyScreen> createState() => _DummyScreenState();
}

class _DummyScreenState extends State<DummyScreen> {
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: AdaptiveScreen(
        androidScreen: DummyAndroidScreen(
          dummyAndroidLargeScreen: DummyLargeScreen(),
          dummyAndroidSmallScreen: DummySmallScreen(),
        ),
        windowsScreen: DummyWindowsScreen(
          dummyWindowsLargeScreen: DummyLargeScreen(),
          dummyWindowsSmallScreen: DummySmallScreen(),
        ),
      ),
    );
  }
}
