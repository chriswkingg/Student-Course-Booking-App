package com.chriswkingg.studentcoursebookingapp;

public class Course {
    private String code, name;

    public Course(String description, String code) {
        this.name = description;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return name;
    }

    public boolean equals(Object o) {
        if(this.getClass() != o.getClass()) {
            return false;
        }
        Course temp = (Course) o;
        return this.getDescription() == temp.getDescription() && this.getCode() == temp.getCode();
    }
}