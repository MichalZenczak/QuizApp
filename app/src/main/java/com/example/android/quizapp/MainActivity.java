package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int totalQuestions = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitAnswerButton = findViewById(R.id.submit_answer);
        submitAnswerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                int correctAnswers = checkAnswers();

                Toast.makeText(getApplicationContext(), createMessage(correctAnswers, totalQuestions), Toast.LENGTH_SHORT).show();

            }
        });


    }


    /**
     * This method checks the correct answers and calculates the score.
     */
    public int checkAnswers() {

            int result = 0;
            RadioButton firstQuestion = findViewById(R.id.question_1_answer_1_correct);
            Boolean isFirstQuestionCorrect = firstQuestion.isChecked();
            if (isFirstQuestionCorrect){
                result += 1;
            }

            RadioButton secondQuestion = findViewById(R.id.question_2_answer_4_correct);
            Boolean isSecondQuestionCorrect = secondQuestion.isChecked();
            if (isSecondQuestionCorrect){
                result += 1;
            }

            RadioButton thirdQuestion = findViewById(R.id.question_3_answer_3_correct);
            Boolean isThirdQuestionCorrect = thirdQuestion.isChecked();
            if (isThirdQuestionCorrect){
                result += 1;
            }

            RadioButton fourthQuestion = findViewById(R.id.question_4_answer_2_correct);
            Boolean isFourthQuestionCorrect = fourthQuestion.isChecked();
            if (isFourthQuestionCorrect){
                result += 1;
            }

            RadioButton fifthQuestion = findViewById(R.id.question_5_answer_4_correct);
            Boolean isFifthQuestionCorrect = fifthQuestion.isChecked();
            if (isFifthQuestionCorrect){
                result += 1;
            }

            return result;
    }

    public String createMessage(int correctAnswers, int totalQuestions){
        String message = getString(R.string.score_message_1) + correctAnswers;
        message += getString(R.string.score_message_2) + totalQuestions;
        message += getString(R.string.score_message_3);
        return message;
    }




}
