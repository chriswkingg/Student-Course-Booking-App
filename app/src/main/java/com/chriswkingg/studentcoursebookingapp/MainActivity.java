package com.chriswkingg.studentcoursebookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        Button login = (Button) findViewById(R.id.login);
        Button signUp = (Button) findViewById(R.id.signUp);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);


        signUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, SignUpPage.class));
            }
        });


        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String userName = username.getText().toString();
                String pass = password.getText().toString();

                Database database = new Database(MainActivity.this);
                Log.i(userName, userName);
                User user = database.authUser(userName, pass);

                Toast.makeText(MainActivity.this, "Authorized" + user, Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(MainActivity.this, AdminPage.class));
            }
        });
    }
}
