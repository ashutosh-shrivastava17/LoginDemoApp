package com.example.logindemoapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.logindemoapp.util.TestConstant.INVALID_EMAIL_ID;
import static com.example.logindemoapp.util.TestConstant.INVALID_PASSWORD;
import static com.example.logindemoapp.util.TestConstant.SIGN_IN;
import static com.example.logindemoapp.util.TestConstant.VALID_EMAIL_ID;
import static com.example.logindemoapp.util.TestConstant.VALID_PASSWORD;
import static org.hamcrest.Matchers.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.logindemoapp.ui.MainActivity;
import com.example.logindemoapp.util.TestConstant;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void assert_SignIn_text_displayed_on_launcher_screen() {
        onView(withId(R.id.login_label)).check(matches(isDisplayed()));
        onView(withId(R.id.login_label)).check(matches(withText(SIGN_IN)));
    }

    @Test
    public void assert_Email_Address_label_and_editable_field_displayed_on_launcher_screen() {
        onView(withId(R.id.email_label)).check(matches(isDisplayed()));
        onView(withId(R.id.et_email)).check(matches(isDisplayed()));
        onView(withId(R.id.email_label)).check(matches(withText(R.string.email_label)));
    }

    @Test
    public void assert_Password_label_and_editable_field_displayed_on_launcher_screen() {
        onView(withId(R.id.password_label)).check(matches(isDisplayed()));
        onView(withId(R.id.et_password)).check(matches(isDisplayed()));
        onView(withId(R.id.password_label)).check(matches(withText(R.string.password_label)));
    }

    @Test
    public void assert_login_button_displayed_as_disabled_on_launcher_screen() {
        onView(withId(R.id.login_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.login_btn)).check(matches(withText(R.string.login)));
        onView(withId(R.id.login_btn)).check(matches(not(isEnabled())));
    }

    @Test
    public void assert_text_changes_on_email_field_is_visible() {
        onView(withId(R.id.et_email))
                .perform(typeText(VALID_EMAIL_ID), closeSoftKeyboard());

        // Check that the email was changed.
        onView(withId(R.id.et_email)).check(matches(withText(VALID_EMAIL_ID)));
    }

    @Test
    public void assert_text_changes_on_password_field_is_visible() {
        onView(withId(R.id.et_password))
                .perform(typeText(VALID_PASSWORD), closeSoftKeyboard());

        // Check that the password was changed.
        onView(withId(R.id.et_password)).check(matches(withText(VALID_PASSWORD)));
    }

    @Test
    public void assert_login_button_enabled_when_valid_email_is_entered() {
        onView(withId(R.id.et_email))
                .perform(typeText(VALID_EMAIL_ID), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).check(matches(isEnabled()));
    }

    @Test
    public void assert_login_button_disabled_when_invalid_email_is_entered() {
        onView(withId(R.id.et_email))
                .perform(typeText(INVALID_EMAIL_ID), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).check(matches(not(isEnabled())));
    }

    @Test
    public void assert_error_message_displayed_when_invalid_email_entered() {
        onView(withId(R.id.et_email)).perform(typeText(INVALID_EMAIL_ID));
        onView(withId(R.id.et_email)).check(matches(hasErrorText(TestConstant.ENTER_VALID_EMAIL_MESSAGE)));
    }

    @Test
    public void assert_show_snack_bar_invalid_password_message_when_login_button_pressed_with_non_empty_password_field() {
        onView(withId(R.id.et_email))
                .perform(typeText(VALID_EMAIL_ID), closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText(INVALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());
        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText(R.string.invalid_password_message)));
    }

    @Test
    public void assert_show_snack_bar_enter_password_message_when_login_button_pressed_with_empty_password_field() {
        onView(withId(R.id.et_email))
                .perform(typeText(VALID_EMAIL_ID), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());
        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText(R.string.empty_password_message)));
    }

    @Test
    public void assert_login_successful_message_displayed_when_valid_email_password_entered() {
        onView(withId(R.id.et_email)).perform(typeText(VALID_EMAIL_ID));
        onView(withId(R.id.et_password)).perform(typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());

        onView(withId(R.id.login_success_tv))
                .check(matches(withText(R.string.login_success_message)));
    }
}
