package com.example.quizapplication.authentication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.R;
import com.example.quizapplication.uiactivities.ProfileActivity;


public class LoginScreen extends AppCompatActivity {

    Button btnLogin;
    EditText edtEmail,edtPassword;
    TextView tvRegister;
    SessionManagaer sessionManagaer;
    SharedPreferences prefs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        sessionManagaer=new SessionManagaer(this);
        btnLogin=findViewById(R.id.btn_login);
        edtEmail=findViewById(R.id.edt_email);
        edtPassword=findViewById(R.id.edt_password);
        tvRegister=findViewById(R.id.tv_RegistrationLink);

        prefs=getSharedPreferences("userEmail",MODE_PRIVATE);
        prefs=getApplicationContext().getSharedPreferences("Welcome!",0);



        btnLogin.setOnClickListener(view -> {

            String email=edtEmail.getText().toString();
            String pass=edtPassword.getText().toString();
            if(email.equals(sessionManagaer.getSessionDetails("Key_session_email")) && pass.equals(sessionManagaer.getSessionDetails("key_session_password"))){
                Intent intent;
                intent=new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);

            }
            else
            {
                Toast.makeText(getApplicationContext(),"Email or Password didn't match", Toast.LENGTH_SHORT).show();
            }

        });

        tvRegister.setOnClickListener(view -> {
            Intent i;
            i=new Intent(getApplicationContext(), RegistrationActivity.class);
            i.putExtra("msg","User is not register yet");
            startActivity(i);
            finish();

        });

    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("QUIT App")
                .setMessage("Close APPLICATION?")
                        .setNegativeButton("No", (dialogInterface, i) -> {

                        })
                                .setPositiveButton("Yes", (dialogInterface, i) -> finish()).create();
        builder.show();

    }
}