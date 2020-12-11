package com.jackie.testdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

import java.net.URL;

public class Test2Activity extends Activity {
    private static final String TAG = "Test2Activity=====jackie======";
    private static final String ACTION_BOOT = "android.intent.jackie";
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.i(TAG, "handleMessage: ===="+msg.what);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        Log.i(TAG, "onCreate: ");
        Log.i(TAG, "onCreate: ");
        new HandlerThread("jackie").start();
//        new HandlerThread(new Runnable() {
//            @Override
//            public void run() {
//                Log.i(TAG, "run: =========="+Thread.currentThread().getName());
//            }
//        }).start();
//        Message msg = Message.obtain();
//        msg.what = 1000;
//        handler.sendMessageDelayed(msg,6000);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ANRTest();
//                sleepTest();
//                Log.d(TAG, "onClick: ---1");
//                //test1();
//                //Test2Activity.this.startActivity(new Intent(Test2Activity.this,MainActivity.class));
//                //Test2Activity.this.startService(new Intent(Test2Activity.this,TestService.class));
//                //BroadcastReceiver
//                Intent intent = new Intent("android.intent.jackie");
//                //设置为前台广播，默认是后台广播
//                intent.setPackage(getPackageName()); //一定要设置包名，否则无法显示anr,具体暂不深究
//                //intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);
//                Test2Activity.this.sendBroadcast(intent);
//                //ContentProvider
//
//                try {
//                    Thread.sleep(10_000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });



    }

    void ANRTest(){
        handler = new Handler();
        ANRWatchDog.getInstance().addANRListener(new ANRWatchDog.ANRListener() {
            @Override
            public void onAnrHappened(String stackTraceInfo) {
                Log.i(TAG, "onAnrHappened: =======发生了ANR: "+ stackTraceInfo);
            }
        });
        ANRWatchDog.getInstance().start();
        //模拟场景，通过handler发送消息sleep 10秒，我们ANR的检测工具就会检测到自己发送的消息超过5s没有被处理，发生了"ANR"了。
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },3000);

    }

    public void sleepTest(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Button button = findViewById(R.id.btn);
                button.setText("jackie");
            }
        },7000);
        try {
            Thread.sleep(10_000);
            Log.i(TAG, "onCreate: ====2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent: ============");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        try {
//            Thread.sleep(10000);
//            Log.i(TAG, "onStart: ====2");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Log.i(TAG, "onStart: ");
//    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
//        registerReceiver(new TestBroadcastReceiver(),new IntentFilter(ACTION_BOOT));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: =======");
        return super.dispatchTouchEvent(ev);
    }

    //vm api 29
    public void test(){
        Dialog alert = new Dialog(getApplicationContext());
        alert.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog,null);
        alert.setContentView(view);
        //alert.setCancelable(false);
        //alert.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        alert.show();
    }
    //vm api 18
    public void test1(){
        Dialog alert = new Dialog(getApplicationContext());
        alert.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog,null);
        alert.setContentView(view);
        //alert.setCancelable(false);
        //alert.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        alert.show();
    }
}
