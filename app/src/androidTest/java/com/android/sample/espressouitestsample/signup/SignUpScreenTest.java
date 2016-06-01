package com.android.sample.espressouitestsample.signup;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.android.sample.espressouitestsample.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by mayowa.adegeye on 31/05/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SignUpScreenTest {
    @Rule
    public ActivityTestRule<SignUpActivity> mSignUpActivityTestRule =
            new ActivityTestRule<SignUpActivity>(SignUpActivity.class);

    @Test
    public void clickSignUpButtonAfterFillingForm_showProgressAndSuccessScreen() {
        String first_name = "Firstname";
        String last_name = "lastname";
        String emailAddress = "firstname.lastname@g.com";
        String password = "password";

        //find the firstname edit text and type in the first name
        onView(withId(R.id.edit_text_first_name)).perform(typeText(first_name), closeSoftKeyboard());

        //find the lastname edit text and type in the last name
        onView(withId(R.id.edit_text_last_name)).perform(typeText(last_name), closeSoftKeyboard());

        //find the email address edit text and type in the email address
        onView(withId(R.id.edit_text_email)).perform(typeText(emailAddress), closeSoftKeyboard());

        //find the password edit text and type in the password
        onView(withId(R.id.edit_text_password)).perform(typeText(password), closeSoftKeyboard());

        //click the signup button
        onView(withId(R.id.button_sign_up)).perform(click());

        //check that we can see the success screen with success message
        String successString = InstrumentationRegistry.getTargetContext().getString(R.string.text_sign_up_successful);
        onView(withId(R.id.text_view_status_message)).check(matches(allOf(withText(successString), isDisplayed())));
    }
}
