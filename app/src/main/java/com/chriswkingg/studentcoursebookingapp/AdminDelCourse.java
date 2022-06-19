package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class AdminDelCourse extends AppCompatActivity{
    ListView courseListView;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_course);

        courseListView = this.findViewById(R.id.courseListView);
        database = new Database(AdminDelCourse.this);
        final EditText delCourse = (EditText) findViewById(R.id.crsDel);
        Button delete = (Button) findViewById(R.id.DeleteBtn);

        updateCourse();
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String cd = delCourse.getText().toString();
                final Course crs = new Course(cd);
                database.deleteCourse(crs);
                updateCourse();
            }
        });

    }
    private void updateCourse() {
        ArrayList<Course> courses = database.getCourses();
        ArrayList<String> courseList = new ArrayList<String>();
        for(Course i : courses) {
            courseList.add(i.toString());
        }
        courseListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));


    }


}
