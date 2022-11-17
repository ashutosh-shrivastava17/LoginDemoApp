package com.example.logindemoapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.logindemoapp.util.TestConstant.VALID_EMAIL_ID;
import static com.example.logindemoapp.util.TestConstant.VALID_PASSWORD;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.logindemoapp.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void assert_login_successful_message_displayed_when_home_activity_is_launched() {
        onView(withId(R.id.et_email)).perform(typeText(VALID_EMAIL_ID));
        onView(withId(R.id.et_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());

        onView(withId(R.id.login_success_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.login_success_tv))
                .check(matches(withText(R.string.login_success_message)));
    }

    @Test
    public void assert_email_label_and_value_entered_by_user_displayed_when_home_activity_is_launched() {
        onView(withId(R.id.et_email)).perform(typeText(VALID_EMAIL_ID));
        onView(withId(R.id.et_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());

        // Verify email label.
        onView(withId(R.id.email_address_lbl)).check(matches(isDisplayed()));
        onView(withId(R.id.email_address_lbl))
                .check(matches(withText(R.string.email_label)));

        // Verify email value.
        onView(withId(R.id.email_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.email_tv))
                .check(matches(withText(VALID_EMAIL_ID)));
    }

    @Test
    public void assert_password_label_and_value_entered_by_user_displayed_when_home_activity_is_launched() {
        onView(withId(R.id.et_email)).perform(typeText(VALID_EMAIL_ID));
        onView(withId(R.id.et_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());

        // Verify email label.
        onView(withId(R.id.password_lbl)).check(matches(isDisplayed()));
        onView(withId(R.id.password_lbl))
                .check(matches(withText(R.string.password_label)));

        // Verify email value.
        onView(withId(R.id.pw_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.pw_tv))
                .check(matches(withText(VALID_PASSWORD)));
    }
}
