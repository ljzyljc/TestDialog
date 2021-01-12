package com.jackie.testdialog;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/4
 */
public class TwoFragment extends BaseFragment {
    private static final String TAG = "TwoFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_two, null);
        Log.i(TAG, "onCreateView: ");

        return view;
    }
}
