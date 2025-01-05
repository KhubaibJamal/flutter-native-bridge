package com.example.flutter_native_bridge;

import android.widget.Toast;

import io.flutter.embedding.android.FlutterActivity;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "khubaib";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);

//        var channel = MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if (call.method.equals("showToast")) {
                                Toast.makeText(this, "Toast from Java!", Toast.LENGTH_SHORT).show();
                                result.success(null);
                            } else {
                                result.notImplemented();
                            }
                        }
                );
    }
}
