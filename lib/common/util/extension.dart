import 'package:flutter/material.dart';
import 'package:logging/logging.dart';
import 'package:story_app/common/util/constants.dart';

// Chopper already uses the Logger package. Printing the logs to the console requires
// the following setup.
void setupLogging() {
  Logger.root.level = Level.ALL;
  Logger.root.onRecord.listen((rec) {
    Constants.logger.d('${rec.level.name}: ${rec.time}: ${rec.message}');
  });
}

void keyboardDismiss(BuildContext context) {
  return FocusScope.of(context).unfocus();
}
