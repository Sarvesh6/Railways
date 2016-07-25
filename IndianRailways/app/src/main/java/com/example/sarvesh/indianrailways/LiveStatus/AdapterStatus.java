package com.example.sarvesh.indianrailways.LiveStatus;

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
 * Created by Sarvesh on 7/8/2016.
 */
public class AdapterStatus extends ArrayAdapter<Routes> {
    Context context;
    ArrayList<Routes> batches;
    public AdapterStatus(Context context, ArrayList<Routes> objects) {
        super(context, 0, objects);
        this.context = context;
        batches = objects;
    }

    public static class ViewHolder{
        TextView  name;
        TextView code;
        TextView aar;
        TextView sar;
        TextView adp;
        TextView sdp;
        TextView late;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(context, R.layout.list_item,null);
            TextView nametext = (TextView) convertView.findViewById(R.id.text10);
            TextView codetext = (TextView) convertView.findViewById(R.id.text11);
            TextView aartext = (TextView) convertView.findViewById(R.id.textView1);
            TextView sartext = (TextView) convertView.findViewById(R.id.textView2);
            TextView adptext = (TextView) convertView.findViewById(R.id.textView3);
            TextView sdptext = (TextView) convertView.findViewById(R.id.textView4);
            TextView latetext = (TextView) convertView.findViewById(R.id.textlate);
            ViewHolder vh = new ViewHolder();
            vh.aar = aartext;
            vh.sar = sartext;
            vh.adp=adptext;
            vh.sdp=sdptext;
            vh.name=nametext;
            vh.code=codetext;
            vh.late=latetext;
            convertView.setTag(vh);
        }

        ViewHolder vh = (ViewHolder)convertView.getTag();
      Routes j = batches.get(position);
//ArrayList<Movie> p=j.getResults();

    if(j.getLatemin()>0)
    {if(j.isHas_departed()) {
        vh.late.setText(" " + j.getLatemin()+" min");
    }
        else
    {
        vh.late.setText(" " + (j.getLatemin())+" min*");
    }
        vh.late.setTextColor(Color.RED);
    }
    else
        {
            if (j.isHas_departed()) {
                vh.late.setText(" " + -1*j.getLatemin()+" min");
            } else {
                vh.late.setText(" " + -1*(j.getLatemin()) + " min*");
            }
            vh.late.setTextColor(Color.rgb(41, 146, 29));
        }



        vh.aar.setText("Act. Arrv.: "+j.getActarr()+"    ");
        vh.adp.setText("Act. Dept.: "+j.getActdep()+"    ");
        vh.sar.setText("Sch. Arrv. :"  +j.getScharr());
        vh.sdp.setText("Sch. Dept. "+j.getSchdep());
        vh.name.setText(j.getStation_().getName());
        vh.code.setText("("+j.getStation_().getCode()+")");
        vh.name.setTextColor(Color.rgb(6,6,6));


     /*   vh.language.setText(j.getOriginal_language() + "");*/
      //  Picasso.with(context).load("http://image.tmdb.org/t/p/original"+j.getPoster_path()).fit().into(vh.im);

        return convertView;
    }

}

