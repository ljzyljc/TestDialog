package com.jackie.testdialog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/3
 */
public class ANRWatchDog extends Thread {

    private static final String TAG = "ANR";
    private int timeout = 5000;
    private boolean ignoreDebugger = true;

    static ANRWatchDog sWatchdog;

    private Handler mainHandler = new Handler(Looper.getMainLooper());

    private class ANRChecker implements Runnable{

        private boolean mCompleted;
        private long mStartTime;
        //这个值记录了系统启动到当前时刻经过的时间
        private long executeTime = SystemClock.uptimeMillis();

        @Override
        public void run() {
            synchronized (ANRWatchDog.this) {
                mCompleted = true;
                executeTime = SystemClock.uptimeMillis();
            }
        }

        void schedule() {
            mCompleted = false;
            mStartTime = SystemClock.uptimeMillis();
            //每次都post到该队列的前面
            mainHandler.postAtFrontOfQueue(this);
        }

        boolean isBlocked() {
            return !mCompleted || executeTime - mStartTime >= 5000;
        }
    }

    public interface ANRListener {
        void onAnrHappened(String stackTraceInfo);
    }

    private ANRChecker anrChecker = new ANRChecker();

    private ANRListener anrListener;

    public void addANRListener(ANRListener listener){
        this.anrListener = listener;
    }

    public static ANRWatchDog getInstance(){
        if(sWatchdog == null){
            sWatchdog = new ANRWatchDog();
        }
        return sWatchdog;
    }

    private ANRWatchDog(){
        super("ANR-WatchDog-Thread");
    }

    @Override
    public void run() {
        //super.run();
        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND); //设置为后台线程
        while (true){
            while (!isInterrupted()){
                synchronized (this){
                    anrChecker.schedule();
                    long waitTime = timeout;
                    long start = SystemClock.uptimeMillis();
                    //确保sleep一定的时间，防止假唤醒
                    while (waitTime > 0){
                        try{
                            wait(waitTime);
                        } catch (InterruptedException e){
                            Log.w(TAG, "run: ", e);
                        }
                        waitTime = timeout - (SystemClock.uptimeMillis() - start);
                    }
                    if (!anrChecker.isBlocked()){
                        continue;
                    }
                }
                if (!ignoreDebugger && Debug.isDebuggerConnected()){
                    continue;
                }
                String stackTraceInfo = getStackTraceInfo();
                if (anrListener != null){
                    anrListener.onAnrHappened(stackTraceInfo);
                }
            }
            anrListener = null;

        }

    }



    private String getStackTraceInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
            stringBuilder
                    .append(stackTraceElement.toString())
                    .append("\r\n");
        }
        return stringBuilder.toString();
    }
}
