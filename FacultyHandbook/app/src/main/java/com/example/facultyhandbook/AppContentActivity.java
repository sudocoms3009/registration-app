package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AppContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_content);
        getSupportActionBar().hide();
    }
}
