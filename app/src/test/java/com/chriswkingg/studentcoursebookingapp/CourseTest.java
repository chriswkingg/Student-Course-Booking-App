package com.chriswkingg.studentcoursebookingapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest {
    String mockCourseName = "Test";
    String mockCourseCode = "1234";
    String mockDescription = "TestDescription";
    String mockInstructor = "TestInstructor";
    String mockTiming = "TestTiming";
    String mockCapacity = "TestCapacity";
    Course course = new Course (mockCourseName, mockCourseCode, mockDescription, mockInstructor, mockTiming, mockCapacity);

    @Test
    public void testGetCode() {
        String courseCode = course.getCode();
        assertEquals("Should return the same course code", courseCode, mockCourseCode);
    }

    @Test
    public void getName() {
        String courseName = course.getName();
        assertEquals("Should return the same course name", courseName, mockCourseName);
    }

    @Test
    public void getDescription() {
        String courseDescription = course.getDescription();
        assertEquals("Should return the same course description", courseDescription, mockDescription);
    }

    @Test
    public void getInstructor() {
        String courseInstructor = course.getInstructor();
        assertEquals("Should return the same course instructor", courseInstructor, mockInstructor);
    }

    @Test
    public void getTiming() {
        String courseTiming = course.getTiming();
        assertEquals("Should return the same course timing", courseTiming, mockTiming);
    }

    @Test
    public void getCapacity() {
        String courseCapacity = course.getCapacity();
        assertEquals("Should return the same course capacity", courseCapacity, mockCapacity);
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testToString() {
    }
}