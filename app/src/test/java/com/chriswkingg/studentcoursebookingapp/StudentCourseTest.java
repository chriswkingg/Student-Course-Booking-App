package com.chriswkingg.studentcoursebookingapp;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Array;
import java.util.ArrayList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCourseTest {
    @Test
    public void testDelMyCourses() {
        StudentEnroll se = new StudentEnroll();
        se.myCourses.add("MAT");
        se.myCourseTiming.add("tuesday");
        se.delMyCourses("MAT");
        assertEquals(se.myCourses.isEmpty(), true);
        assertEquals(se.myCourseTiming.isEmpty(), true);
    }

    @Test
    public void testDelMyCourses2() {
        StudentEnroll se = new StudentEnroll();
        se.myCourses.add("MAT");
        se.myCourseTiming.add("tuesday");
        se.myCourses.add("PHY");
        se.myCourseTiming.add("monday");
        se.delMyCourses("MAT");
        assertEquals(se.myCourses.get(0).equals("PHY"), true);
    }

    @Test
    public void testDelMyCoursesEmpty() {
        try {
            StudentEnroll se = new StudentEnroll();
            se.delMyCourses("MAT");
        } catch (Exception e) {
            fail("should never get here");
        }

    }

    @Test
    public void testGetCourses() {
        StudentEnroll se = new StudentEnroll();
        se.myCourses.add("MAT");
        se.myCourseTiming.add("tuesday");
        se.myCourses.add("PHY");
        se.myCourseTiming.add("monday");
        ArrayList<String> ar = se.getMyCourses();
        assertEquals(ar.get(0).equals("MAT"), true);
    }

    @Test
    public void testGetCourseTiming() {
        StudentEnroll se = new StudentEnroll();
        se.myCourses.add("MAT");
        se.myCourseTiming.add("tuesday");
        se.myCourses.add("PHY");
        se.myCourseTiming.add("monday");
        ArrayList<String> ar = se.getMyCourseTiming();
        assertEquals(ar.get(1).equals("monday"), true);
    }


}
