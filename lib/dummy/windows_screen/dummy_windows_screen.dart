import 'package:flutter/material.dart';
import 'package:story_app/common/util/constants.dart';

class DummyWindowsScreen extends StatelessWidget {
  final Widget dummyWindowsSmallScreen;
  final Widget dummyWindowsLargeScreen;

  const DummyWindowsScreen({
    super.key,
    required this.dummyWindowsLargeScreen,
    required this.dummyWindowsSmallScreen,
  });

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(builder: (context, constraints) {
      if (constraints.maxWidth < Constants.smallScreenWidth) {
        return dummyWindowsSmallScreen;
      } else {
        return dummyWindowsLargeScreen;
      }
    });
  }
}
