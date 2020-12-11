package com.jackie.testdialog;

import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/23
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class MyActivityTest {

    @Test
    public void clickTest() throws Exception{

        TestAActivity activity = Robolectric.setupActivity(TestAActivity.class);
        Button button = activity.findViewById(R.id.btn_a);
        TextView textView = activity.findViewById(R.id.txt_a);
        button.performClick();
        Assert.assertEquals("jackie",textView.getText().toString());

    }



}
