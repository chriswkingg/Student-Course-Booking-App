package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdminEditCourse extends AppCompatActivity {


    ListView userListView;
    ArrayList<Course> courses;
    Database db;
    int idx = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_course);

        userListView = this.findViewById(R.id.editCourseListView);
        db = new Database(AdminEditCourse.this);
        courses = db.getCourses();
        updateCourses();



        final EditText courseCodeEditText = (EditText) findViewById(R.id.courseCodeEditText);
        final EditText courseNameEditText = (EditText) findViewById(R.id.courseNameEditText);
        final Button searchButton = (Button) findViewById(R.id.searchButton);
        final Button editButton = (Button) findViewById(R.id.editButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                idx = -1;
                for(int i = 0; i < courses.size(); i++) {
                    if(courses.get(i).getCode().equals(courseCodeEditText.getText().toString())) {
                        idx = i;
                    }
                }
                if(idx == -1) {
                    Toast.makeText(AdminEditCourse.this, "Couldn't find course" , Toast.LENGTH_SHORT).show();
                } else {
                    courseNameEditText.setText(courses.get(idx).getName());
                }
                updateCourses();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Course temp = new Course(courseNameEditText.getText().toString(), courseCodeEditText.getText().toString());
                Log.e("asd", courses.get(idx).toString());
                db.deleteCourse(courses.get(idx));
                db.addCourse(temp);
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
        userListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));

    }
}

