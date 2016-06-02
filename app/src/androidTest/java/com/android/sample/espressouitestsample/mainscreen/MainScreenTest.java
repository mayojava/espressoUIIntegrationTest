package com.android.sample.espressouitestsample.mainscreen;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.android.sample.espressouitestsample.R;
import com.android.sample.espressouitestsample.signup.SignUpActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Test for the MainActivity screen
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainScreenTest {
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule = new
            ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void clickSignUpButton_opensSignUpScreen() {
        //click on the sign up button
        onView(withId(R.id.button_sign_up)).perform(click());

        //check if the sign up screen is displayed by asserting that the first name edittext is displayed
        onView(withId(R.id.edit_text_first_name)).check(matches(allOf(isDescendantOfA(withId(R.id.layout_sign_up)), isDisplayed())));
    }

    @Test
    public void clickLoginButton_openLoginScreen() {
        //click on the login button
        onView(withId(R.id.button_login)).perform(click());

        //check that the login screen is displayed
        onView(withId(R.id.edit_text_email)).check(matches(allOf(isDescendantOfA(withId(R.id.layout_login)), isDisplayed())));
    }
}
