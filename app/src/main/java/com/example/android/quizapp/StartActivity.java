package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button next = (Button) findViewById(R.id.start_button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText userNameField = findViewById(R.id.user_name_edit_text);
                String userName = userNameField.getText().toString();

                if(userName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.no_input_name), Toast.LENGTH_SHORT).show();
                }else {
                    Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                    myIntent.putExtra("userName",userName);
                    startActivityForResult(myIntent, 0);
                }



            }
        });
    }
}
