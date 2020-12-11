package com.jackie.testdialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/2
 */
public class TestBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "TestBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: ===1====");
        try {
            //这里接受的都是前台广播
            //Thread.sleep(9000); //不发生anr
            Thread.sleep(11000); //发生anr
            //这里接受的都是后台广播
            //Thread.sleep(65000); //发生anr
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "onReceive: ===2====");
    }
}
