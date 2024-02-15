package com.example.quizapplication.authentication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.quizapplication.R;
import com.example.quizapplication.uiactivities.ProfileActivity;


public class RegistrationActivity extends AppCompatActivity {

    Button btnRegister;
    TextView tvalreadyRegister;
    EditText edtName,edtEmail,etdGender,edtPhon,edtPassword;
    SessionManagaer sessionManagaer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);
        sessionManagaer=new SessionManagaer(this);

        btnRegister=findViewById(R.id.btn_Register);
        edtName=findViewById(R.id.edt_UserName);
        edtEmail=findViewById(R.id.edt_UserEmail);
        etdGender=findViewById(R.id.edt_UserGender);
        edtPhon=findViewById(R.id.edt_UserPhone);
        edtPassword=findViewById(R.id.edt_UserPassword);

        tvalreadyRegister=findViewById(R.id.tv_AlreadyRegister);

//        Bundle extra=getIntent().getExtras();
//
//        if(extra!=null){
//            String Message= extra.getString("msg");
//            Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_SHORT).show();
//        }


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=edtName.getText().toString();
                String email =edtEmail.getText().toString();
                String gender=etdGender.getText().toString();
                String phone=edtPhon.getText().toString();
                String pass=edtPassword.getText().toString();

                sessionManagaer.createSession(name,email,gender,phone,pass);
                Intent intent;
                intent=new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);



            }
        });

        tvalreadyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i=new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(i);
                finish();

            }
        });

    }



    @Override
    public void onBackPressed() {

      new AlertDialog.Builder( this)
              .setTitle("Exit Application")
                      .setMessage("Do you want to close this application ?")
                              .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialogInterface, int i) {
                                      finish();

                                  }
                              })
                                      .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                          @Override
                                          public void onClick(DialogInterface dialogInterface, int i) {

                                          }
                                      }).show();

    }
}