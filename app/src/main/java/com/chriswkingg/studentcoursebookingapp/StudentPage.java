package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_page);

        TextView welcomeMessage = (TextView) findViewById(R.id.studentWelcomeText);
        welcomeMessage.setText("Hello " + getIntent().getStringExtra("username") + " logged in as student");
    }
}
