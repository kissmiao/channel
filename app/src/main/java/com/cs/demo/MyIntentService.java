package com.cs.demo;


import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyIntentService extends IntentService {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("LOG","onCreate thread id = " + Thread.currentThread().getId() + ",thread name = " + Thread.currentThread().getName());

        Log.i("LOG", "===onCreate=====");
    }

    @Override
    public int onStartCommand( Intent intent, int flags, int startId) {
        Log.i("LOG", "===onStartCommand=====");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart( Intent intent, int startId) {
        Log.i("LOG", "===onStart=====");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("LOG", "===onDestroy============================");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("LOG", "===onBind=====");
        return super.onBind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i("LOG", "===onRebind=====");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("LOG", "===onUnbind=====");
        return super.onUnbind(intent);
    }



    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String name = intent.getStringExtra("name");
        onPrint(name);
        Log.e("LOG","onHandleIntent intent = " + intent.getStringExtra("params") + "  thread id = " + Thread.currentThread().getId() + ",name = "+Thread.currentThread().getName());

    }


    private void onPrint(String name) {
    /*    Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.i("LOG", "========" + Thread.currentThread().getName());

            }
        }, name);


        thread.start();*/
    }
}
