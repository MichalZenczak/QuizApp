package com.example.android.quizapp;

import android.content.Intent;
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

        Intent userNameIntent = getIntent();
        final String userName = userNameIntent.getExtras().getString("userName");

        Button scoreButton = findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int[] results = checkAnswers();
                Toast.makeText(getApplicationContext(), createMessage(results, totalQuestions, userName), Toast.LENGTH_SHORT).show();
            }
        });

        Button finishButton = findViewById(R.id.finish_button);
        finishButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button viewAnswersButton = findViewById(R.id.view_answers_button);
        viewAnswersButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                highlightCorrectAnswers();

            }
        });

    }


    /**
     * This method checks the correct answers and calculates the result.
     */
    public int[] checkAnswers() {
            int correctAnswers = 0;
            int questionsNotChecked = 0;

            RadioGroup questionOneAnswers = findViewById(R.id.radio_group_question_1);
            int isQuestionOneChecked = questionOneAnswers.getCheckedRadioButtonId();
            if (isQuestionOneChecked == -1){
                questionsNotChecked += 1;
            }else {
                RadioButton questionOneCorrectAnswer = findViewById(R.id.question_1_answer_1_correct);
                Boolean isQuestionOneCorrect = questionOneCorrectAnswer.isChecked();
                if (isQuestionOneCorrect){
                    correctAnswers += 1;
                }
            }

            RadioGroup questionTwoAnswers = findViewById(R.id.radio_group_question_2);
            int isQuestionTwoChecked = questionTwoAnswers.getCheckedRadioButtonId();
            if (isQuestionTwoChecked == -1){
                questionsNotChecked += 1;
            }else {
                RadioButton questionTwoCorrectAnswer = findViewById(R.id.question_2_answer_4_correct);
                Boolean isQuestionTwoCorrect = questionTwoCorrectAnswer.isChecked();
                if (isQuestionTwoCorrect){
                    correctAnswers += 1;
                }
            }

            RadioGroup questionThreeAnswers = findViewById(R.id.radio_group_question_3);
            int isQuestionThreeChecked = questionThreeAnswers.getCheckedRadioButtonId();
            if (isQuestionThreeChecked == -1){
                questionsNotChecked += 1;
            }else {
                RadioButton questionThreeCorrectAnswer = findViewById(R.id.question_3_answer_3_correct);
                Boolean isQuestionThreeCorrect = questionThreeCorrectAnswer.isChecked();
                if (isQuestionThreeCorrect){
                    correctAnswers += 1;
                }
            }

            RadioGroup questionFourAnswers = findViewById(R.id.radio_group_question_4);
            int isQuestionFourChecked = questionFourAnswers.getCheckedRadioButtonId();
            if (isQuestionFourChecked == -1){
                questionsNotChecked += 1;
            }else {
                RadioButton questionFourCorrectAnswer = findViewById(R.id.question_4_answer_2_correct);
                Boolean isQuestionFourCorrect = questionFourCorrectAnswer.isChecked();
                if (isQuestionFourCorrect){
                    correctAnswers += 1;
                }
            }

            RadioGroup questionFiveAnswers = findViewById(R.id.radio_group_question_5);
            int isQuestionFiveCheceked = questionFiveAnswers.getCheckedRadioButtonId();
            if (isQuestionFiveCheceked == -1 ){
                questionsNotChecked += 1;
            }else {
                RadioButton questionFiveCorrectAnswer = findViewById(R.id.question_5_answer_4_correct);
                Boolean isQuestionFiveCorrect = questionFiveCorrectAnswer.isChecked();
                if (isQuestionFiveCorrect){
                    correctAnswers += 1;
                }
            }

            return new int[] {correctAnswers, questionsNotChecked};
    }

    public String createMessage(int[] results, int totalQuestions, String userName){
        String message = "";
        message += getString(R.string.userGreetings) + " " + userName + "\n";
        if (results[1] > 0){
            message += getString(R.string.question_not_answered) + " " + results[1] + " " + getString(R.string.score_message_3);
            return message;
        }else if (results[0] == totalQuestions){
            message += getString(R.string.perfect_score);
            return message;
        }else {
            message += getString(R.string.score_message_1) + " " + results[0];
            message += " " + getString(R.string.score_message_2) + " " + totalQuestions;
            message += "\n" + getString(R.string.score_message_3);
            return message;
        }
    }

    public void highlightCorrectAnswers(){
        RadioButton questionOneCorrectAnswer = findViewById(R.id.question_1_answer_1_correct);
        questionOneCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));

        RadioButton questionTwoCorrectAnswer = findViewById(R.id.question_2_answer_4_correct);
        questionTwoCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));

        RadioButton questionThreeCorrectAnswer = findViewById(R.id.question_3_answer_3_correct);
        questionThreeCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));

        RadioButton questionFourCorrectAnswer = findViewById(R.id.question_4_answer_2_correct);
        questionFourCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));

        RadioButton questionFiveCorrectAnswer = findViewById(R.id.question_5_answer_4_correct);
        questionFiveCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));
    }


}