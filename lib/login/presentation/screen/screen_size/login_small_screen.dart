import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/common/util/extension.dart';
import 'package:story_app/gen/assets.gen.dart';
import 'package:story_app/login/presentation/screen/component/form_login.dart';

class LoginSmallScreen extends StatelessWidget {
  const LoginSmallScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => keyboardDismiss(context),
      child: Scaffold(
        body: ListView(
          keyboardDismissBehavior: ScrollViewKeyboardDismissBehavior.onDrag,
          shrinkWrap: true,
          children: [
            Assets.images.trip.image(width: 300, height: 400),
            const SizedBox(height: 16),
            const FormLogin(),
            const SizedBox(height: 32),
            Center(
              child: RichText(
                text: TextSpan(
                    text: "Don't have an account ? ",
                    style: GoogleFonts.roboto(
                      fontSize: 11,
                      color: Colors.black,
                      fontWeight: FontWeight.w300,
                    ),
                    children: [
                      TextSpan(
                        text: "Sign Up",
                        style: GoogleFonts.roboto(
                          color: const Color(0xff4880FF),
                        ),
                        recognizer: TapGestureRecognizer()
                          ..onTap = () {
                            Constants.logger.d('this clicked');
                          },
                      )
                    ]),
              ),
            ),
            const SizedBox(height: 32),
          ],
        ),
      ),
    );
  }
}
