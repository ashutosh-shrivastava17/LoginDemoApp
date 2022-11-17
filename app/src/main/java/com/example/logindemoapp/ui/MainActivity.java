package com.example.logindemoapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logindemoapp.R;
import com.example.logindemoapp.util.Constant;
import com.example.logindemoapp.util.ValidatorUtil;
import com.google.android.material.snackbar.Snackbar;

/**
 * Launcher activity.
 */
public class MainActivity extends AppCompatActivity {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    /**
     * Text-watcher for email-address field.
     */
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String emailInput = mEmailEditText.getText().toString();
            if (!ValidatorUtil.isEmailValid(emailInput)) {
                mEmailEditText.setError(getString(R.string.enter_valid_email_message));
                disableLoginButton(true);
            } else {
                disableLoginButton(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * Initializes views and sets listeners.
     */
    private void init() {
        mEmailEditText = findViewById(R.id.et_email);
        mPasswordEditText = findViewById(R.id.et_password);
        mLoginButton = findViewById(R.id.login_btn);
        mLoginButton.setOnClickListener(this::handleLoginButtonClick);
        //Setting login button disables initially.
        disableLoginButton(true);
        // Setting listener only to email field and not to password field.
        // As for login purpose, providing hint related to password to user
        // can be a breach to security.
        mEmailEditText.addTextChangedListener(textWatcher);
    }

    /**
     * Handles login button click.
     *
     * @param view view instance.
     */
    private void handleLoginButtonClick(View view) {
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        if (ValidatorUtil.isPasswordEmpty(password)) {
            showSnackBar(view, getString(R.string.empty_password_message));
        } else if (!ValidatorUtil.isPasswordValid(password)) {
            showSnackBar(view, getString(R.string.invalid_password_message));
        } else {
            navigateToNextPage(email, password);
        }
    }

    /**
     * Navigates to second activity.
     *
     * @param email    email address entered by user.
     * @param password password entered by user.
     */
    private void navigateToNextPage(String email, String password) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(Constant.EMAIL_KEY, email);
        intent.putExtra(Constant.PASSWORD_KEY, password);
        startActivity(intent);
    }

    /**
     * Shows snack bar with given message.
     *
     * @param message message to be displayed on snack-bar.
     */
    private void showSnackBar(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    /**
     * Enable/disable the login button and set colors accordingly.
     *
     * @param shouldDisableButton flag to check if button is to be disabled.
     */
    private void disableLoginButton(boolean shouldDisableButton) {
        if (shouldDisableButton) {
            mLoginButton.setEnabled(false);
            mLoginButton.setAlpha(.5f);
            mLoginButton.setTextColor(getColor(R.color.text_color_grey));
        } else {
            mLoginButton.setEnabled(true);
            mLoginButton.setAlpha(1f);
            mLoginButton.setTextColor(getColor(R.color.white));
        }
    }
}