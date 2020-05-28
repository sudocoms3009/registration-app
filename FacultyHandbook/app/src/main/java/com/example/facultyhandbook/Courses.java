package com.example.facultyhandbook;


public class Courses {

    String courseCode;
    String courseName;
    String courseFaculty;
    String courseDuration;
    String nqfPoints;


    public Courses(String courseCode, String courseName, String courseFaculty, String courseDuration, String nqfPoints) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseFaculty = courseFaculty;
        this.courseDuration = courseDuration;
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

    public String getcourseFaculty() {
        return courseFaculty;
    }

    public void setcourseFaculty(String courseFaculty) {
        this.courseFaculty = courseFaculty;
    }

    public String getcourseDuration() {
        return courseDuration;
    }

    public void setcourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getnqfPoints() {
        return nqfPoints;
    }

    public void setnqfPoints(String nqfPoints) {
        this.nqfPoints = nqfPoints;
    }
}
