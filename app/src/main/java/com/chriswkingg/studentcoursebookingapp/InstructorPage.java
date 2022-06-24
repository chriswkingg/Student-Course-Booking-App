package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InstructorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_page);
        Button instructorCourse = (Button) findViewById(R.id.viewCourse);

        TextView welcomeMessage = (TextView) findViewById(R.id.instructorWelcomeMessage);
        welcomeMessage.setText("Welcome " + getIntent().getStringExtra("username") + ", your are logged in as an instructor");

        instructorCourse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(InstructorPage.this, "Account created, please sign in" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(InstructorPage.this, InstructorViewCourse.class));
            }
        });
    }
}
