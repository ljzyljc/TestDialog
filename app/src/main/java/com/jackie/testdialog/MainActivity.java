package com.jackie.testdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.PopupWindowCompat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity=====jackie======";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!this.isTaskRoot()) { // 当前类不是该Task的根部，那么之前启动
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) { // 当前类是从桌面启动的
                    finish(); // finish掉该类，直接打开该Task中现存的Activity
                    return;
                }
            }
        }
        MainActivity.this.startActivity(new Intent(MainActivity.this,TestActivity.class));

        setContentView(R.layout.activity_main);
//        Log.i(TAG, "onCreate: ");
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                MainActivity.this.startActivity(new Intent(MainActivity.this,TestActivity.class));
//            }
//        },2000);
//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: 1");
////                TestPopupWindow mWindow = new TestPopupWindow(MainActivity.this);
//////根据指定View定位
////                PopupWindowCompat.showAsDropDown(mWindow, findViewById(R.id.btn), 0, 0, Gravity.START);
//////或者
//////                mWindow.showAsDropDown(...);
////////又或者使用showAtLocation根据屏幕来定位
//////                mWindow.showAtLocation(...);
////                for (int i = 0;i<10;i++){
////                    Toast.makeText(MainActivity.this,"jackie",Toast.LENGTH_SHORT).show();
////                }
//
//
//                //test1();
//            }
//        });



    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
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

    public class TestPopupWindow extends PopupWindow {

        public TestPopupWindow(Context context) {
            super(context);
            setHeight(300);
            setWidth(300);
            setOutsideTouchable(true);
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            View contentView = LayoutInflater.from(context).inflate(R.layout.activity_main,
                    null, false);
            setContentView(contentView);
        }
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.i(TAG, "dispatchTouchEvent: =======");
//        return super.dispatchTouchEvent(ev);
//    }

    //vm api 29
    public void test(){
        Dialog alert = new Dialog(getApplicationContext());
        alert.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog,null);
        alert.setContentView(view);
        //alert.setCancelable(false);

        //alert.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        alert.show();
    }
    //vm api 18
    public void test1(){
        Dialog alert = new Dialog(getApplicationContext());
        alert.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog,null);
        alert.setContentView(view);
        //alert.setCancelable(false);
        //alert.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        alert.show();
    }
}
