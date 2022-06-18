package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        final Button addNewUser = (Button) findViewById(R.id.createButton);
        final EditText createUsername = (EditText) findViewById(R.id.createUsername);
        final EditText createPassword = (EditText) findViewById(R.id.createPassword);

        addNewUser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String username = createUsername.getText().toString();
                String password = createPassword.getText().toString();
                Database database = new Database(SignUpPage.this);
                database.addUser(new User(username, password, User.STUDENT));

                Toast.makeText(SignUpPage.this, "Account created, please sign in" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignUpPage.this, MainActivity.class));

            }
        });
    }
}
