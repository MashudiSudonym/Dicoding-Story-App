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
        body: ListView(
          children: [
            Row(
              children: [
                Expanded(
                  child: Assets.images.trip.image(),
                ),
                Expanded(
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Padding(
                        padding: EdgeInsets.all(16.h),
                        child: const FormLogin(),
                      ),
                      SizedBox(height: 16.h),
                      const Center(
                        child: WordingDontHaveAccount(),
                      ),
                      SizedBox(height: 16.h),
                    ],
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
