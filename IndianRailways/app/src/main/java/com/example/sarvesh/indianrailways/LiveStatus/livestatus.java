package com.example.sarvesh.indianrailways.LiveStatus;

import android.app.DatePickerDialog;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.sarvesh.indianrailways.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



public class livestatus extends AppCompatActivity  {
    Calendar myCalendar;
    EditText ed;
    Livefragment fragment;
    Bundle bundle;
    FragmentTransaction transaction;
    DatePickerDialog.OnDateSetListener date;
    String s;
    FrameLayout framelayout;
    String l;
    Button dp;
    static int cnt=0;
    FragmentManager fragmentManager ;
    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livestatus);
        fragmentManager = getSupportFragmentManager();
        Intent i = getIntent();
        ed = (EditText) findViewById(R.id.e1);
        dp = (Button) findViewById(R.id.date);
        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = ed.getText().toString();
            }
        });

cnt=0;
        myCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
framelayout =(FrameLayout)findViewById(R.id.framelayout);
        dp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(livestatus.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

fragment=new Livefragment();
        go=(Button)findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                transaction= fragmentManager.beginTransaction();


                if(fragment!=null&&cnt>=1) {
                    transaction.remove(fragment);
                    fragment = new Livefragment();
                }
               bundle = new Bundle();
                s = ed.getText().toString();
                bundle.putString("train", s);
                bundle.putString("doj", l);
                Toast.makeText(livestatus.this, s + " " + l, Toast.LENGTH_LONG).show();
                fragment.setArguments(bundle);
                transaction.add(R.id.framelayout, fragment);
                transaction.commit();
                cnt++;
//                transaction.commit();

            }
        });


    }
    private void updateLabel()
    {

        String myFormat = "yyyyMMdd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        l=sdf.format(myCalendar.getTime());
    }



    }



