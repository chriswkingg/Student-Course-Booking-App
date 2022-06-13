package com.chriswkingg.studentcoursebookingapp;

import java.util.ArrayList;

public class User {
    private String username, password;
    private ArrayList<Course> courseList;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        //TODO: Get courses from course database and add to courseList
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }
}