package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        final RadioButton student = (RadioButton) findViewById(R.id.studentButton);
        final RadioButton instructor = (RadioButton) findViewById(R.id.instructorButton);

        student.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                instructor.setChecked(false);
            }
        });

        instructor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                student.setChecked(false);
            }
        });
    }
}
