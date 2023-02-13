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
        style: GoogleFonts.montserrat(
          fontSize: 12.sp,
          color: const Color(0xff959595),
          fontWeight: FontWeight.w400,
        ),
        children: [
          TextSpan(
            text: "Register",
            style: GoogleFonts.montserrat(
                color: const Color(0xff4880FF), fontWeight: FontWeight.w500),
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
