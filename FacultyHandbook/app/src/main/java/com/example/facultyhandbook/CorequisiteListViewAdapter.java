package com.example.facultyhandbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CorequisiteListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Corequisite> arraylist;
    int count = 0;

    public CorequisiteListViewAdapter(Context context, ArrayList<Corequisite> arraylist) {
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
        convertView = inflater.inflate(R.layout.listview_rules_co, null);

        //ImageView pic = (ImageView)convertView.findViewById(R.id.picture);
        TextView courseName = (TextView)convertView.findViewById(R.id.courseName);
        courseName.setText(arraylist.get(position).getcourseName());

        return convertView;
    }

    @Override
    public int getCount() {
        return this.arraylist.size();
    }


}
