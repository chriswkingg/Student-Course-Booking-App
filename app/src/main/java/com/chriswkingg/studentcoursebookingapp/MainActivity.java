package com.chriswkingg.studentcoursebookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaring buttons
        Button login = (Button) findViewById(R.id.login);
        Button signUp = (Button) findViewById(R.id.signUp);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        //SignUp Button
        signUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, SignUpPage.class));
            }
        });

        //logIn Button
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String userName = username.getText().toString();
                String pass = password.getText().toString();

                Database database = new Database(MainActivity.this);
                User user = database.authUser(userName, pass);

                if (user == null){
                    Toast.makeText(MainActivity.this, "User does not exist in the database, try Signing-Up" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if (user.getType() == User.ADMIN){
                    Toast.makeText(MainActivity.this, "Logged in as Admin" , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, AdminPage.class);
                    i.putExtra("username", user.getUsername());
                    startActivity(i);
                } else if (user.getType() == User.INSTRUCTOR){
                    Toast.makeText(MainActivity.this, "Logged in as Instructor" , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, InstructorPage.class);
                    i.putExtra("username", user.getUsername());
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Logged in as Student" , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, StudentPage.class);
                    i.putExtra("username", user.getUsername());
                    startActivity(i);
                }
            }
        });

    }
}
