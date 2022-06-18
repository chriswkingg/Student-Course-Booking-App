package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminAddCourse extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_course);

        Button addCourse = (Button) findViewById(R.id.addCourse);
        final EditText courseCode = (EditText) findViewById(R.id.courseCode);
        final EditText courseDesc = (EditText) findViewById(R.id.courseD);

        addCourse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String crsCode = courseCode.getText().toString();
                String crsDesc = courseDesc.getText().toString();

                Database database = new Database(AdminAddCourse.this);
                database.addCourse(new Course(crsDesc, crsCode));
                Toast.makeText(AdminAddCourse.this, "Course Successfully Added" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminAddCourse.this, AdminPage.class));
            }
        });

    }
}
