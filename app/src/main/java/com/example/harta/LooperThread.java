package com.example.harta;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;


import androidx.annotation.NonNull;

import java.util.logging.LogRecord;

public class LooperThread extends Thread {

    private static final String TAG = LooperThread.class.getSimpleName();

    Handler handler;

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
            }
        };

        Looper.loop();
    }
}
