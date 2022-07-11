package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.style.TtsSpan;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Database db = new Database(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_assigned_courses);
        final EditText courseCode = (EditText) findViewById(R.id.searchCourse);
        final EditText editTiming = (EditText) findViewById(R.id.editTiming);
        final EditText editCap = (EditText) findViewById(R.id.editCap);
        assignedCourses = this.findViewById(R.id.showAssignedCourses);
        Button changeTiming = (Button) findViewById(R.id.changeTiming);
        Button changeCapacity = (Button) findViewById(R.id.changeCap);
        Toast.makeText(InstructorAssignedCourses.this, "Hey " + getIntent().getStringExtra("username") + ", here are your courses", Toast.LENGTH_SHORT).show();
        courses = db.getCourses();
        final ArrayList<String> courseList = new ArrayList<String>();
        final ArrayList<String> courseCodeToCheck = new ArrayList<String>();
        for (Course i : courses) {
            if (getIntent().getStringExtra("username").equals(i.getInstructor())) {
                courseList.add(i.toString());
                courseCodeToCheck.add(i.getCode());
            }
        }

        changeTiming.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i = 0; i < courseList.size(); i++) {
                    if (courseCodeToCheck.get(i).equals(courseCode.getText().toString())){
                        Toast.makeText(InstructorAssignedCourses.this,  ", Timing called", Toast.LENGTH_SHORT).show();
                        courses.get(i).setTiming(editTiming.getText().toString());
                        db.deleteCourse(courses.get(i));
                        db.addCourse(courses.get(i));
                        courseList.remove(i);
                        courseList.add(courses.get(i).toString());
                        updateCourses();
                    }
                }
            }
        });

        changeCapacity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i = 0; i < courseList.size(); i++) {
                    if (courseCodeToCheck.get(i).equals(courseCode.getText().toString())){
                        Toast.makeText(InstructorAssignedCourses.this,  ", Cap Called", Toast.LENGTH_SHORT).show();
                        courses.get(i).setCapacity(editCap.getText().toString());
                        db.deleteCourse(courses.get(i));
                        db.addCourse(courses.get(i));
                        courseList.remove(i);
                        courseList.add(courses.get(i).toString());
                        updateCourses();
                    }
                }
            }
        });
        assignedCourses.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));
    }
    private void updateCourses() {
        courses.clear();
        final Database db = new Database(this);
        courses = db.getCourses();
        ArrayList<String> courseList = new ArrayList<String>();
        for (Course i : courses) {
            courseList.add(i.toString());
        }
        assignedCourses.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));

    }
}