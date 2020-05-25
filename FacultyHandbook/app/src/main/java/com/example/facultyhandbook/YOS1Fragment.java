package com.example.facultyhandbook;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

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
    private static final String URLGET = "https://lamp.ms.wits.ac.za/~s1422085/FacultyRegistrationTest/getCourses.php";

    View view;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public YOS1Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static YOS1Fragment newInstance(String param1, String param2) {
        YOS1Fragment fragment = new YOS1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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

        listView = view.findViewById(R.id.yos1_listview);

        // Inflate the layout for this fragment
        getCourses();
        return view ;
    }

    public void getCourses() {

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


                        String schoolName = jsonobject.getString("COURSE_CODE");
                        String schoolDescription = jsonobject.getString("COURSE_NAME");
                        String numCourses = jsonobject.getString("SCHOOL_ID");


                        //System.out.println("This is the in.. " + schoolName);



                        arrayList.add(new Courses(schoolName, schoolDescription, numCourses));
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





}
