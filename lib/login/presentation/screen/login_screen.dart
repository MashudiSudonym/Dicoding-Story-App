import 'package:flutter/material.dart';
import 'package:story_app/common/di/injection.dart';
import 'package:story_app/common/presentation/util/adaptive_screen.dart';
import 'package:story_app/common/presentation/util/orientation_screen.dart';
import 'package:story_app/common/presentation/util/responsive_landscape_screen.dart';
import 'package:story_app/common/presentation/util/responsive_portrait_screen.dart';
import 'package:story_app/login/domain/use_case/user_login_use_case.dart';
import 'package:story_app/login/presentation/bloc/login_bloc.dart';
import 'package:story_app/login/presentation/cubit/login_obscure_text_cubit.dart';
import 'package:story_app/login/presentation/screen/screen_size/login_landscape_screen.dart';
import 'package:story_app/login/presentation/screen/screen_size/login_portrait_screen.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MultiBlocProvider(
      providers: [
        BlocProvider(
          create: (context) => LoginBloc(
            getIt<UserLoginUseCase>(),
          ),
        ),
        BlocProvider(
          create: (context) => LoginObscureTextCubit(),
        ),
      ],
      child: const AdaptiveScreen(
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
      ),
    );
  }
}
