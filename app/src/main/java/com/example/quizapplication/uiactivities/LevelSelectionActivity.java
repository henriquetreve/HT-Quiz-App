package com.example.quizapplication.uiactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.quizapplication.R;
import com.example.quizapplication.levels.EasyModeActivity;
import com.example.quizapplication.levels.MediumModeActivity;
import com.example.quizapplication.levels.HardModeActivity;


public class LevelSelectionActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEasy, btnMediaum, btnDifficult, btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnEasy = findViewById(R.id.btn_easy);
        btnMediaum = findViewById(R.id.btn_medium);
        btnDifficult = findViewById(R.id.btn_difficult);

        btnMenu = findViewById(R.id.btn_menu);

        btnEasy.setOnClickListener(this);
        btnMediaum.setOnClickListener(this);
        btnDifficult.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;

        if (clickedButton.getId() == R.id.btn_easy) {
            Intent intent = new Intent(this, EasyModeActivity.class);
            startActivity(intent);
        } else if (clickedButton.getId() == R.id.btn_medium) {
            Intent intent = new Intent(this, MediumModeActivity.class);
            startActivity(intent);
        } else if (clickedButton.getId() == R.id.btn_difficult) {
            Intent intent = new Intent(this, HardModeActivity.class);
            startActivity(intent);
        } else if (clickedButton.getId() == R.id.btn_menu) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
    }
}
