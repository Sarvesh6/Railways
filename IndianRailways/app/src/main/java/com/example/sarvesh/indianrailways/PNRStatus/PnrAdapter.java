package com.example.sarvesh.indianrailways.PNRStatus;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sarvesh.indianrailways.LiveStatus.Routes;
import com.example.sarvesh.indianrailways.R;

import java.util.ArrayList;

/**
 * Created by Sarvesh on 7/9/2016.
 */
public class PnrAdapter extends ArrayAdapter<pass> {
    Context context;
    ArrayList<pass> batches;
    public PnrAdapter(Context context, ArrayList<pass> objects) {
        super(context, 0, objects);
        this.context = context;
        batches = objects;
    }

    public static class ViewHolder{
        TextView name;
        TextView code;
        TextView aar;
        TextView sar;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(context, R.layout.list_item2,null);
            TextView pessenger = (TextView) convertView.findViewById(R.id.pes);
            TextView booking = (TextView) convertView.findViewById(R.id.bs);
            TextView current = (TextView) convertView.findViewById(R.id.cs);
            TextView  positin= (TextView) convertView.findViewById(R.id.pos);

            ViewHolder vh = new ViewHolder();
            vh.aar = pessenger;
            vh.sar = booking;

            vh.name=current;
            vh.code=positin;
            convertView.setTag(vh);
        }

        ViewHolder vh = (ViewHolder)convertView.getTag();
        pass j = batches.get(position);
//ArrayList<Movie> p=j.getResults();


        vh.aar.setText(j.getNo()+"");
        vh.sar.setTextColor(Color.rgb(0,0, 0));
        vh.sar.setText(j.getBooking_status());
        vh.sar.setTextColor(Color.rgb(252, 13, 6));
        vh.name.setText(j.getCurrent_status());
        vh.name.setTextColor(Color.rgb(13, 252, 6));
        vh.code.setText(j.getCoach_position()+"");
        vh.code.setTextColor(Color.rgb(13, 42, 252));



     /*   vh.language.setText(j.getOriginal_language() + "");*/
        //  Picasso.with(context).load("http://image.tmdb.org/t/p/original"+j.getPoster_path()).fit().into(vh.im);

        return convertView;
    }

}


