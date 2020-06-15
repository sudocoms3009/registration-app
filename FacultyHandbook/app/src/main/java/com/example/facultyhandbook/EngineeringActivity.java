package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EngineeringActivity extends AppCompatActivity {

    ListView listView;
    ImageView back;

    SchoolsListViewAdapter schoolsListViewAdapter;
    ArrayList<Schools> arrayList;
    private static final String URLGET = "https://lamp.ms.wits.ac.za/~s1422085/FacultyRegistrationTest_2/Schools/getEngineeringSchools.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering);
        getSupportActionBar().hide();

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.engineering_listview);

        getSchools();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CoursesMainActivity.class);
                //intent.putExtra("id",arrayList.get(position).get);
                intent.putExtra("School", arrayList.get(position).getschoolName());
                startActivity(intent);
            }
        });
              /*arrayList = new ArrayList<>();

        arrayList.add(new Schools("Computer Science", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Schools("Chemistry", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Schools("Geoscience", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Schools("Physics", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Schools("Mathematics", "this is school of computer science we do programming and machine learning", "12"));
        schoolsListViewAdapter = new SchoolsListViewAdapter(getApplicationContext(), arrayList);
        listView.setAdapter(schoolsListViewAdapter);*/


    }

    public void getSchools() {

        ContentValues params = new ContentValues();

        AsyncHTTPPost schools = new AsyncHTTPPost(URLGET, params) {

            protected void onPostExecute(String output) {

                //test= output;

                try {

                    JSONArray jsonArray = new JSONArray(output);
                    //gridView = view.findViewById(R.id.gridview);
                    arrayList = new ArrayList<>();

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonobject = jsonArray.getJSONObject(i);


                        String schoolName = jsonobject.getString("schoolName");
                        String schoolDescription = jsonobject.getString("schoolDescription");
                        String numCourses = jsonobject.getString("numCourses");


                        //System.out.println("This is the in.. " + prodName);



                        arrayList.add(new Schools(schoolName, schoolDescription, numCourses));
                        schoolsListViewAdapter = new SchoolsListViewAdapter(getApplicationContext(), arrayList);
                        listView.setAdapter(schoolsListViewAdapter);



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

