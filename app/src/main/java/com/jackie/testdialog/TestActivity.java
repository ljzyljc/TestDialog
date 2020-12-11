package com.jackie.testdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends FragmentActivity {
    private List<View>viewList = new ArrayList<>();
    private static final String TAG = "TestActivity=====jackie======";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Log.i(TAG, "onCreate: ");


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpage);


        //把Fragment添加到List集合里面
        List<Fragment> list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);


//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: 1");
//                TestActivity.this.startActivity(new Intent(TestActivity.this,MainActivity.class));
//            }
//        });



    }


    public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
        private FragmentManager mfragmentManager;
        private List<Fragment> mlist;

        //这是一段构造器，我没写的时候，第一次代码是报错的，在我做了下面这个构造器之后，没有报错！！！
        public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mlist = list;
        }
        //显示第几个页面
        @Override
        public Fragment getItem(int position) {
            return mlist.get(position);
        }
        //一共有几个页面，注意，使用Fragment特有的构造器时，和ViewPager的原生构造器的方法不同
        @Override
        public int getCount() {
            return mlist.size();
        }
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: =======");
        return super.dispatchTouchEvent(ev);
    }

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
