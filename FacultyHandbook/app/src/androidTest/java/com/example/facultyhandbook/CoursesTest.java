package com.example.facultyhandbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoursesTest {

    Courses courses = new Courses("COMS2015","Mobile Computing","CSAM","4 months","12");

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCourseCode(){
        final  String results= courses.getcourseCode();
        assertEquals("COMS2015",results);
    }

    @Test
    public void getCourseName(){
        final  String results= courses.getcourseName();
        assertEquals("Mobile Computing",results);
    }
    @Test
    public void getCourseFaculty(){
        final  String results= courses.getcourseFaculty();
        assertEquals("CSAM",results);
    }
    @Test
    public void getCourseDuration(){
        final  String results= courses.getcourseDuration();
        assertEquals("4 months",results);
    }
    @Test
    public void getCourseNQF(){
        final  String results= courses.getnqfPoints();
        assertEquals("12",results);
    }
}
