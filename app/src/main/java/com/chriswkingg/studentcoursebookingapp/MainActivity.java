package com.chriswkingg.studentcoursebookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button adminBtn = (Button) findViewById(R.id.admin);
        Button teacherBtn = (Button) findViewById(R.id.teacher);
        Button studentBtn = (Button) findViewById(R.id.student);


        adminBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, LoginPage.class).putExtra("USERTYPE", "admin"));
            }
        });

        teacherBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, LoginPage.class).putExtra("USERTYPE", "teacher"));
            }
        });

        studentBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, LoginPage.class).putExtra("USERTYPE", "student"));
            }
        });
    }
}
