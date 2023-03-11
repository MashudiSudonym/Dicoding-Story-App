import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:story_app/common/util/extension.dart';
import 'package:story_app/gen/assets.gen.dart';
import 'package:story_app/login/presentation/screen/component/form_login.dart';
import 'package:story_app/login/presentation/screen/component/wording_dont_have_account.dart';

class LoginPortraitScreen extends StatelessWidget {
  const LoginPortraitScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => keyboardDismiss(context),
      child: Scaffold(
        body: ListView(
          keyboardDismissBehavior: ScrollViewKeyboardDismissBehavior.onDrag,
          shrinkWrap: true,
          children: [
            Assets.images.trip.image(),
            SizedBox(height: 16.h),
            FormLogin(),
            SizedBox(height: 32.h),
            const Center(
              child: WordingDontHaveAccount(),
            ),
            SizedBox(height: 16.h),
          ],
        ),
      ),
    );
  }
}
