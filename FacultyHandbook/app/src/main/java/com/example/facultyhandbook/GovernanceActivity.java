package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GovernanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_governance);
        getSupportActionBar().hide();
    }
}
