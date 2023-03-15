import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:story_app/common/util/extension.dart';
import 'package:story_app/gen/assets.gen.dart';
import 'package:story_app/login/presentation/screen/component/form_login.dart';
import 'package:story_app/login/presentation/screen/component/wording_dont_have_account.dart';

class LoginLandscapeScreen extends StatelessWidget {
  const LoginLandscapeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => keyboardDismiss(context),
      child: Scaffold(
        body: Center(
          child: SingleChildScrollView(
            keyboardDismissBehavior: ScrollViewKeyboardDismissBehavior.onDrag,
            child: Row(
              children: [
                Expanded(
                  flex: 2,
                  child: Assets.images.trip.image(width: 512.w, height: 512.h),
                ),
                Expanded(
                  flex: 1,
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      FormLogin(),
                      SizedBox(height: 64.h),
                      const Center(
                        child: WordingDontHaveAccount(),
                      ),
                      SizedBox(height: 16.h),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
