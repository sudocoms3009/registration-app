package com.example.facultyhandbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoRequisiteTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCourseName() throws NoSuchFieldException, IllegalAccessException {
        final Corequisite corequisite= new Corequisite("Database Fundamentals");
        final  String results= corequisite.getcourseName();
        assertEquals("Database Fundamentals",results);
    }

    @Test
    public void getName() throws NoSuchFieldException, IllegalAccessException {
        final Corequisite corequisite= new Corequisite("Database Fundamentals");
        corequisite.setcourseName("Database Fundamentals");
        final String results = corequisite.getcourseName();

        assertEquals("Database Fundamentals",results);
    }

}
