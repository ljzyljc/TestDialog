package com.jackie.testdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/10/21
 */
public class MyLinearLayout extends LinearLayout {
    private static final String TAG = "MyLinearLayout=====jackie===";
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.i(TAG, "dispatchTouchEvent: =============");
//        return super.dispatchTouchEvent(ev);
//    }
}
