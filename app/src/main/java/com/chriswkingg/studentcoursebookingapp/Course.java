package com.chriswkingg.studentcoursebookingapp;

public class Course {
    private String code, name;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Course(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if(this.getClass() != o.getClass()) {
            return false;
        }
        Course temp = (Course) o;
        return this.getName() == temp.getName() && this.getCode() == temp.getCode();
    }

    public String toString() {

        return this.code+ " : "+ this.name;
    }

}