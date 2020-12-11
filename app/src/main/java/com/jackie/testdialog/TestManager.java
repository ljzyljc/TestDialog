package com.jackie.testdialog;

import android.util.Log;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/12/2
 */
class TestManager {
    private static final String TAG = "TestManager";
    private static TestManager mInstance;
    private TestManager(){

    }

    //public static DemoClass demoClass;

    public static void testDemoClass(){
        mInstance.testY();
    }

    private void testY(){
        Log.i(TAG, "test: ========测试是否NullPointException===");
    }


    public static TestManager getInstance(){
        if (mInstance == null){
            mInstance = new TestManager();
        }
        return mInstance;
    }

    public void getPrint(){
        //demoClass = new DemoClass();
        Log.i(TAG, "getPrint: ========");
    }

//    public static class DemoClass{
//        public void test(){
//            Log.i(TAG, "test: ========测试是否NullPointException===");
//        }
//    }

}
