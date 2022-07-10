package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InstructorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_page);
        Button instructorCourse = (Button) findViewById(R.id.viewCourse);
        Button viewAssignedCourses = (Button) findViewById(R.id.viewAssignedCourses);

        TextView welcomeMessage = (TextView) findViewById(R.id.instructorWelcomeMessage);
        welcomeMessage.setText("Welcome " + getIntent().getStringExtra("username") + ", your are logged in as an instructor");

        instructorCourse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toast.makeText(InstructorPage.this, "Account created, please sign in" , Toast.LENGTH_SHORT).show();
                Intent i = new Intent(InstructorPage.this, InstructorViewCourse.class);
                i.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(i);
            }
        });

        viewAssignedCourses.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //startActivity(new Intent(InstructorPage.this, InstructorAssignedCourses.class));
                Intent i = new Intent(InstructorPage.this, InstructorAssignedCourses.class);
                i.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(i);
            }
        });

    }
}
