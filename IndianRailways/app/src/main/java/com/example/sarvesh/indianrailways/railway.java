package com.example.sarvesh.indianrailways;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sarvesh.indianrailways.LiveStatus.livestatus;
import com.example.sarvesh.indianrailways.PNRStatus.PNR;

import java.util.ArrayList;

public class railway extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    ArrayList<Student> index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_railway);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        index = new ArrayList<>();

        //  intent.get

        index.add(new Student("Train Running Status"));
        index.add(new Student("PNR Status"));
        index.add(new Student("Train Between Stations"));
        index.add(new Student("Fare Enquiry"));
        index.add(new Student("Train Details"));
        index.add(new Student("Seat Availability"));
//        index.add(new Student("Train Running Status"));
//        index.add(new Student("Train Running Status"));


        ListView lv = (ListView) findViewById(R.id.listview);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,students);
        //  lv.setAdapter(adapter);

        IndexArrayAdapter adpater = new IndexArrayAdapter(this, index);
        lv.setAdapter(adpater);
        layoutManager = new
                LinearLayoutManager(this);

        lv.setDividerHeight(5);
        lv.setHeaderDividersEnabled(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {

                    Intent i=new Intent();
                    i.setClass(railway.this, livestatus.class);
                    startActivity(i);
                }
                if(position==1)
                {
                    Intent i=new Intent();
                    i.setClass(railway.this, PNR.class);
                    startActivity(i);
                }
            }
        });


//        lv.addItemDecoration(new
//
//                VerticalItemSpaceDecoration(Vertical_Space);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_railway, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

//recyclerView=(RecyclerView)

//    findViewById(R.id.recycler_view);
//
//layoutManager=new
//
//        LinearLayoutManager(this);
//
//        recyclerView.addItemDecoration(new
//
//        VerticalItemSpaceDecoration(Vertical_Space)