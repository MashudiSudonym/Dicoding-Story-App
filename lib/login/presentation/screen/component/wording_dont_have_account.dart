import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:story_app/common/util/constants.dart';

class WordingDontHaveAccount extends StatelessWidget {
  const WordingDontHaveAccount({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return RichText(
      text: TextSpan(
        text: "Don't have an account ? ",
        style: GoogleFonts.roboto(
          fontSize: 12.sp,
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
          ),
        ],
      ),
    );
  }
}
