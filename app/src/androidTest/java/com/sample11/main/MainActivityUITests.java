package com.sample11.main;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.sample11.main.ui.MainActivity;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.internal.util.Checks.checkNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.EasyMock2Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;

/**
 * Created by Ashmath Khan on 17-10-2018.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITests {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private IdlingResource eventIdlingResource;

    @Before
    public void setUp() throws Exception {
        MainActivity activity = activityRule.getActivity();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void screen1HasExpectedElement() {
        onView(withId(R.id.userInfoTitleTV)).check(matches(isDisplayed()));
        onView(withId(R.id.userInfoTitleTV)).check(matches(withText((R.string.userInfo))));
    }

}
