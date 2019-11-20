package com.cs.demo;

import android.app.IntentService;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private HandlerThread myHandlerThread ;
    private Handler handler ;

    private Handler mainHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreateHandle();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, BuildConfig.APP_NAME, Toast.LENGTH_LONG).show();
                handler.sendEmptyMessage( 1 ) ;
            }
        });

        mainHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);


            }
        };
        //在主线程给handler发送消息





        //  IntentService
    }

    private void loopThread() {

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        handler.sendEmptyMessage( 1 ) ;
    }





    //线程运行耗时任务，运行完了用handler通知
    private void onCreateHandle(){

        //创建一个线程,线程名字：handler-thread
        myHandlerThread = new HandlerThread( "handler-thread") ;
        //开启一个线程
        myHandlerThread.start();

        //在这个线程中创建一个handler对象
        handler = new Handler( myHandlerThread.getLooper() ){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //这个方法是运行在 handler-thread 线程中的 ，可以执行耗时操作

                Log.i( "TAG " , "消息： " + msg.what + "  线程： " + Thread.currentThread().getName()  ) ;
                loopThread();
            }
        };

    }







    @Override
    protected void onDestroy() {
        super.onDestroy();

        //释放资源
        myHandlerThread.quit() ;
    }
}
