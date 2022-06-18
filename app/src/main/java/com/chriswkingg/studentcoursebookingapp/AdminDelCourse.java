package com.chriswkingg.studentcoursebookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class AdminDelCourse extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_course);

        Button delete = (Button) findViewById(R.id.DeleteBtn);
        final EditText delCourse = (EditText) findViewById(R.id.crsDel);
        String cd = delCourse.getText().toString();
        final Course crs = new Course(cd);
        final Database database = new Database(AdminDelCourse.this);
        final ArrayList<Course> courses = database.getCourses();
        TableView tableView = findViewById(R.id.delCourseTable);
        String [][] data = new String[courses.size()][2];

        String[] header = {"CourseID", "CourseName"};

        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this, header));
        for (int i=0; i< courses.size(); i++){
           data [i] = courses.get(i).display();
        }
        tableView.setDataAdapter(new SimpleTableDataAdapter(this, data));

        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                database.deleteCourse(crs);
                updateCourse();
                //Toast.makeText(AdminDelCourse.this, "Course Deleted" , Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void updateCourse() {
        final Database database = new Database(AdminDelCourse.this);
        ArrayList<Course> courses = database.getCourses();
        ArrayList<String> courseList = new ArrayList<String>();
        for(Course i : courses) {
            courseList.add(i.toString());
        }
        TableView tableView = findViewById(R.id.delCourseTable);
        //tableView.setDataAdapter(new SimpleTableDataAdapter(this, data));

    }


}
