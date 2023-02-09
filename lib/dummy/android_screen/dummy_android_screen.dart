import 'package:flutter/material.dart';
import 'package:story_app/common/util/constants.dart';

class DummyAndroidScreen extends StatelessWidget {
  final Widget dummyAndroidSmallScreen;
  final Widget dummyAndroidLargeScreen;

  const DummyAndroidScreen({
    super.key,
    required this.dummyAndroidLargeScreen,
    required this.dummyAndroidSmallScreen,
  });

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(builder: (context, constraints) {
      if (constraints.maxWidth < Constants.smallScreenWidth) {
        return dummyAndroidSmallScreen;
      } else {
        return dummyAndroidLargeScreen;
      }
    });
  }
}
