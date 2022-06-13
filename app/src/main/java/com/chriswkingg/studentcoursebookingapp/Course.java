package com.chriswkingg.studentcoursebookingapp;

public class Course {
    private String code, name;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}