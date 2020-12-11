package com.jackie.testdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/10/21
 */
public class MyTextView extends Button {
    private static final String TAG = "MyTextView=====jackie====";
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.i(TAG, "dispatchTouchEvent: ======");
//        return super.dispatchTouchEvent(event);
//    }
}
