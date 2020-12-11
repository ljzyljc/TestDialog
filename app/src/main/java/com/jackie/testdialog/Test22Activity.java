package com.jackie.testdialog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/18
 */
public class Test22Activity extends AppCompatActivity {

    private static final String TAG = "Test22Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_tes22);
        findViewById(R.id.btn_test22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test22Activity.this.startActivity(new Intent(Test22Activity.this,TestYActivity.class));
            }
        });
    }
}
