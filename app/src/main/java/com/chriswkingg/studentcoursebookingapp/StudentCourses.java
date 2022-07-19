package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentCourses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_mycourses);
        Button unEnroll = (Button) findViewById(R.id.unEnroll);
        EditText courseCode = (EditText) findViewById(R.id.StudentUnEnrollCode);

    }
}