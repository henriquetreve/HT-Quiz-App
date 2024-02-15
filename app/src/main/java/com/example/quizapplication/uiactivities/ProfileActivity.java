package com.example.quizapplication.uiactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizapplication.R;
import com.example.quizapplication.authentication.SessionManagaer;

public class ProfileActivity extends AppCompatActivity  {

    Button btnStartQuiz, btnSettings,btnLogout;
    TextView tvUserName;
    SessionManagaer sessionManagaer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

      btnStartQuiz=findViewById(R.id.btn_Start_Quiz);
       btnSettings=findViewById(R.id.btn_settings);
       tvUserName=findViewById(R.id.tv_userName);
       btnLogout=findViewById(R.id.btn_logout);
       sessionManagaer=new SessionManagaer(this);
      String profileName=sessionManagaer.getSessionDetails("key_session_name");
      tvUserName.setText("Welcome "+ profileName);

        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent;
               intent=new Intent(ProfileActivity.this, LevelSelectionActivity.class);
               startActivity(intent);



           }
       });
        btnSettings.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getApplicationContext(),"Show Setting Screen ",Toast.LENGTH_LONG).show();
           }
       });
       btnLogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sessionManagaer.sessionLogout();
           }
       });




    }



}