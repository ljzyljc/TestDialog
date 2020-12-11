package com.jackie.testdialog;

import android.app.Application;
import android.util.Log;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/2
 */
public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ==a===");
//        try {
//            Thread.sleep(21_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.i(TAG, "onCreate: ===b===");

    }
}
