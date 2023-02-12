import 'package:flutter/material.dart';
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
      padding: const EdgeInsets.all(16),
      child: Form(
        key: _loginKey,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              'Email',
              style: GoogleFonts.roboto(
                fontSize: 14,
                fontWeight: FontWeight.w500,
              ),
            ),
            TextFormField(
              controller: _emailController,
              textInputAction: TextInputAction.next,
              validator: (email) {
                return isEmailValid(email ?? '') ? null : 'Enter Valid Email';
              },
              decoration: InputDecoration(
                border: InputBorder.none,
                fillColor: const Color(0xffF8FAFB),
                filled: true,
                hintText: 'email',
                hintStyle: GoogleFonts.roboto(
                  fontSize: 12,
                  fontWeight: FontWeight.w300,
                ),
              ),
            ),
            const SizedBox(
              height: 16,
            ),
            Text(
              'Password',
              style: GoogleFonts.roboto(
                fontSize: 14,
                fontWeight: FontWeight.w500,
              ),
            ),
            TextFormField(
              controller: _passwordController,
              textInputAction: TextInputAction.next,
              validator: (password) {
                return isPasswordValid(password ?? '')
                    ? null
                    : 'Password should be 8 characters';
              },
              obscureText: _passwordVisible,
              decoration: InputDecoration(
                border: InputBorder.none,
                fillColor: const Color(0xffF8FAFB),
                filled: true,
                suffixIcon: IconButton(
                  icon: FaIcon(
                    color: const Color(0xff4880FF),
                    size: 14,
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
                hintText: 'password',
                hintStyle: GoogleFonts.roboto(
                  fontSize: 12,
                  fontWeight: FontWeight.w300,
                ),
              ),
            ),
            const SizedBox(
              height: 16,
            ),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color(0xff4880FF),
              ),
              onPressed: () {
                if (_loginKey.currentState?.validate() ?? false) {
                  Constants.logger.d('clicked validate');
                }
              },
              child: Text(
                'Login',
                style: GoogleFonts.roboto(
                  fontSize: 14,
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
