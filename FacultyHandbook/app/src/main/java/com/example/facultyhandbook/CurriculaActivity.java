package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class CurriculaActivity extends AppCompatActivity {

    ImageView back, science, commerce, engineering, health, humanities, science_up, commerce_up, engineering_up, health_up, humanities_up;
    ScrollView science_pages, commerce_pages, engineering_pages, health_pages, humanities_pages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curricula);

        getSupportActionBar().hide();

        back = findViewById(R.id.back);
        science = findViewById(R.id.dropdown_science);
        commerce = findViewById(R.id.dropdown_commerce);
        engineering = findViewById(R.id.dropdown_engineering);
        health = findViewById(R.id.dropdown_health);
        humanities = findViewById(R.id.dropdown_humanities);

        science_up = findViewById(R.id.up_science);
        commerce_up = findViewById(R.id.up_commerce);
        engineering_up = findViewById(R.id.up_engineering);
        health_up = findViewById(R.id.up_health);
        humanities_up = findViewById(R.id.up_humanities);

        science_pages = findViewById(R.id.science_pages);
        commerce_pages = findViewById(R.id.commerce_pages);
        engineering_pages = findViewById(R.id.engineering_pages);
        health_pages = findViewById(R.id.health_pages);
        humanities_pages = findViewById(R.id.humanities_pages);

        science_pages.setVisibility(View.GONE);
        commerce_pages.setVisibility(View.GONE);
        engineering_pages.setVisibility(View.GONE);
        health_pages.setVisibility(View.GONE);
        humanities_pages.setVisibility(View.GONE);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                science_pages.setVisibility(View.VISIBLE);
                science.setVisibility(View.GONE);
                science_up.setVisibility(View.VISIBLE);


            }
        });

        science_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                science_pages.setVisibility(View.GONE);
                science_up.setVisibility(View.GONE);
                science.setVisibility(View.VISIBLE);


            }
        });

        commerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                commerce_pages.setVisibility(View.VISIBLE);
                commerce.setVisibility(View.GONE);
                commerce_up.setVisibility(View.VISIBLE);

            }
        });

        commerce_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                commerce_pages.setVisibility(View.GONE);
                commerce_up.setVisibility(View.GONE);
                commerce.setVisibility(View.VISIBLE);


            }
        });

        engineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                engineering_pages.setVisibility(View.VISIBLE);
                engineering.setVisibility(View.GONE);
                engineering_up.setVisibility(View.VISIBLE);

            }
        });

        engineering_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                engineering_pages.setVisibility(View.GONE);
                engineering_up.setVisibility(View.GONE);
                engineering.setVisibility(View.VISIBLE);


            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                health_pages.setVisibility(View.VISIBLE);
                health.setVisibility(View.GONE);
                health_up.setVisibility(View.VISIBLE);

            }
        });

        health_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                health_pages.setVisibility(View.GONE);
                health_up.setVisibility(View.GONE);
                health.setVisibility(View.VISIBLE);


            }
        });

        humanities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                humanities_pages.setVisibility(View.VISIBLE);
                humanities.setVisibility(View.GONE);
                humanities_up.setVisibility(View.VISIBLE);

            }
        });

        humanities_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                humanities_pages.setVisibility(View.GONE);
                humanities_up.setVisibility(View.GONE);
                humanities.setVisibility(View.VISIBLE);


            }
        });


    }
}
