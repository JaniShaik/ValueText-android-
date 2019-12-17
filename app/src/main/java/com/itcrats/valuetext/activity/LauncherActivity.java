package com.itcrats.valuetext.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.itcrats.valuetext.R;
import com.itcrats.valuetext.utils.Constants;

public class LauncherActivity extends AppCompatActivity {

    // Context
    private Context mContext = this;
    // ImageView
    private ImageView logoIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher);
        // Hiding Action Bar
        getSupportActionBar().hide();
        // ImageView
        logoIMG = findViewById(R.id.logoIMG);
        // Set Image
        Glide.with(this).load(Constants.LOGO_URL).into(logoIMG);
        // Navigate to Login
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
