import 'package:flutter/material.dart';
import 'package:story_app/common/util/constants.dart';

class DummyWebScreen extends StatelessWidget {
  final Widget dummyWebSmallScreen;
  final Widget dummyWebLargeScreen;

  const DummyWebScreen({
    super.key,
    required this.dummyWebLargeScreen,
    required this.dummyWebSmallScreen,
  });

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(builder: (context, constraints) {
      if (constraints.maxWidth < Constants.smallScreenWidth) {
        return dummyWebSmallScreen;
      } else {
        return dummyWebLargeScreen;
      }
    });
  }
}
