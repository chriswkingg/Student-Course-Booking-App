package com.chriswkingg.studentcoursebookingapp;

public class Course {
    private String code, name, description, instructor, timing, capacity;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }
    public Course(String name, String code, String description, String instructor, String timing, String capacity){
        this.name = name;
        this.code = code;
        this.description = description;
        this.instructor = instructor;
        this.timing = timing;
        this.capacity = capacity;
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

    public String getDescription(){return description; }

    public String getInstructor(){return instructor; }

    public String getTiming(){return timing; }

    public String getCapacity(){return capacity; }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public boolean equals(Object o) {
        if(this.getClass() != o.getClass()) {
            return false;
        }
        Course temp = (Course) o;
        return this.getName() == temp.getName() && this.getCode() == temp.getCode();
    }

    public String toString() {

        return this.code+ " : " + this.name + " : " + this.instructor;
    }

}