package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
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

        userListView = findViewById(R.id.userListView);
        db = new Database(AdminDelUser.this);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

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
