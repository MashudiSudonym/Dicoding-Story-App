import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:formz/formz.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:story_app/login/presentation/bloc/email.dart';
import 'package:story_app/login/presentation/bloc/login_bloc.dart';
import 'package:story_app/login/presentation/bloc/password.dart';
import 'package:story_app/login/presentation/cubit/login_obscure_text_cubit.dart';

class FormLogin extends StatelessWidget {
  const FormLogin({super.key});

  @override
  Widget build(Object context) {
    return BlocListener<LoginBloc, LoginState>(
      listener: (context, state) {
        // ui state flow
        if (state.status.isFailure) {
          ScaffoldMessenger.of(context)
            ..hideCurrentSnackBar()
            ..showSnackBar(
                const SnackBar(content: Text('Authentication Failure 💥')));
        }

        if (state.status.isSuccess) {
          ScaffoldMessenger.of(context)
            ..hideCurrentSnackBar()
            ..showSnackBar(
                const SnackBar(content: Text('Authentication Success 💖💖')));
        }
      },
      child: Padding(
        padding: EdgeInsets.symmetric(horizontal: 16.h),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            _EmailTextField(),
            SizedBox(
              height: 32.h,
            ),
            _PasswordTextField(),
            SizedBox(
              height: 64.h,
            ),
            BlocBuilder<LoginBloc, LoginState>(builder: (context, state) {
              return ElevatedButton(
                style: ElevatedButton.styleFrom(
                  padding: const EdgeInsets.all(16),
                  backgroundColor: const Color(0xff4880FF),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(16.r),
                  ),
                ),
                onPressed: () {
                  context
                      .read<LoginBloc>()
                      .add(const LoginEvent.LoginSubmitted());
                },
                child: Text(
                  'Login',
                  style: GoogleFonts.montserrat(
                    fontSize: 18.sp,
                    fontWeight: FontWeight.w500,
                  ),
                ),
              );
            }),
          ],
        ),
      ),
    );
  }
}

class _PasswordTextField extends StatelessWidget {
  final TextEditingController _passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<LoginBloc, LoginState>(
        buildWhen: (previous, current) => previous.password != current.password,
        builder: (context, state) {
          _passwordController.text = state.password.value;

          return BlocBuilder<LoginObscureTextCubit, LoginObscureTextState>(
              builder: (contextObscureText, stateObscureText) {
            return TextField(
              cursorColor: const Color(0xff4880FF),
              controller: _passwordController,
              textInputAction: TextInputAction.next,
              keyboardType: TextInputType.visiblePassword,
              style: GoogleFonts.montserrat(
                fontSize: 18.sp,
                color: const Color(0xff7A7C7A),
                fontWeight: FontWeight.w400,
              ),
              obscureText: stateObscureText.visible,
              onSubmitted: (password) {
                context
                    .read<LoginBloc>()
                    .add(LoginEvent.LoginPasswordChange(password: password));
              },
              decoration: InputDecoration(
                errorText: state.password.displayError?.text(),
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
                      (stateObscureText.visible)
                          ? FontAwesomeIcons.eye
                          : FontAwesomeIcons.eyeSlash,
                    ),
                    onPressed: () {
                      contextObscureText
                          .read<LoginObscureTextCubit>()
                          .toggleVisibility();
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
            );
          });
        });
  }
}

class _EmailTextField extends StatelessWidget {
  final TextEditingController _emailController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<LoginBloc, LoginState>(
        buildWhen: (previous, current) => previous.email != current.email,
        builder: (context, state) {
          _emailController.text = state.email.value;

          return TextField(
            controller: _emailController,
            textInputAction: TextInputAction.next,
            style: GoogleFonts.montserrat(
              fontSize: 18.sp,
              color: const Color(0xff7A7C7A),
              fontWeight: FontWeight.w400,
            ),
            onSubmitted: (email) {
              context
                  .read<LoginBloc>()
                  .add(LoginEvent.LoginEmailChange(email: email));
            },
            cursorColor: const Color(0xff4880FF),
            decoration: InputDecoration(
              errorText: state.email.displayError?.text(),
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
          );
        });
  }
}

extension on EmailValidationError {
  String text() {
    switch (this) {
      case EmailValidationError.invalid:
        return 'Please ensure the email entered is valid';
    }
  }
}

extension on PasswordValidationError {
  String text() {
    switch (this) {
      case PasswordValidationError.invalid:
        return '''Password must be at least 8 characters and contain at least one letter and number''';
    }
  }
}
