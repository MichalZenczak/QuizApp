package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText userNameField = findViewById(R.id.user_name_edit_text);
                String userName = userNameField.getText().toString();

                // Check if user entered his name, if not show toast message.
                if (userName.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.no_input_name), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else {
                    // if user entered his name start MainActivity.
                    Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                    myIntent.putExtra("userName", userName);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }

    /**
     * When this activity is resumed this method clears the EditText
     */
    @Override
    protected void onResume() {
        super.onResume();
        EditText userNameField = findViewById(R.id.user_name_edit_text);
        userNameField.setText("");
    }
}
