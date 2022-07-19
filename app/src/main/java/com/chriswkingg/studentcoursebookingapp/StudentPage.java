package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_page);
        Button studentLogOut = (Button) findViewById(R.id.studentLogOut);
        Button studentEnroll = (Button) findViewById(R.id.studentEnroll);
        Button studentMyCourses = (Button) findViewById(R.id.studentMyCourses);

        TextView welcomeMessage = (TextView) findViewById(R.id.studentWelcomeText);
        welcomeMessage.setText("Hello " + getIntent().getStringExtra("username") + " logged in as student");

        studentLogOut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(StudentPage.this,  "Logged Out!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StudentPage.this, MainActivity.class));
            }
        });

        studentEnroll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(StudentPage.this,  "Select the courses to get Enrolled", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StudentPage.this, StudentEnroll.class);
                i.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(i);
            }
        });

        studentMyCourses.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(StudentPage.this,  "Here are your Courses!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StudentPage.this, StudentCourses.class);
                i.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(i);
            }
        });
    }
}
