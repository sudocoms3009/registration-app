package com.example.facultyhandbook;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CoursesPreviousActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_previous);
        getSupportActionBar().hide();

       final String schoolName = getIntent().getStringExtra("School");

/*
        Fragment fragment = new AdmissionFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("School", schoolName);
        fragment.setArguments(bundle0);*/
        loadFragment(new AdmissionPreviousFragment());


        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            public boolean onNavigationItemSelected(MenuItem item){

                Fragment fragment;


                switch (item.getItemId()){
                    case R.id.admission:
                        fragment = new AdmissionPreviousFragment();
                        //Bundle bundle = new Bundle();
                        //bundle.putString("School", schoolName);
                        //fragment.setArguments(bundle);
                        loadFragment(fragment);

                        break;

                    case R.id.first_year:
                        fragment = new YOS1PreviousFragment();
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("School", schoolName);
                        fragment.setArguments(bundle1);
                        loadFragment(fragment);

                        break;

                    case R.id.second_year:
                        Fragment fragment2 = new YOS2Fragment();
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("School", schoolName);
                        fragment2.setArguments(bundle2);
                        loadFragment(fragment2);

                        break;

                    case R.id.third_year:
                        fragment = new YOS3Fragment();
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("School", schoolName);
                        fragment.setArguments(bundle3);
                        loadFragment(fragment);

                        break;



                }
                return true;

            }
        });
    }

    private void loadFragment(Fragment fragment){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
