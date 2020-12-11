package com.jackie.testdialog;

import android.app.Activity;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/24
 */
@RunWith(AndroidJUnit4.class)
public class TestAsynAActivity {

//    @Rule
//    public ActivityScenarioRule<TestAActivity> scenarioRule = new ActivityScenarioRule<>(TestAActivity.class);

    private IdlingResource idlingResource;

    private static String NAME = "jackie";

    @Before
    public void registerIdlingResource() throws Exception{

        try {
            ActivityScenario activityScenario = ActivityScenario.launch(TestAActivity.class);
            activityScenario.onActivity(new ActivityScenario.ActivityAction<TestAActivity>() {
                @Override
                public void perform(TestAActivity activity) {
                    idlingResource = activity.getIdlingResource();

                    IdlingRegistry.getInstance().register(idlingResource);
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void changeTestActivity(){
        onView(withId(R.id.editText)).perform(typeText(NAME),closeSoftKeyboard());
        onView(withId(R.id.btn_a)).perform(click());
        onView(withId(R.id.txt_a)).check(matches(withText(NAME)));
    }


//    @After
//    public void unRegisterIdlingResource(){
//
//        if (idlingResource != null){
//            IdlingRegistry.getInstance().unregister(idlingResource);
//        }
//    }

}
