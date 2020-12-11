package com.jackie.testdialog;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/2
 */
public class TestService extends Service {
    private static final String TAG = "TestService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Log.i(TAG, "onCreate: ====1===");
            //Thread.sleep(19000);  //不发生anr
            Thread.sleep(21000); //发生anr
            Log.i(TAG, "onCreate: ====2====");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
