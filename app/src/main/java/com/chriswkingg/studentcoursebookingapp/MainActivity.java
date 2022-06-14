package com.chriswkingg.studentcoursebookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button login = (Button) findViewById(R.id.login);
        Button signUp = (Button) findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, SignUpPage.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (login()){
                    startActivity(new Intent(MainActivity.this, SignUpPage.class));
                }
            }
        });

    }
    public boolean login() {
        if (!validate()) {
            onLoginFailed();
            return false;
        }
        Toast.makeText(getBaseContext(), "Login Success", Toast.LENGTH_LONG).show();
        return true;
    }
    public boolean validate() {

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        boolean valid = true;
        String userName = username.getText().toString();
        String pass = password.getText().toString();

        if (!"admin".equals(userName)) {
            //Toast.makeText(getBaseContext(), "Invalid", Toast.LENGTH_LONG).show();
            username.setError("Enter a Valid Username");
            return false;
        } else if (!"admin123".equals(pass)) {
            password.setError("Enter a valid Password");
            return false;
        }
        return true;
    }
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
    }

}
