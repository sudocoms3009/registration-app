package com.example.facultyhandbook;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class YOS1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView listView;

    CoursesListViewAdapter coursesListViewAdapter;
    ArrayList<Courses> arrayList;
    private static final String URLGET = "https://lamp.ms.wits.ac.za/~s1422085/FacultyRegistrationTest_2/Courses/getCSAMCourses1.php";
    ImageView back;
    View view;
    TextView school;
    String strSchool;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public YOS1Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static YOS2Fragment newInstance(String param1) {
        YOS2Fragment fragment = new YOS2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_yos1, container, false);

        String strSchool = getArguments().getString("School");

        Fragment fragment = new YOS2Fragment();
        Fragment fragment2 = new YOS3Fragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("School", strSchool);
        fragment.setArguments(bundle1);
        fragment2.setArguments(bundle1);

        school = view.findViewById(R.id.school);
        listView = view.findViewById(R.id.yos1_listview);
        back = view.findViewById(R.id.back);

        //System.out.println("The school is "+strtext);
        school.setText(strSchool);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ScienceActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), CourseInfoActivity.class);
                //intent.putExtra("id",arrayList.get(position).get);
                //intent.putExtra("School", arrayList.get(position).getcourseCode());
                startActivity(intent);
            }
        });


        /*arrayList = new ArrayList<>();

        arrayList.add(new Courses("SCHOOL OF COMPUTER SCIENCES AND APPLIED MATHEMATIC", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Courses("SCHOOL OF BIOLOGY", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Courses("Geoscience", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Courses("Physics", "this is school of computer science we do programming and machine learning", "12"));
        arrayList.add(new Courses("Mathematics", "this is school of computer science we do programming and machine learning", "12"));
        coursesListViewAdapter = new CoursesListViewAdapter(getContext(), arrayList);
        listView.setAdapter(coursesListViewAdapter);*/
        // Inflate the layout for this fragment
        getCourses();
        return view ;
    }

    public void getCourses() {

        ContentValues params = new ContentValues();

        AsyncHTTPPost schools = new AsyncHTTPPost(URLGET, params) {

            protected void onPostExecute(String output) {

                //System.out.println("This is the in.. "+output );

                //test= output;

                try {

                    JSONArray jsonArray = new JSONArray(output);
                    //gridView = view.findViewById(R.id.gridview);
                    arrayList = new ArrayList<>();
                    //System.out.println("This is the in.. "+output );

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonobject = jsonArray.getJSONObject(i);


                        String courseCode = jsonobject.getString("COURSE_CODE");
                        String courseName = jsonobject.getString("COURSE_NAME");
                        String courseDuration = jsonobject.getString("COURSE_DURATION");
                        String schoolID = jsonobject.getString("SCHOOL_ID");
                        String nqfPoints = jsonobject.getString("COURSE_POINTS");


                        //System.out.println("This is the in.. " + schoolName);



                        arrayList.add(new Courses(courseCode, courseName, schoolID, courseDuration, nqfPoints));
                        coursesListViewAdapter = new CoursesListViewAdapter(getContext(), arrayList);
                        listView.setAdapter(coursesListViewAdapter);



                    }
                    // }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        schools.execute();
    }

   /* private void loadFragment(Fragment fragment){

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }*/





}
