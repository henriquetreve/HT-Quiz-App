package com.example.quizapplication.levels;

import static android.view.View.*;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.R;
import com.example.quizapplication.model.QuestionHardMode;
import com.example.quizapplication.uiactivities.ScoreActivity;

public class HardModeActivity extends AppCompatActivity implements OnClickListener {
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = QuestionHardMode.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_mode);

        // Initialize components
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        // Set click listeners for buttons
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        // Set touch listeners for answer buttons
        setupButtonListeners();

        // Display total questions
        totalQuestionsTextView.setText("Total questions : " + totalQuestion);

        // Load the first question
        loadNewQuestion();
    }

    private void setupButtonListeners() {
        OnTouchListener touchListener = new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        view.setBackgroundColor(Color.BLUE);
                        break;
                    case MotionEvent.ACTION_UP:
                        view.setBackgroundColor(Color.WHITE);
                        break;
                }
                return false;
            }
        };

        // Apply the touch listener to all answer buttons
        ansA.setOnTouchListener(touchListener);
        ansB.setOnTouchListener(touchListener);
        ansC.setOnTouchListener(touchListener);
        ansD.setOnTouchListener(touchListener);
    }

    @Override
    public void onClick(View view) {
        // Reset all button backgrounds before setting the selected one
        resetButtonBackgrounds();

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(QuestionHardMode.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        } else {
            // Answer button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLUE);
        }
    }

    void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        // Reset button backgrounds when loading a new question
        resetButtonBackgrounds();

        // Set the question and answers
        questionTextView.setText(QuestionHardMode.question[currentQuestionIndex]);
        ansA.setText(QuestionHardMode.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionHardMode.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionHardMode.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionHardMode.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        String passStatus = score > totalQuestion * 0.60 ? "Passed" : "Failed";

        // Create an Intent to start ScoreActivity
        Intent scoreIntent = new Intent(HardModeActivity.this, ScoreActivity.class);
        scoreIntent.putExtra("score", score);
        scoreIntent.putExtra("totalQuestions", totalQuestion);
        scoreIntent.putExtra("passStatus", passStatus);

        // Add the game mode information
        scoreIntent.putExtra("gameMode", "Hard");

        // Start ScoreActivity
        startActivity(scoreIntent);

        // Finish MediumModeActivity so the user can't go back to it with the back button
        finish();
    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void resetButtonBackgrounds() {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
    }
}
