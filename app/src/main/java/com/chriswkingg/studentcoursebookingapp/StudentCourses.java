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
import java.util.List;

public class StudentCourses extends AppCompatActivity {
    ListView studentCourseList;
    List<String> listOfCourses;
    List<String> listOfTiming;
    List<String> combinedList = new ArrayList<>();
    TextView welcomeMessage;
    StudentEnroll ob = new StudentEnroll();

    private static ArrayList<String> courseList;
    private static ArrayList<String> courseTiming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_mycourses);
        Button unEnroll = (Button) findViewById(R.id.unEnroll);
        EditText courseCode = (EditText) findViewById(R.id.StudentUnEnrollCode);
        welcomeMessage = (TextView) findViewById(R.id.studentCourseMess);
        welcomeMessage.setText("Hey " + getIntent().getStringExtra("username") + ", here are your courses");
        studentCourseList = this.findViewById(R.id.studentMyCourseList);
        updateCourses();

    }
    private void updateCourses() {

        listOfCourses = ob.getMyCourses();
        listOfTiming = ob.getMyCourseTiming();
        Toast.makeText(StudentCourses.this, "ListTiming Size is  "+listOfTiming.size() , Toast.LENGTH_SHORT).show();


        courseList = new ArrayList<String>();
        courseTiming = new ArrayList<String>();


        if (listOfCourses == null){
            welcomeMessage = (TextView) findViewById(R.id.studentCourseMess);
            welcomeMessage.setText( getIntent().getStringExtra("username") + ", you are not enrolled in any classes");
        }else {
            for (String i : listOfCourses) {
                courseList.add(i);
            }
            for(String i: listOfTiming){
                courseTiming.add(i);
            }
//            combinedList.addAll(courseList);
//            combinedList.addAll(courseTiming);
            for (int i=0; i<courseTiming.size(); i++){
                combinedList.add("Course: "+listOfCourses.get(i) +", Timing: "+ listOfTiming.get(i));
            }
        }

        studentCourseList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, combinedList));

    }
}