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
import com.example.quizapplication.model.QuestionEasyMode;
import com.example.quizapplication.uiactivities.ScoreActivity;

public class EasyModeActivity extends AppCompatActivity implements OnClickListener {
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = QuestionEasyMode.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_mode);

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
            if (selectedAnswer.equals(QuestionEasyMode.correctAnswers[currentQuestionIndex])) {
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

        // Set the question and answers for the current question
        questionTextView.setText(QuestionEasyMode.question[currentQuestionIndex]);
        ansA.setText(QuestionEasyMode.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionEasyMode.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionEasyMode.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionEasyMode.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        String passStatus = score > totalQuestion * 0.60 ? "Passed" : "Failed";

        // Create an Intent to start ScoreActivity
        Intent scoreIntent = new Intent(EasyModeActivity.this, ScoreActivity.class);

        // Use putExtra to pass the score and total questions to ScoreActivity
        scoreIntent.putExtra("score", score); // Assuming 'score' is an integer variable holding the user's score
        scoreIntent.putExtra("totalQuestions", totalQuestion); // Assuming 'totalQuestion' is an integer variable holding the total number of questions
        scoreIntent.putExtra("passStatus", passStatus); // Pass the pass/fail status as well

        // Add the game mode information
        scoreIntent.putExtra("gameMode", "Easy");

        // Start ScoreActivity
        startActivity(scoreIntent);

        // Finish EasyModeActivity so the user can't go back to it with the back button
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
