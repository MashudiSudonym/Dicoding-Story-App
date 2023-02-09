import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class DummySmallScreen extends StatelessWidget {
  const DummySmallScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Small Screen'),
      ),
      backgroundColor: Colors.deepOrange[200],
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Expanded(
              child: Padding(
                padding: const EdgeInsets.all(8),
                child: AspectRatio(
                  aspectRatio: 16 / 9,
                  child: Container(
                    color: Colors.deepOrange[400],
                    child: Center(
                        child: Text(
                            (kIsWeb) ? 'web' : defaultTargetPlatform.name)),
                  ),
                ),
              ),
            ),
            Expanded(
              child: ListView.builder(
                itemCount: 108,
                itemBuilder: (context, index) {
                  return Padding(
                    padding: const EdgeInsets.all(8),
                    child: Container(
                      color: Colors.deepOrange[300],
                      height: 30,
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
