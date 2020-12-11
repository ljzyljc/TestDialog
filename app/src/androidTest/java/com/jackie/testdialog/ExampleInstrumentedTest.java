package com.jackie.testdialog;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<HandlerActivity> mActivityRule = new ActivityScenarioRule<>(HandlerActivity.class);

    private String emailMatches = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+";
    private Pattern emailPattern = Pattern.compile(emailMatches);

    private String testErrorGmail = "jackie123@@gmail.com";
    private String testGmail = "jackie123@gmail.com";

//    @Rule
//    public ActivityScenarioRule<LoginActivity> mTest2ActivityRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void leftIconClick(){
//        onView(withId(R.id.four_btn)).perform(typeText("MAIN THREAD SHOW"));
        //校验文字正确

        onView(withId(R.id.four_btn)).check(matches(withText("MAIN THREAD SHOW")));

        SystemClock.sleep(2000);

        //跳转的到登录界面
        onView(withId(R.id.four_btn)).perform(click());

        //验证正则表达式
        onView(withId(R.id.username)).perform(clearText(),typeText(testGmail),closeSoftKeyboard())
                .check(matches(withText(new BaseMatcher<String>() {
                    @Override
                    public boolean matches(Object item) {
                        return emailPattern.matcher(testGmail).matches();
                    }

                    @Override
                    public void describeTo(Description description) {

                    }
                })));

        SystemClock.sleep(1000);

        onView(withId(R.id.password)).perform(clearText(),typeText("123456"),closeSoftKeyboard());

        onView(withId(R.id.login)).perform(click());

        onView(withId(R.id.username)).check(matches(withText(new BaseMatcher<String>() {
            @Override
            public boolean matches(Object item) {
                return emailPattern.matcher(testGmail).matches();
            }

            @Override
            public void describeTo(Description description) {

            }
        })));
        onView(withId(R.id.password)).check(matches(withText("123456")));

        SystemClock.sleep(10000);

        onView(withId(R.id.tvLoginSuccess)).check(matches(withText("登录成功")));


    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.jackie.testdialog", appContext.getPackageName());
    }
}
