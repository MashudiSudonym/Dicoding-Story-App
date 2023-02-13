import 'package:flutter/material.dart';
import 'package:story_app/common/presentation/util/adaptive_screen.dart';
import 'package:story_app/common/presentation/util/orientation_screen.dart';
import 'package:story_app/common/presentation/util/responsive_landscape_screen.dart';
import 'package:story_app/common/presentation/util/responsive_portrait_screen.dart';
import 'package:story_app/login/presentation/screen/screen_size/login_landscape_screen.dart';
import 'package:story_app/login/presentation/screen/screen_size/login_portrait_screen.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const AdaptiveScreen(
      androidScreen: OrientationScreen(
        responsiveLandscapeScreen: ResponsiveLandscapeScreen(
          smallScreen: LoginPortraitScreen(),
          mediumScreen: LoginLandscapeScreen(),
          expandedScreen: LoginLandscapeScreen(),
        ),
        responsivePortraitScreen: ResponsivePortraitScreen(
          smallScreen: LoginPortraitScreen(),
          mediumScreen: LoginLandscapeScreen(),
          expandedScreen: LoginPortraitScreen(),
        ),
      ),
      webScreen: OrientationScreen(
        responsiveLandscapeScreen: ResponsiveLandscapeScreen(
          smallScreen: LoginLandscapeScreen(),
          mediumScreen: LoginLandscapeScreen(),
          expandedScreen: LoginLandscapeScreen(),
        ),
        responsivePortraitScreen: ResponsivePortraitScreen(
          smallScreen: LoginPortraitScreen(),
          mediumScreen: LoginPortraitScreen(),
          expandedScreen: LoginPortraitScreen(),
        ),
      ),
    );
  }
}
