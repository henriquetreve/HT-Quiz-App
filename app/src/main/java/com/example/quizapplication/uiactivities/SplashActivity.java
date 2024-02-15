package com.example.quizapplication.uiactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.quizapplication.R;
import com.example.quizapplication.authentication.LoginScreen;
import com.example.quizapplication.authentication.SessionManagaer;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SessionManagaer sessionManagaer = new SessionManagaer(getApplicationContext());


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                Boolean b = sessionManagaer.checkSession();

                if (b == true) {

                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(i);
                    finish();

                }
                else {
                    Intent i = new Intent(getApplicationContext(), LoginScreen.class);
                    startActivity(i);
                    finish();
                }

            }
        }, 3000);
    }

}