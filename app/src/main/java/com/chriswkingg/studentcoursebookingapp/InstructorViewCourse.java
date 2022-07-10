package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InstructorViewCourse extends AppCompatActivity {
    ListView courseListView;
    Database db;
    ArrayList<Course> courses;
    int idx =-1;
    boolean available = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_courses);
        courseListView = this.findViewById(R.id.listCourses);
        db = new Database(InstructorViewCourse.this);
        courses = db.getCourses();
        updateCourses();

        final EditText courseCodeText = (EditText) findViewById(R.id.courseInstCode);
        final EditText courseNameText = (EditText) findViewById(R.id.courseInstName);
        final Button searchButton = (Button) findViewById(R.id.courseInstSearch);
        final Button assignButton = (Button) findViewById(R.id.courseInstAssign);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                idx = -1;
                for(int i = 0; i < courses.size(); i++) {
                    if(courses.get(i).getCode().equals(courseCodeText.getText().toString())) {
                        idx = i;
                        if ("No Instructor".equals(courses.get(i).getInstructor())){
                            courses.get(i).setInstructor(getIntent().getStringExtra("username"));
                            db.deleteCourse(courses.get(i));
                            db.addCourse(courses.get(i));
                        }
                    }
                }
                if(idx == -1) {
                    Toast.makeText(InstructorViewCourse.this, "Couldn't find course" , Toast.LENGTH_SHORT).show();
                } else {
                    if ("".equals(courses.get(idx).getInstructor())){
                        Toast.makeText(InstructorViewCourse.this, "Course is available to be assigned! Click on Assign Self to teach the course" , Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(InstructorViewCourse.this, "Course already has an Instructor Assigned!" , Toast.LENGTH_SHORT).show();
                    }
                }
                updateCourses();
            }
        });

        assignButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).getCode().equals(courseCodeText.getText().toString())) {
                        if ("".equals(courses.get(i).getInstructor())) {
                            courses.get(i).setInstructor(getIntent().getStringExtra("username"));
                            db.deleteCourse(courses.get(i));
                            db.addCourse(courses.get(i));
                        }
                    }
                }
                updateCourses();
            }
        });



    }
    private void updateCourses() {
        courses.clear();
        courses = db.getCourses();
        ArrayList<String> courseList = new ArrayList<String>();
        for (Course i : courses) {
            courseList.add(i.toString());
        }
        courseListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));

    }
}
