package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AdminAddCourse extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_course);

        final EditText courseCode = (EditText) findViewById(R.id.courseCode);
        final EditText courseDesc = (EditText) findViewById(R.id.courseD);

        String crsCode = courseCode.getText().toString();
        String crsDesc = courseDesc.getText().toString();

        Database database = new Database(AdminAddCourse.this);
        //Course course = database.addCourse(crsCode);


    }
}
