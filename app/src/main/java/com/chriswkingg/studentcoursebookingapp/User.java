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