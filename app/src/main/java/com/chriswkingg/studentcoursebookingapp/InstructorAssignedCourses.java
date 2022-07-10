package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InstructorAssignedCourses extends AppCompatActivity {
    ListView assignedCourses;
    ArrayList<Course> courses;

    Database db;
    int idx = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_assigned_courses);
        EditText courseCode = (EditText) findViewById(R.id.searchCourse);
        EditText editTiming = (EditText) findViewById(R.id.editTiming);
        EditText editCap = (EditText) findViewById(R.id.editCap);
        assignedCourses = this.findViewById(R.id.showAssignedCourses);
        Button changeTiming = (Button) findViewById(R.id.changeTiming);
        Button changeCapacity = (Button) findViewById(R.id.changeCap);
        Toast.makeText(InstructorAssignedCourses.this, "Hey " + getIntent().getStringExtra("username") + ", here are your courses", Toast.LENGTH_SHORT).show();

        courses = db.getCourses();
        ArrayList<String> courseList = new ArrayList<String>();

        for (Course i : courses) {
            if (getIntent().getStringExtra("username").equals(i.getInstructor())) {
                courseList.add(i.toString());
            }
        }
        assignedCourses.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));
    }

    private void updateCourses() {
        courses.clear();
        courses = db.getCourses();
        ArrayList<String> courseList = new ArrayList<String>();
        for (Course i : courses) {
            courseList.add(i.toString());
        }
        assignedCourses.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));

    }
}