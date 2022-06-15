package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AdminPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);

        //adminPageControls
        Button adminAddCourse = (Button) findViewById(R.id.adminAddCourse);
        Button adminDelCourse = (Button) findViewById(R.id.adminDelCourse);
        Button adminAddUser = (Button) findViewById(R.id.adminAddUser);
        Button adminDelUser = (Button) findViewById(R.id.adminDelUser);

        adminAddCourse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AdminPage.this, adminAddCourse.class));
            }
        });

        adminDelCourse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AdminPage.this, adminDelCourse.class));
            }
        });

        adminAddUser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AdminPage.this, adminAddUser.class));
            }
        });

        adminDelUser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AdminPage.this, adminDelUser.class));
            }
        });

    }
}
