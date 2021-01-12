package com.jackie.testdialog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/18
 */
public class TestXActivity extends AppCompatActivity {

    private static final String TAG = "TestXActivity============";
    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        String appName = getResources().getString(R.string.app_name);

        Log.i(TAG, "onCreate: =======jackie123=====    "+AlgorithmUtils.INSTANCE.hmacSHA256("jackie"));
        if (savedInstanceState != null){
            Log.i(TAG, "onCreate: =====not null========");
        } else {
            Log.i(TAG, "onCreate: ======is null========");
        }

        TestManager.getInstance().getPrint();
        Log.i(TAG, "onCreate: ============="+android.os.Process.myPid());


//        try {
//            InputStream is = getAssets().open("ic_launcher.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        setContentView(R.layout.activity_tesxx);
        findViewById(R.id.btn_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestXActivity.this.startActivity(new Intent(TestXActivity.this,TestYActivity.class));
            }
        });
        TestManager.getInstance().getPrint();

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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult: ===========");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("appid",android.os.Process.myPid()+"");
        Log.i(TAG, "onSaveInstanceState: ============="+android.os.Process.myPid());
    }
}
