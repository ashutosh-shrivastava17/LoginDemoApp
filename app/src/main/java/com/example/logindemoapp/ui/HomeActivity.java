package com.example.logindemoapp.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.logindemoapp.R;
import com.example.logindemoapp.util.Constant;

/**
 * Home page.
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        init();
    }

    /**
     * Initializes views, fetched intent extras and updates view.
     */
    private void init() {
        TextView emailTextView = findViewById(R.id.email_tv);
        TextView passwordTextView = findViewById(R.id.pw_tv);

        // Fetch values from intent and update views.
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            emailTextView.setText(extras.getString(Constant.EMAIL_KEY));
            passwordTextView.setText(extras.getString(Constant.PASSWORD_KEY));
        }
    }
}
