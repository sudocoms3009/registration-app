package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HumanitiesActivity extends AppCompatActivity {
    ListView listView;

    SchoolsListViewAdapter schoolsListViewAdapter;
    ArrayList<Schools> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humanities);
        getSupportActionBar().hide();

        listView = findViewById(R.id.humanities_listview);
        arrayList = new ArrayList<>();

        arrayList.add(new Schools("Computer Science", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Schools("Chemistry", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Schools("Geoscience", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Schools("Physics", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Schools("Mathematics", "this is school of computer science we do programming and machine learning", "12"));
        schoolsListViewAdapter = new SchoolsListViewAdapter(getApplicationContext(), arrayList);
        listView.setAdapter(schoolsListViewAdapter);
    }
}
