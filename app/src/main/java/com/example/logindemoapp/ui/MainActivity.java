package com.example.logindemoapp.ui;

import android.content.Intent;
import android.os.Bundle;
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
        Button loginButton = findViewById(R.id.login_btn);
        loginButton.setOnClickListener(this::handleLoginButtonClick);
    }

    /**
     * Handles login button click.
     *
     * @param view view instance.
     */
    private void handleLoginButtonClick(View view) {
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        // TODO We can add text-watcher for email field if we need to observe user input character
        //  wise and show/hide errors accordingly.
        if (ValidatorUtil.isEmailPasswordEmpty(email, password)) {
            showSnackBar(view, getString(R.string.empty_credentials_message));
        } else if (!ValidatorUtil.isEmailValid(email)) {
            showSnackBar(view, getString(R.string.invalid_email_password_message));
        } else if (!ValidatorUtil.isPasswordValid(password)) {
            showSnackBar(view, getString(R.string.invalid_email_password_message));
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
}