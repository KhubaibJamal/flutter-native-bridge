import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  var platform = const MethodChannel('khubaib');

  showToast() async {
    try {
      print("Invoking showToast method...");
      await platform.invokeMethod("showToast");
      print("Toast invoked successfully!");
    } on PlatformException catch (e) {
      print("Error: ${e.message}");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amber,
      body: Center(
        child: ElevatedButton(
          onPressed: showToast,
          child: const Text("Show Toast"),
        ),
      ),
    );
  }
}
