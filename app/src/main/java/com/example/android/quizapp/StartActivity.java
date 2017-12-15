package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button next = (Button) findViewById(R.id.start_button);
        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);


            }
        });
    }
}
