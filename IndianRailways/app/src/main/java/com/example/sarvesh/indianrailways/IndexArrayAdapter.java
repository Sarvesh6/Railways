package com.example.sarvesh.indianrailways;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sarvesh on 7/7/2016.
 */
public class IndexArrayAdapter extends ArrayAdapter<Student> {

    Context context;
    ArrayList<Student> students;


    public IndexArrayAdapter(Context context, ArrayList<Student> objects) {
        super(context, 0, objects);
        this.context = context;
        students = objects;
    }

    public static class ViewHolder{
        TextView leftView;
        TextView rightView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(context,R.layout.list_item_layout,null);
            TextView leftTextView = (TextView) convertView.findViewById(R.id.TextView);
           // TextView rightTextView = (TextView) convertView.findViewById(R.id.rightTextView);
            ViewHolder vh = new ViewHolder();
            vh.leftView = leftTextView;
           // vh.rightView = rightTextView;

            convertView.setTag(vh);
        }

        ViewHolder vh = (ViewHolder)convertView.getTag();
        Student s = students.get(position);
        vh.leftView.setText(s.name);
      //  vh.rightView.setText(s.bName);

        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}
