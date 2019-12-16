package com.itcrats.valuetext.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.itcrats.valuetext.R;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {

    // Context
    private Context mContext = this;
    // EditText
    private EditText usernameET, passwordET;
    // Button
    private Button loginBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        // Hiding Action Bar
        getSupportActionBar().hide();
        // Initialization
        initialization();
        // LogIn click
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    // Initialization
    private void initialization() {
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        loginBTN = findViewById(R.id.loginBTN);
    }

    // Validation
    private void validate() {
        if (usernameET.getText().toString().isEmpty()) {
            Toasty.error(mContext, mContext.getString(R.string.validate_username)).show();
        } else if (passwordET.getText().toString().isEmpty()) {
            Toasty.error(mContext, mContext.getString(R.string.validate_password)).show();
        } else {
            navigateToDashboard();
        }
    }

    // Navigate to Dashboard
    private void navigateToDashboard() {
        Intent intent = new Intent(mContext, PhoneActivity.class);
        startActivity(intent);
    }

}
