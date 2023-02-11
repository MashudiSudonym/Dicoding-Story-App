import 'package:flutter/material.dart';
import 'package:story_app/common/presentation/util/adaptive_screen.dart';
import 'package:story_app/common/presentation/util/orientation_screen.dart';
import 'package:story_app/common/presentation/util/responsive_landscape_screen.dart';
import 'package:story_app/common/presentation/util/responsive_portrait_screen.dart';
import 'package:story_app/login/presentation/screen/screen_size/login_expanded_screen.dart';
import 'package:story_app/login/presentation/screen/screen_size/login_medium_screen.dart';
import 'package:story_app/login/presentation/screen/screen_size/login_small_screen.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const AdaptiveScreen(
      androidScreen: OrientationScreen(
        responsiveLandscapeScreen: ResponsiveLandscapeScreen(
          smallScreen: LoginSmallScreen(),
          mediumScreen: LoginMediumScreen(),
          expandedScreen: LoginExpandedScreen(),
        ),
        responsivePortraitScreen: ResponsivePortraitScreen(
          smallScreen: LoginSmallScreen(),
          mediumScreen: LoginMediumScreen(),
          expandedScreen: LoginExpandedScreen(),
        ),
      ),
    );
  }
}
