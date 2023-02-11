import 'package:flutter/material.dart';
import 'package:story_app/common/util/constants.dart';

class ResponsivePortraitScreen extends StatelessWidget {
  final Widget? smallScreen;
  final Widget? mediumScreen;
  final Widget? expandedScreen;

  const ResponsivePortraitScreen({
    super.key,
    this.smallScreen,
    this.mediumScreen,
    this.expandedScreen,
  });

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(builder: (context, constraints) {
      if (constraints.maxWidth < Constants.smallScreenWidth) {
        return smallScreen ?? Text('${constraints.maxWidth}');
      }

      if (constraints.maxWidth >= Constants.expandedScreenWidth) {
        return expandedScreen ?? Text('${constraints.maxWidth}');
      }

      if (Constants.smallScreenWidth <= constraints.maxWidth &&
          constraints.maxWidth < Constants.expandedScreenWidth) {
        return mediumScreen ?? Text('${constraints.maxWidth}');
      }

      return Text('${constraints.maxWidth}');
    });
  }
}
