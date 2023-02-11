import 'package:flutter/material.dart';

class OrientationScreen extends StatelessWidget {
  final Widget? responsiveLandscapeScreen;
  final Widget? responsivePortraitScreen;

  const OrientationScreen({
    super.key,
    this.responsiveLandscapeScreen,
    this.responsivePortraitScreen,
  });

  @override
  Widget build(BuildContext context) {
    return OrientationBuilder(builder: (context, orientation) {
      if (orientation == Orientation.portrait) {
        return responsivePortraitScreen ?? Text('$orientation');
      } else {
        return responsiveLandscapeScreen ?? Text('$orientation');
      }
    });
  }
}
