package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstructorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_page);

        TextView welcomeMessage = (TextView) findViewById(R.id.instructorWelcomeMessage);
        welcomeMessage.setText("Hello " + getIntent().getStringExtra("username") + " logged in as instructor");
    }
}
