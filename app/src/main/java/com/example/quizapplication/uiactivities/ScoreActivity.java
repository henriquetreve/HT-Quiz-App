package com.example.quizapplication.uiactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

import com.example.quizapplication.R;
import com.example.quizapplication.levels.EasyModeActivity;
import com.example.quizapplication.levels.MediumModeActivity;
import com.example.quizapplication.levels.HardModeActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);

        // Retrieve the score, total questions, and the game mode from the intent
        int score = getIntent().getIntExtra("score", 0);
        int totalQuestions = getIntent().getIntExtra("totalQuestions", 0);
        String gameMode = getIntent().getStringExtra("gameMode");

        // Find the TextView and buttons in your layout
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        Button restartButton = findViewById(R.id.restartButton);
        Button menuButton = findViewById(R.id.menuButton);

        // Set the score text
        scoreTextView.setText(String.format("Your Score: %d/%d", score, totalQuestions));

        // Set the on click listener for the Restart button
        restartButton.setOnClickListener(v -> {
            Intent restartIntent;
            switch (gameMode) {
                case "Medium":
                    restartIntent = new Intent(ScoreActivity.this, MediumModeActivity.class);
                    break;
                case "Hard":
                    restartIntent = new Intent(ScoreActivity.this, HardModeActivity.class);
                    break;
                default:
                    restartIntent = new Intent(ScoreActivity.this, EasyModeActivity.class);
                    break;
            }
            startActivity(restartIntent);
            finish();
        });

        // Set the on click listener for the Return to Menu button
        menuButton.setOnClickListener(v -> {
            Intent mainMenuIntent = new Intent(ScoreActivity.this, LevelSelectionActivity.class);
            startActivity(mainMenuIntent);
            finish();
        });
    }
}
