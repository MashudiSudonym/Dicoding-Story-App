import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class AdaptiveScreen extends StatelessWidget {
  final Widget? androidScreen;
  final Widget? webScreen;
  final Widget? windowsScreen;
  final Widget? iOSScreen;
  final Widget? fuchsiaScreen;
  final Widget? macOSScreen;
  final Widget? linuxScreen;

  const AdaptiveScreen({
    super.key,
    this.androidScreen,
    this.webScreen,
    this.windowsScreen,
    this.iOSScreen,
    this.fuchsiaScreen,
    this.linuxScreen,
    this.macOSScreen,
  });

  @override
  Widget build(BuildContext context) {
    if (kIsWeb) {
      return webScreen ?? const Placeholder();
    } else {
      switch (defaultTargetPlatform) {
        case TargetPlatform.android:
          return androidScreen ?? const Placeholder();
        case TargetPlatform.windows:
          return windowsScreen ?? const Placeholder();
        case TargetPlatform.iOS:
          return iOSScreen ?? const Placeholder();
        case TargetPlatform.fuchsia:
          return fuchsiaScreen ?? const Placeholder();
        case TargetPlatform.linux:
          return linuxScreen ?? const Placeholder();
        case TargetPlatform.macOS:
          return macOSScreen ?? const Placeholder();
        default:
          return androidScreen ?? const Placeholder();
      }
    }
  }
}
