import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:story_app/common/util/constants.dart';
import 'package:story_app/common/util/field_validation_mixin.dart';

class FormLogin extends StatefulWidget {
  const FormLogin({Key? key}) : super(key: key);

  @override
  State<FormLogin> createState() => _FormLoginState();
}

class _FormLoginState extends State<FormLogin> with FieldValidationMixin {
  late TextEditingController _emailController;
  late TextEditingController _passwordController;

  final GlobalKey<FormState> _loginKey = GlobalKey<FormState>();

  bool _passwordVisible = true;

  @override
  void initState() {
    _emailController = TextEditingController();
    _passwordController = TextEditingController();
    super.initState();
  }

  @override
  void dispose() {
    _emailController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.symmetric(horizontal: 16.h),
      child: Form(
        key: _loginKey,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextFormField(
              controller: _emailController,
              textInputAction: TextInputAction.next,
              style: GoogleFonts.montserrat(
                fontSize: 18.sp,
                color: const Color(0xff7A7C7A),
                fontWeight: FontWeight.w400,
              ),
              validator: (email) {
                if (isEmailValid(email ?? '')) {
                  return null;
                } else {
                  if (email == '') {
                    return 'Email can not be blank';
                  } else {
                    return 'Enter Valid Email';
                  }
                }
              },
              cursorColor: const Color(0xff4880FF),
              decoration: InputDecoration(
                label: Text(
                  'Email',
                  style: GoogleFonts.montserrat(
                    fontSize: 16.sp,
                    fontWeight: FontWeight.w400,
                    color: const Color(0xff7A7C7A),
                  ),
                ),
                contentPadding: EdgeInsets.symmetric(horizontal: 6.w),
                focusedBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(16.r),
                  borderSide: const BorderSide(
                    color: Color(0xff4880FF),
                  ),
                ),
                focusedErrorBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(16.r),
                  borderSide: const BorderSide(
                    color: Color(0xffff486a),
                  ),
                ),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(16.r),
                  borderSide: const BorderSide(
                    color: Color(0xffBBBCBC),
                  ),
                ),
                fillColor: const Color(0xffF8FAFB),
                filled: true,
                hintText: 'email',
                hintStyle: GoogleFonts.montserrat(
                  fontSize: 18.sp,
                  color: const Color(0xffBBBCBC),
                  fontWeight: FontWeight.w400,
                ),
              ),
            ),
            SizedBox(
              height: 32.h,
            ),
            TextFormField(
              cursorColor: const Color(0xff4880FF),
              controller: _passwordController,
              textInputAction: TextInputAction.next,
              keyboardType: TextInputType.visiblePassword,
              validator: (password) {
                return isPasswordValid(password ?? '')
                    ? null
                    : 'Password should be 8 characters';
              },
              style: GoogleFonts.montserrat(
                fontSize: 18.sp,
                color: const Color(0xff7A7C7A),
                fontWeight: FontWeight.w400,
              ),
              obscureText: _passwordVisible,
              decoration: InputDecoration(
                label: Text(
                  'Password',
                  style: GoogleFonts.montserrat(
                    fontSize: 16.sp,
                    fontWeight: FontWeight.w400,
                    color: const Color(0xff7A7C7A),
                  ),
                ),
                contentPadding: EdgeInsets.symmetric(horizontal: 6.w),
                focusedBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(16.r),
                  borderSide: const BorderSide(
                    color: Color(0xff4880FF),
                  ),
                ),
                focusedErrorBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(16.r),
                  borderSide: const BorderSide(
                    color: Color(0xffff486a),
                  ),
                ),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(16.r),
                  borderSide: const BorderSide(
                    color: Color(0xffBBBCBC),
                  ),
                ),
                fillColor: const Color(0xffF8FAFB),
                filled: true,
                suffixIcon: Padding(
                  padding: EdgeInsets.symmetric(horizontal: 4.w),
                  child: IconButton(
                    splashRadius: 1,
                    icon: FaIcon(
                      color: const Color(0xffBBBCBC),
                      size: 18.sp,
                      (_passwordVisible)
                          ? FontAwesomeIcons.eye
                          : FontAwesomeIcons.eyeSlash,
                    ),
                    onPressed: () {
                      setState(() {
                        _passwordVisible = !_passwordVisible;
                      });
                    },
                  ),
                ),
                hintText: 'password',
                hintStyle: GoogleFonts.montserrat(
                  fontSize: 18.sp,
                  color: const Color(0xffBBBCBC),
                  fontWeight: FontWeight.w400,
                ),
              ),
            ),
            SizedBox(
              height: 64.h,
            ),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                padding: const EdgeInsets.all(16),
                backgroundColor: const Color(0xff4880FF),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(16.r),
                ),
              ),
              onPressed: () {
                if (_loginKey.currentState?.validate() ?? false) {
                  Constants.logger.d('clicked validate');
                }
              },
              child: Text(
                'Login',
                style: GoogleFonts.montserrat(
                  fontSize: 18.sp,
                  fontWeight: FontWeight.w500,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
