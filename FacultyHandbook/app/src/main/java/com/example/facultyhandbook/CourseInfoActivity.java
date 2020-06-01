package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CourseInfoActivity extends AppCompatActivity {

    ListView listView_pre, listView_co;
    String courseName;
    ImageView science, commerce, engineering, health, humanities, science_up, commerce_up, engineering_up, health_up, humanities_up;
    ScrollView science_pages, health_pages, humanities_pages;
    LinearLayout commerce_pages, engineering_pages;
    TextView course;

    PrerequisiteListViewAdapter prerequisiteListViewAdapter;
    CorequisiteListViewAdapter corequisiteListViewAdapter;
    ArrayList<Prerequisite> arrayList_pre;
    ArrayList<Corequisite> arrayList_co;
    private static final String URLGET = "https://lamp.ms.wits.ac.za/~s1422085/FacultyRegistrationTest_2/CA_getModuleRules.php";

    ImageView back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        getSupportActionBar().hide();

        courseName = getIntent().getStringExtra("Course");

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        course = findViewById(R.id.courseName);
        listView_pre = findViewById(R.id.pre_listview);
        listView_co = findViewById(R.id.co_listview);

        science = findViewById(R.id.dropdown_science);
        commerce = findViewById(R.id.dropdown_commerce);
        engineering = findViewById(R.id.dropdown_engineering);

        science_up = findViewById(R.id.up_science);
        commerce_up = findViewById(R.id.up_commerce);
        engineering_up = findViewById(R.id.up_engineering);


        science_pages = findViewById(R.id.science_pages);
        commerce_pages = findViewById(R.id.commerce_pages);
        engineering_pages = findViewById(R.id.engineering_pages);

        science_pages.setVisibility(View.GONE);
        commerce_pages.setVisibility(View.GONE);
        engineering_pages.setVisibility(View.GONE);


        course.setText(courseName);


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




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CoursesMainActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        /*arrayList_pre = new ArrayList<>();
        arrayList_co = new ArrayList<>();

        arrayList_pre.add(new Prerequisite(courseName));
        arrayList_pre.add(new Prerequisite("hello 2"));
        arrayList_pre.add(new Prerequisite("hello 3"));
        arrayList_co.add(new Corequisite("hi 1"));
        arrayList_co.add(new Corequisite("hi 2"));
        prerequisiteListViewAdapter = new PrerequisiteListViewAdapter(getApplicationContext(), arrayList_pre);
        listView_pre.setAdapter(prerequisiteListViewAdapter);
        corequisiteListViewAdapter = new CorequisiteListViewAdapter(getApplicationContext(), arrayList_co);
        listView_co.setAdapter(corequisiteListViewAdapter);

*/

       getSchools();

    }

    public void getSchools() {

        courseName = getIntent().getStringExtra("Course");

        ContentValues params = new ContentValues();
        params.put("course", courseName);
        System.out.println("This is the in.. " + courseName);

        AsyncHTTPPost schools = new AsyncHTTPPost(URLGET, params) {

            protected void onPostExecute(String output) {

                System.out.println("This is the in.. " + output);

                //test= output;

                try {

                    JSONArray jsonArray = new JSONArray(output);
                    //gridView = view.findViewById(R.id.gridview);
                     arrayList_pre = new ArrayList<>();
                      arrayList_co = new ArrayList<>();
                    //System.out.println("This is the in.. "+output );

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonobject = jsonArray.getJSONObject(i);



                        String pre_requisite = jsonobject.getString("PREREQUISITE");
                        String co_requisite = jsonobject.getString("COREQUISITE");


                        //System.out.println("This is the in.. " + schoolName);


                        arrayList_pre.add(new Prerequisite(pre_requisite));
                        arrayList_co.add(new Corequisite( co_requisite));
                        prerequisiteListViewAdapter = new PrerequisiteListViewAdapter(getApplicationContext(), arrayList_pre);
                        corequisiteListViewAdapter = new CorequisiteListViewAdapter(getApplicationContext(), arrayList_co);
                        listView_pre.setAdapter(prerequisiteListViewAdapter);
                        listView_co.setAdapter(corequisiteListViewAdapter);


                    }
                    // }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        schools.execute();
    }
}
