package com.example.sarvesh.indianrailways.PNRStatus;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import com.example.sarvesh.indianrailways.R;

public class PNR extends AppCompatActivity {
EditText editText;
    Button button;
    static int cn=0;
    String S;
    long myNum = 0;

    Bundle bundle;
    PNRfragment fragment;
   FragmentManager fragmentManager;
    FragmentTransaction transaction;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnr2);
        cn=0;
        fragmentManager=getSupportFragmentManager();
        Intent i=getIntent();
        editText=(EditText)findViewById(R.id.ed2);
        button=(Button)findViewById(R.id.go2);
        frameLayout =(FrameLayout)findViewById(R.id.framelay2);

        fragment=new PNRfragment();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                transaction= fragmentManager.beginTransaction();
                if(fragment!=null&&cn>=1) {
                    transaction.remove(fragment);
                    fragment = new PNRfragment();
                }
                bundle = new Bundle();
                S=new String();
              S=editText.getText().toString();

              int i=0;
                myNum=0;
                while(i<S.length())
                {

                    if(i==S.length()-1)
                        break;
                    myNum=myNum*10;
                    myNum=myNum+(S.charAt(i++)-48);
                    Log.i("yes", String.valueOf(myNum));
                }
                myNum=myNum*10;
                myNum=myNum+(S.charAt(9)-48);
                Log.i("yes", String.valueOf(myNum));
               // Toast.makeText(PNR.this,myNum+String.valueOf(S.charAt(9)), Toast.LENGTH_SHORT).show();
                bundle.putString("pnr",S);
             //   bundle.putString("p2",String.valueOf(S.charAt(9)));
                fragment.setArguments(bundle);
                transaction.add(R.id.framelay2, fragment);
                transaction.commit();
                cn++;
//                transaction.commit();
            }
        });

    }
}
