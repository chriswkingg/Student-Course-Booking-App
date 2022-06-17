package com.chriswkingg.studentcoursebookingapp;

import java.util.ArrayList;

public class User {
    public static final int ADMIN = 0;
    public static final int INSTRUCTOR = 1;
    public static final int STUDENT = 2;

    private String username, password;
    private int type;
    private ArrayList<Course> courseList;

    public User(String username, String password, int type) {
        this.username = username;
        this.password = password;
        this.type = type;
        //TODO: Get courses from course database and add to courseList
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getType() {
        return this.type;
    }

    public void addCourse(Course c) {
        courseList.add(c);
        //TODO: add to course databse
    }

    public void removeCourse(Course c) {
        courseList.remove(c);
        //TODO: remove course from course database
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }
}