package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class AdminDelUser extends AppCompatActivity{
    ListView userListView;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_user);

        userListView = this.findViewById(R.id.editCourseListView);
        db = new Database(AdminDelUser.this);
        updateUsers();


        final EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        final Button deleteButton = (Button) findViewById(R.id.deleteButton);

        deleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //empty string and -1 are filler paramaters as they are not needed to remove a user
                db.deleteUser(new User(usernameEditText.getText().toString(), "", -1));
                updateUsers();
            }
        });
    }

    private void updateUsers() {
        ArrayList<User> users = db.getUsers();
        ArrayList<String> userList = new ArrayList<String>();
        for(User i : users) {
            userList.add(i.toString());
        }
        userListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList));
    }
}
