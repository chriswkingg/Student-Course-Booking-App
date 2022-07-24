package com.chriswkingg.studentcoursebookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;
import java.util.ArrayList;

public class StudentEnroll extends AppCompatActivity {
    ListView studentCourseList;
    Database db;
    ArrayList<Course> listOfCourses;
    int idx = -1;
    public static ArrayList<String> myCourses = new ArrayList<>();
    public static ArrayList<String> myCourseTiming = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.student_enroll);
        //Button studentEnroll = (Button) findViewById(R.id.studentEnrollCourse);
        //Button studentSearchCourse = (Button) findViewById(R.id.studentSearchCourse);

        //final EditText courseCode = (EditText) findViewById(R.id.studentCourseCode);
        //final EditText courseName = (EditText) findViewById(R.id.studentCourseName);
        //final EditText courseTiming = (EditText) findViewById(R.id.studentCourseTiming);

        //studentCourseList = this.findViewById(R.id.studentCourseListView);
        db = new Database(StudentEnroll.this);
        listOfCourses = db.getCourses();
        /*updateCourses();

        studentSearchCourse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                idx = -1;
                for(int i = 0; i < listOfCourses.size(); i++) {
                    if ((listOfCourses.get(i).getCode().equals(courseCode.getText().toString()) && !courseCode.getText().toString().equals("")) || (listOfCourses.get(i).getName().equals(courseName.getText().toString()) && !courseName.getText().toString().equals("")) || (listOfCourses.get(i).getTiming().equals(courseTiming.getText().toString()) && !courseTiming.getText().toString().equals(""))) {
                        idx = i;
                    }
                }
                if (idx==-1){
                    Toast.makeText(StudentEnroll.this, "Sorry, couldn't find course." , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(StudentEnroll.this, "Course is available! Fill the course code and click Enroll" , Toast.LENGTH_SHORT).show();
                }

            }
        });

        studentEnroll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int flag = -1;
                for(int i = 0; i < listOfCourses.size(); i++) {
                    if ((listOfCourses.get(i).getCode().equals(courseCode.getText().toString())) || (listOfCourses.get(i).getName().equals(courseName.getText().toString())) || (listOfCourses.get(i).getTiming().equals(courseTiming.getText().toString())) ) {
                        flag = i;
                        if (myCourses == null && myCourseTiming == null){
                            myCourses = new ArrayList<String>();
                            myCourseTiming = new ArrayList<String>();
                        }
                        if (listOfCourses.get(i).getCode().equals(courseCode.getText().toString())){
                            if (myCourseTiming.contains(listOfCourses.get(i).getTiming())){
                                Toast.makeText(StudentEnroll.this, "Course on the same day! Possible Conflict. Pick a different course", Toast.LENGTH_SHORT).show();
                            }else{
                                myCourses.add(listOfCourses.get(i).getCode());
                                myCourseTiming.add(listOfCourses.get(i).getTiming());
                                Toast.makeText(StudentEnroll.this, "You have Successfully Enrolled in the course!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(StudentEnroll.this, StudentPage.class);
                                intent.putExtra("username", getIntent().getStringExtra("username"));
                                startActivity(intent);
                            }

                        }
                    }
                }
                if (flag == -1){
                    Toast.makeText(StudentEnroll.this,  "No such course found!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }*/
    }
    public static ArrayList<String> getMyCourses(){
        return myCourses;
    }

    public static ArrayList<String> getMyCourseTiming(){
        return myCourseTiming;
    }

    public void delMyCourses(String delCourse){
        if (myCourses.contains(delCourse)){
            int i = myCourses.indexOf(delCourse);
            myCourseTiming.remove(i);
            myCourses.remove(delCourse);
        }
    }
    private void updateCourses() {
        listOfCourses.clear();
        listOfCourses = db.getCourses();
        ArrayList<String> courseList = new ArrayList<String>();
        for (Course i : listOfCourses) {
            courseList.add(i.toString());
        }
        studentCourseList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList));

    }
}