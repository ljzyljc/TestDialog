package com.jackie.testdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.IdlingResource;

import com.jackie.testdialog.utils.MessageDelayer;
import com.jackie.testdialog.utils.SimpleCountingIdingResource;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/23
 */
public class TestAActivity extends AppCompatActivity implements MessageDelayer.DelayerCallback {


    // The Idling Resource which will be null in production.
    @Nullable private SimpleCountingIdingResource mIdlingResource;
    /**
     * Only called from test, creates and returns a new {@link SimpleCountingIdingResource}.
     */
    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleCountingIdingResource();
        }
        return mIdlingResource;
    }

    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_a);
        textView = findViewById(R.id.txt_a);
        editText = findViewById(R.id.editText);


        findViewById(R.id.btn_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                textView.setText("shimei");
                MessageDelayer.processMessage("jackie",TestAActivity.this,mIdlingResource);
            }
        });
    }

    @Override
    public void onDone(String text) {
        textView.setText(text);
    }
}
