package com.jackie.testdialog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/18
 */
public class TestYActivity extends AppCompatActivity {
    private static final String TAG = "TestYActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_tesyy);
        if (savedInstanceState != null){
            Log.i(TAG, "onCreate: =========savedInstanceState != null====");
        } else {
            Log.i(TAG, "onCreate: =========savedInstanceState == null====");
        }
        TestManager.testDemoClass();


        findViewById(R.id.btn_tsty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestYActivity.this,HandlerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                TestYActivity.this.startActivity(intent);
            }
        });
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
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("appid",android.os.Process.myPid()+"");
        Log.i(TAG, "onSaveInstanceState: ============="+android.os.Process.myPid());
    }
}
