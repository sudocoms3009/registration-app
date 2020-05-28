package com.example.facultyhandbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CoursesListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Courses> arraylist;
    int count = 0;

    public CoursesListViewAdapter(Context context, ArrayList<Courses> arraylist) {
        this.context = context;
        this.arraylist = arraylist;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arraylist.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.listview_admission, null);

        //ImageView pic = (ImageView)convertView.findViewById(R.id.picture);
        TextView courseCode = (TextView)convertView.findViewById(R.id.courseCode);
        TextView courseName = (TextView)convertView.findViewById(R.id.courseName);
        TextView courseFaculty = (TextView)convertView.findViewById(R.id.faculty);
        TextView courseDuration = (TextView)convertView.findViewById(R.id.duration);
        TextView nqfPoints = (TextView)convertView.findViewById(R.id.nqfPoints);



        courseCode.setText(arraylist.get(position).getcourseCode());
        courseName.setText(arraylist.get(position).getcourseName());
        courseFaculty.setText(arraylist.get(position).getcourseFaculty());
        courseDuration.setText(arraylist.get(position).getcourseDuration());
        nqfPoints.setText(arraylist.get(position).getnqfPoints());


        return convertView;
    }

    @Override
    public int getCount() {
        return this.arraylist.size();
    }

}
