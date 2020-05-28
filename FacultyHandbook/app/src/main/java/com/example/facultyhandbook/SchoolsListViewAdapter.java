package com.example.facultyhandbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class SchoolsListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Schools> arraylist;
    int count = 0;

    public SchoolsListViewAdapter(Context context, ArrayList<Schools> arraylist) {
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
        convertView = inflater.inflate(R.layout.listview_schools, null);

        ImageView pic = (ImageView)convertView.findViewById(R.id.picture);
        TextView schoolName = (TextView)convertView.findViewById(R.id.schoolName);
        TextView schoolDescriptions = (TextView)convertView.findViewById(R.id.schoolDescription);
        TextView numCourses = (TextView)convertView.findViewById(R.id.numCourses);



        schoolName.setText(arraylist.get(position).getschoolName());
        schoolDescriptions.setText(arraylist.get(position).getschoolDescriptions());
        numCourses.setText(arraylist.get(position).getnumCourses());

        if(arraylist.get(position).getschoolName().equals("SCHOOL OF ANIMAL, PLANTS AND ENVIROMENTAL SCIENCES")){

            pic.setImageResource(R.drawable.environmental);
        }
        if(arraylist.get(position).getschoolName().equals("SCHOOL OF CHEMISTRY")){

            pic.setImageResource(R.drawable.chemistry);
        }
        if(arraylist.get(position).getschoolName().equals("SCHOOL OF COMPUTER SCIENCE AND APPLIED MATHEMATICS")){

            pic.setImageResource(R.drawable.computerscience);
        }
        if(arraylist.get(position).getschoolName().equals("SCHOOL OF GEOGRAPHY, ARCHAEOLOGY AND ENVIRONMENTAL")){

            pic.setImageResource(R.drawable.geography);
        }
        if(arraylist.get(position).getschoolName().equals("SCHOOL OF GEOSCIENCES")){

            pic.setImageResource(R.drawable.geosciences);
        }
        if(arraylist.get(position).getschoolName().equals("SCHOOL OF MATHEMATICS")){

            pic.setImageResource(R.drawable.mathematics);
        }
        if(arraylist.get(position).getschoolName().equals("SCHOOL OF MOLECULAR AND CELL BIOLOGY")){

            pic.setImageResource(R.drawable.biology);
        }
        if(arraylist.get(position).getschoolName().equals("SCHOOL OF PHYSICS")){

            pic.setImageResource(R.drawable.physics);
        }
        if(arraylist.get(position).getschoolName().equals("SCHOOL OF STATISTICS AND ACTUARIAL SCIENCES")){

            pic.setImageResource(R.drawable.actuarial);
        }






        return convertView;
    }

    @Override
    public int getCount() {
        return this.arraylist.size();
    }


}
