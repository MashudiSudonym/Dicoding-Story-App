import 'package:flutter/material.dart';
import 'package:story_app/common/util/constants.dart';

class ResponsiveLandscapeScreen extends StatelessWidget {
  final Widget? smallScreen;
  final Widget? mediumScreen;
  final Widget? expandedScreen;

  const ResponsiveLandscapeScreen({
    super.key,
    this.smallScreen,
    this.mediumScreen,
    this.expandedScreen,
  });

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(builder: (context, constraints) {
      if (constraints.maxHeight < Constants.smallScreenHeight) {
        return smallScreen ?? Text('${constraints.maxHeight}');
      }

      if (constraints.maxHeight >= Constants.expandedScreenHeight) {
        return expandedScreen ?? Text('${constraints.maxHeight}');
      }

      if (Constants.smallScreenHeight <= constraints.maxHeight &&
          constraints.maxHeight < Constants.expandedScreenHeight) {
        return mediumScreen ?? Text('${constraints.maxHeight}');
      }

      return Text('${constraints.maxHeight}');
    });
  }
}
