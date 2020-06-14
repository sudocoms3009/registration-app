package com.example.facultyhandbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchoolsTest {

    Schools schools = new Schools("Computer Science","Teach students computer science","12");
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSchoolname(){
        final  String results= schools.getschoolName();
        assertEquals("Computer Science",results);
    }
    @Test
    public void getSchooldescription(){
        final  String results= schools.getschoolDescriptions();
        assertEquals("Teach students computer science",results);
    }
    @Test
    public void getnumCoursesPass(){
        final  String results= schools.getnumCourses();
        assertEquals("12",results);
    }

}
