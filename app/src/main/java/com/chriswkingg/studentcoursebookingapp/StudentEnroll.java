package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentEnroll extends AppCompatActivity {
    ListView studentCourseList;
    Database db;
    ArrayList<Course> listOfCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_enroll);
        Button studentEnroll = (Button) findViewById(R.id.studentEnrollCourse);
        EditText courseCode = (EditText) findViewById(R.id.studentCourseCode);
        studentCourseList = this.findViewById(R.id.studentCourseListView);
        db = new Database(StudentEnroll.this);
        listOfCourses = db.getCourses();
        updateCourses();

        studentEnroll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(StudentEnroll.this,  "You have Successfully Enrolled in the course!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StudentEnroll.this, StudentPage.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
            }
        });

    }
    private void updateCourses() {
        listOfCourses.clear();
        listOfCourses = db.getCourses();
        ArrayList<String> courseList = new ArrayList<String>();
        for (Course i : listOfCourses) {
            courseList.add(i.toString());
        }
        studentCourseList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));

    }
}