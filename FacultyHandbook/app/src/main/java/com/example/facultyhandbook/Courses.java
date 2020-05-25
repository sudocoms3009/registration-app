package com.example.facultyhandbook;


public class Courses {

    String courseCode;
    String courseName;
    String nqfPoints;


    public Courses(String courseCode, String courseName, String nqfPoints) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.nqfPoints = nqfPoints;
    }

    public String getcourseCode() {
        return courseCode;
    }

    public void setcourseCode(String title) {
        this.courseCode = courseCode;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getnqfPoints() {
        return nqfPoints;
    }

    public void setnqfPoints(String nqfPoints) {
        this.nqfPoints = nqfPoints;
    }
}
