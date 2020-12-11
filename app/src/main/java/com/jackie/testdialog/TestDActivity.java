package com.jackie.testdialog;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import android.util.LogPrinter;
import android.util.Printer;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/25
 */
public class TestDActivity extends AppCompatActivity {
    private static final String TAG = "TestDActivity=============";
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i(TAG, "handleMessage: ============");
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_a);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: =====================");
            }
        },10000);
        haoShi();
        
//        Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
//            @Override
//            public boolean queueIdle() {
////                Log.i(TAG, "queueIdle: ========================");
//                return false;
//            }
//        });
//        Log.i(TAG, "onCreate: ==============");
//        Looper.getMainLooper()
//                .setMessageLogging(new LogPrinter(Log.DEBUG,TAG));
        //postMessage();



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
        //haoShi();

    }

    private HashMap<String,String> hashMap = new HashMap<String,String>();
    private void haoShi(){
        long current = System.currentTimeMillis();
        for (int i = 0; i < 7000000; i++) {
            hashMap.put(i+"abc","i"+"def");
        }
        long time = System.currentTimeMillis() - current;
        System.out.println("jackie========="+time);
    }

    private void postMessage() {


            findViewById(R.id.btn_a).post(new Runnable() {
                @Override
                public void run() {
                    Log.i(TAG, "postMessage: =====1======");
                    try {
                        Thread.sleep(1000);
//                        Looper.getMainLooper()
//                                .setMessageLogging(null);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    postMessage();
                }
            });


    }

}
