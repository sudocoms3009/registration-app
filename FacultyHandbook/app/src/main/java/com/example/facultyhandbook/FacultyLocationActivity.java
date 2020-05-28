package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FacultyLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_location);
        getSupportActionBar().hide();
    }
}
