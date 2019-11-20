package com.cs.demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("LOG","onCreate thread id = " + Thread.currentThread().getId() + ",thread name = " + Thread.currentThread().getName());

        Log.i("LOG", "MyService===onCreate=====");
    }

    @Override
    public int onStartCommand( Intent intent, int flags, int startId) {
        Log.i("LOG", "MyService===onStartCommand=====");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart( Intent intent, int startId) {
        Log.i("LOG", "MyService===onStart=====");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("LOG", "MyService===onDestroy============================");
        super.onDestroy();
    }



    @Override
    public void onRebind(Intent intent) {
        Log.i("LOG", "MyService===onRebind=====");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("LOG", "MyService===onUnbind=====");
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("LOG", "MyService===onBind=====");
        return null;
    }
}
