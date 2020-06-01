package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PreviousRulesActivity extends AppCompatActivity {

    TextView title;
    ImageView back;
    Spinner faculty;
    String spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_rules);
        getSupportActionBar().hide();

        title = findViewById(R.id.title);
        back = findViewById(R.id.back);

        final String year = getIntent().getStringExtra("year");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        title.setText("RULES FOR " + year);

        faculty = findViewById(R.id.faculty);

        final List<String> select = new ArrayList<String>();

        select.add("Science");
        select.add("Commerce");
        select.add("Engineering");
        select.add("Health");
        select.add("Humanities");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, select);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        faculty.setAdapter(dataAdapter);

        spinner = faculty.getSelectedItem().toString();

        if(spinner.equals("Science")){
            Toast.makeText(getApplicationContext(), "Hello Science", Toast.LENGTH_SHORT).show();
        }
        if(spinner.equals("Commerce")){
            Toast.makeText(getApplicationContext(), "Hello Commerce", Toast.LENGTH_SHORT).show();
        }
        if(faculty.getSelectedItem().equals("Engineering")){
            Toast.makeText(getApplicationContext(), "Hello Engineer", Toast.LENGTH_SHORT).show();
        }




    }
}
