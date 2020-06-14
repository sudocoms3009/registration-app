package com.example.facultyhandbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class preRequisiteTest {

    Prerequisite prerequisite= new Prerequisite("Database Fundamentals");


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCourseName(){
        final  String results= prerequisite.getcourseName();
        assertEquals("Database Fundamentals",results);
    }

    @Test
    public void getName() throws NoSuchFieldException, IllegalAccessException {
        prerequisite.setcourseName("Database Fundamentals");
        final String results = prerequisite.getcourseName();
        assertEquals("Database Fundamentals",results);
    }
}
