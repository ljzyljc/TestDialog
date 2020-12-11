package com.jackie.testdialog;

import android.app.Application;
import android.util.Log;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/17
 */
public class App extends Application {
    private static final String TAG = "App";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ====App====");
    }
}
