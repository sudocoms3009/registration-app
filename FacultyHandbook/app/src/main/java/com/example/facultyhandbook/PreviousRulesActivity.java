package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PreviousRulesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView title;
    ImageView back;
    Spinner faculty;
    String spinner;
    ListView listView;
    SchoolsListViewAdapter schoolsListViewAdapter;
    ArrayList<Schools> arrayList;
    private static final String URLGET = "https://lamp.ms.wits.ac.za/~s1422085/FacultyRegistrationTest_2/Schools/getScienceSchools.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_rules);
        getSupportActionBar().hide();

        title = findViewById(R.id.title);
        back = findViewById(R.id.back);
        listView = findViewById(R.id.science_listview);

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
        faculty.setOnItemSelectedListener(this);

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





    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinner = parent.getItemAtPosition(position).toString();

        if(spinner.equals("Science")){

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), CoursesPreviousActivity.class);
                    //intent.putExtra("id",arrayList.get(position).get);
                    intent.putExtra("School", arrayList.get(position).getschoolName());
                    startActivity(intent);
                }
            });
            arrayList = new ArrayList<>();

            ContentValues params = new ContentValues();

            AsyncHTTPPost schools = new AsyncHTTPPost(URLGET, params) {

                protected void onPostExecute(String output) {

                    System.out.println("This is the in.. "+output );

                    //test= output;

                    try {

                        JSONArray jsonArray = new JSONArray(output);
                        //gridView = view.findViewById(R.id.gridview);
                        arrayList = new ArrayList<>();
                        //System.out.println("This is the in.. "+output );

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonobject = jsonArray.getJSONObject(i);


                            String schoolName = jsonobject.getString("SCHOOL_NAME");
                            String schoolDescription = jsonobject.getString("SCHOOL_DESCRIPTION");
                            String numCourses = jsonobject.getString("NUMBER_OF_COURSES");


                            //System.out.println("This is the in.. " + schoolName);



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

        Toast.makeText(getApplicationContext(), "Science Faculty selected", Toast.LENGTH_SHORT).show();
        }
        if(spinner.equals("Commerce")){
            arrayList = new ArrayList<>();

            arrayList.add(new Schools("SCHOOL OF COMPUTER SCIENCES AND APPLIED MATHEMATIC", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("SCHOOL OF BIOLOGY", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Geoscience", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Physics", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Mathematics", "this is school of computer science we do programming and machine learning", "12"));
            schoolsListViewAdapter = new SchoolsListViewAdapter(getApplicationContext(), arrayList);
            listView.setAdapter(schoolsListViewAdapter);
            Toast.makeText(getApplicationContext(), "Commerce Faculty selected", Toast.LENGTH_SHORT).show();
        }
        if(spinner.equals("Engineering")){

            arrayList = new ArrayList<>();

            arrayList.add(new Schools("SCHOOL OF COMPUTER SCIENCES AND APPLIED MATHEMATIC", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("SCHOOL OF BIOLOGY", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Geoscience", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Physics", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Mathematics", "this is school of computer science we do programming and machine learning", "12"));
            schoolsListViewAdapter = new SchoolsListViewAdapter(getApplicationContext(), arrayList);
            listView.setAdapter(schoolsListViewAdapter);
            Toast.makeText(getApplicationContext(), "Engineeing Faculty selected", Toast.LENGTH_SHORT).show();
        }
        if(spinner.equals("Health")){

            arrayList = new ArrayList<>();

            arrayList.add(new Schools("SCHOOL OF COMPUTER SCIENCES AND APPLIED MATHEMATIC", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("SCHOOL OF BIOLOGY", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Geoscience", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Physics", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Mathematics", "this is school of computer science we do programming and machine learning", "12"));
            schoolsListViewAdapter = new SchoolsListViewAdapter(getApplicationContext(), arrayList);
            listView.setAdapter(schoolsListViewAdapter);
            Toast.makeText(getApplicationContext(), "Health Faculty selected", Toast.LENGTH_SHORT).show();
        }
        if(spinner.equals("Humanities")){

            arrayList = new ArrayList<>();

            arrayList.add(new Schools("SCHOOL OF COMPUTER SCIENCES AND APPLIED MATHEMATIC", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("SCHOOL OF BIOLOGY", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Geoscience", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Physics", "this is school of computer science we do programming and machine learning", "12"));
            arrayList.add(new Schools("Mathematics", "this is school of computer science we do programming and machine learning", "12"));
            schoolsListViewAdapter = new SchoolsListViewAdapter(getApplicationContext(), arrayList);
            listView.setAdapter(schoolsListViewAdapter);
            Toast.makeText(getApplicationContext(), "Humanities Faculty selected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
