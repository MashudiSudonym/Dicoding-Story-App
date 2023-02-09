import 'package:flutter/material.dart';
import 'package:story_app/common/util/extension.dart';
import 'package:story_app/common/util/field_validation_mixin.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> with FieldValidationMixin {
  late TextEditingController emailController;
  late TextEditingController passwordController;

  GlobalKey<FormState> loginKey = GlobalKey<FormState>();

  bool passwordVisible = false;
  bool validEmail = false;

  @override
  void initState() {
    emailController = TextEditingController();
    passwordController = TextEditingController();
    super.initState();
  }

  @override
  void dispose() {
    emailController.dispose();
    passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: GestureDetector(
        onTap: () => keyboardDismiss(context),
        child: Scaffold(
          body: ListView(
            keyboardDismissBehavior: ScrollViewKeyboardDismissBehavior.onDrag,
            shrinkWrap: true,
            children: [
              buildLoginScreen(),
            ],
          ),
        ),
      ),
    );
  }

  Widget buildLoginScreen() {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 16),
      child: Form(
        key: loginKey,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const SizedBox(
              height: 150,
            ),
            const Text('Login'),
            const SizedBox(
              height: 16,
            ),
            TextFormField(
              controller: emailController,
              textInputAction: TextInputAction.next,
              decoration: const InputDecoration(
                  border: InputBorder.none,
                  fillColor: Color(0xffF8FAFB),
                  filled: true,
                  hintText: 'Email'),
              validator: (email) {
                return isEmailValid(email ?? '') ? null : 'Enter Valid Email';
              },
            ),
            const SizedBox(
              height: 16,
            ),
            TextFormField(
              controller: passwordController,
              textInputAction: TextInputAction.next,
              decoration: const InputDecoration(
                border: InputBorder.none,
                fillColor: Color(0xffF8fAFB),
                filled: true,
                hintText: 'Password',
              ),
              validator: (password) {
                return isPasswordValid(password ?? '')
                    ? null
                    : 'Password should be 8 Characters';
              },
            ),
            const SizedBox(
              height: 16,
            ),
            Align(
              alignment: Alignment.centerRight,
              child: InkWell(
                child: Text(
                  'Forgot Password ?',
                  style: TextStyle(
                    color: Colors.red.withOpacity(0.8),
                    fontSize: 12,
                  ),
                ),
              ),
            ),
            const SizedBox(
              height: 16,
            ),
            InkWell(
              onTap: () {
                if (loginKey.currentState?.validate() ?? false) {
                  // TODO: do something
                }
              },
              child: Container(
                height: 45,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(6),
                  color: Colors.red.withOpacity(0.8),
                ),
                child: const Center(
                  child: Text(
                    'Login',
                    style: TextStyle(
                      color: Colors.white,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
