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
        assertEquals("Should return the same course code", mockCourseCode, courseCode);
    }

    @Test
    public void testGetName() {
        String courseName = course.getName();
        assertEquals("Should return the same course name", mockCourseName, courseName);
    }

    @Test
    public void testGetDescription() {
        String courseDescription = course.getDescription();
        assertEquals("Should return the same course description", mockDescription, courseDescription);
    }

    @Test
    public void testGetInstructor() {
        String courseInstructor = course.getInstructor();
        assertEquals("Should return the same course instructor",mockInstructor , courseInstructor);
    }

    @Test
    public void testGetTiming() {
        String courseTiming = course.getTiming();
        assertEquals("Should return the same course timing", mockTiming, courseTiming);
    }

    @Test
    public void testGetCapacity() {
        String courseCapacity = course.getCapacity();
        assertEquals("Should return the same course capacity", mockCapacity, courseCapacity);
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testToString() {
    }
}