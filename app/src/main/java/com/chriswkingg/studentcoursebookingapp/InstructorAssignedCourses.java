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
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        db = new Database(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_assigned_courses);

        final EditText courseCode = (EditText) findViewById(R.id.searchCourse);
        final EditText editTiming = (EditText) findViewById(R.id.editTiming);
        final EditText editCap = (EditText) findViewById(R.id.editCap);
        assignedCourses = this.findViewById(R.id.showAssignedCourses);
        Button changeCapacity = (Button) findViewById(R.id.changeCap);
        Toast.makeText(InstructorAssignedCourses.this, "Hey " + getIntent().getStringExtra("username") + ", here are your courses", Toast.LENGTH_SHORT).show();
        courses = db.getCourses();

        final ArrayList<String> courseList = new ArrayList<String>();
        for (Course i : courses) {
            if (getIntent().getStringExtra("username").equals(i.getInstructor())) {
                courseList.add(i.toString());
            }
        }

        changeCapacity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(Course i: courses) {
                    if (i.getCode().equals(courseCode.getText().toString())){
                        if(!editTiming.getText().toString().equals(""))
                            i.setTiming(editTiming.getText().toString());
                        if(!editCap.getText().toString().equals(""))
                            i.setCapacity(editCap.getText().toString());
                        db.deleteCourse(i);
                        db.addCourse(i);
                        Toast.makeText(InstructorAssignedCourses.this,  "Changes Saved Successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(InstructorAssignedCourses.this, InstructorPage.class));
                    }
                }
            }
        });
        assignedCourses.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));
    }
}