package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class AdminDelUser extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_user);

        ListView userListView = findViewById(R.id.userListView);
        Database db = new Database(AdminDelUser.this);
        ArrayList<User> users = db.getUsers();
        ArrayList<String> userList = new ArrayList<String>();
        for(User i : users) {
            userList.add(i.toString());
        }
        userListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList));
    }
}
