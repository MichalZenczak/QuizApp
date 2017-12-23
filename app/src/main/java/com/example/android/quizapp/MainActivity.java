package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int totalQuestions = 5;
    Button scoreButton, finishButton, viewAnswersButton ;
    RadioGroup questionOneAnswers, questionTwoAnswers, questionThreeAnswers, questionFourAnswers, questionFiveAnswers;
    RadioButton questionOneCorrectAnswer, questionTwoCorrectAnswer, questionThreeCorrectAnswer, questionFourCorrectAnswer, questionFiveCorrectAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreButton = findViewById(R.id.score_button);
        finishButton =  findViewById(R.id.finish_button);
        viewAnswersButton = findViewById(R.id.view_answers_button);

        questionOneAnswers = findViewById(R.id.radio_group_question_1);
        questionTwoAnswers = findViewById(R.id.radio_group_question_2);
        questionThreeAnswers = findViewById(R.id.radio_group_question_3);
        questionFourAnswers = findViewById(R.id.radio_group_question_4);
        questionFiveAnswers = findViewById(R.id.radio_group_question_5);

        questionOneCorrectAnswer = findViewById(R.id.question_1_answer_1_correct);
        questionTwoCorrectAnswer = findViewById(R.id.question_2_answer_4_correct);
        questionThreeCorrectAnswer = findViewById(R.id.question_3_answer_3_correct);
        questionFourCorrectAnswer = findViewById(R.id.question_4_answer_2_correct);
        questionFiveCorrectAnswer = findViewById(R.id.question_5_answer_4_correct);

        Intent userNameIntent = getIntent();
        final String userName = userNameIntent.getStringExtra("userName");

        scoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int[] results = checkAnswers();
                Toast toast = Toast.makeText(getApplicationContext(), createMessage(results, totalQuestions, userName), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });


        finishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();

            }
        });

        viewAnswersButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                highlightCorrectAnswers();

            }
        });

    }

    /**
     * This method checks if any answer in any question was selected and then checks
     * if the correct answer was selected. It also calculates the score of correct answers and
     * how many questions was not answered.
     *
     * @return an array of two values [correct answers, questions not selected by the user]
     */
    public int[] checkAnswers() {
        int correctAnswers = 0;
        int questionsNotChecked = 0;



        if (questionOneAnswers.getCheckedRadioButtonId() == -1) {
            questionsNotChecked += 1;
        } else {
            if ( questionOneCorrectAnswer.isChecked()) {
                correctAnswers += 1;
            }
        }

        if (questionTwoAnswers.getCheckedRadioButtonId() == -1) {
            questionsNotChecked += 1;
        } else {
            if (questionTwoCorrectAnswer.isChecked()) {
                correctAnswers += 1;
            }
        }

        if (questionThreeAnswers.getCheckedRadioButtonId() == -1) {
            questionsNotChecked += 1;
        } else {
            if (questionThreeCorrectAnswer.isChecked()) {
                correctAnswers += 1;
            }
        }

        if (questionFourAnswers.getCheckedRadioButtonId() == -1) {
            questionsNotChecked += 1;
        } else {
            if (questionFourCorrectAnswer.isChecked()) {
                correctAnswers += 1;
            }
        }

        if (questionFiveAnswers.getCheckedRadioButtonId() == -1) {
            questionsNotChecked += 1;
        } else {
            if (questionFiveCorrectAnswer.isChecked()) {
                correctAnswers += 1;
            }
        }
        return new int[]{correctAnswers, questionsNotChecked};
    }

    /**
     * This method creates the score message and checks if the user answered to all questions.
     *
     * @param results        an array of two values [correct answers, questions not selected by the user]
     * @param totalQuestions the total number of questions in the quiz
     * @param userName       the user's name
     * @return final score message
     */
    public String createMessage(int[] results, int totalQuestions, String userName) {
        String message = "";
        message += getString(R.string.userGreetings) + " " + userName + "!\n";
        if (results[1] > 0) {
            message += getString(R.string.question_not_answered) + " " + results[1] + " " + getString(R.string.score_message_3);
            return message;
        } else if (results[0] == totalQuestions) {
            message += getString(R.string.perfect_score);
            return message;
        } else {
            message += getString(R.string.score_message_1) + " " + results[0];
            message += " " + getString(R.string.score_message_2) + " " + totalQuestions;
            message += "\n" + getString(R.string.score_message_3);
            return message;
        }
    }

    /**
     * This method changes the text color of correct answers.
     */
    public void highlightCorrectAnswers() {
        questionOneCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));
        questionTwoCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));
        questionThreeCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));
        questionFourCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));
        questionFiveCorrectAnswer.setTextColor(getResources().getColor(R.color.correctAnswers));
    }

}