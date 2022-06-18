package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class AdminAddUser extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);

        final Button addNewUser = (Button) findViewById(R.id.addNewUser);
        final EditText newUsername = (EditText) findViewById(R.id.addNewUsername);
        final EditText newPassword = (EditText) findViewById(R.id.addNewPass);
        final RadioButton student = (RadioButton) findViewById(R.id.Student);
        final RadioButton instructor = (RadioButton) findViewById(R.id.Instructor);

        student.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                instructor.setChecked(false);
            }
        });

        instructor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                student.setChecked(false);
            }
        });

        addNewUser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String username = newUsername.getText().toString();
                String password = newPassword.getText().toString();
                Database database = new Database(AdminAddUser.this);
                if (instructor.isChecked())
                    database.addUser(new User(username, password, User.INSTRUCTOR));
                else{
                    database.addUser(new User(username, password, User.STUDENT));
                }

            }
        });


    }
}
