package com.example.sarvesh.indianrailways.PNRStatus;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sarvesh.indianrailways.ApiClient;
import com.example.sarvesh.indianrailways.LiveStatus.AdapterStatus;
import com.example.sarvesh.indianrailways.LiveStatus.Live;
import com.example.sarvesh.indianrailways.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PNRfragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PNRfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PNRfragment extends Fragment {
    PnrAdapter adapter;
    String myapikey="vmycl8468";
    ArrayList<pass> t;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
pnrst p;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //long pnr=getArguments().getLong("pnr");
        String pnr=getArguments().getString("pnr");
       // Double pnr=Double.parseDouble(pn.replaceAll("[\\D]",""));
        final View view= inflater.inflate(R.layout.fragment_pnrfragment, container, false);
        t1=(TextView)view.findViewById(R.id.pnrno);
        t2=(TextView)view.findViewById(R.id.trainno);
        t3=(TextView)view.findViewById(R.id.doj);
        t4=(TextView)view.findViewById(R.id.clas);
        t5=(TextView)view.findViewById(R.id.from);
        t6=(TextView)view.findViewById(R.id.to);
        if (getActivity() != null)
            Toast.makeText(getActivity(), pnr , Toast.LENGTH_SHORT).show();
        Call<pnrst> usercall= ApiClient.getInterface().getresults(pnr,myapikey);
        usercall.enqueue(new Callback<pnrst>() {
            @Override
            public void onResponse(Call<pnrst> call, Response<pnrst> response) {
                if(response.isSuccessful()) {
                    p = response.body();
                    if (p.getResponse_code() == 200) {
                        t1.setText( ""+p.getPnr());
                        t2.setText( p.getTrain_name());
                        t3.setText( p.getDoj());
                        t4.setText( p.getClas());
                        t5.setText( p.getBoarding_point().getName());
                        t6.setText( p.getTo_station().getName());
                        ListView lv = (ListView) view.findViewById(R.id.list3);
                        t = p.getPassengers();
                        if (getActivity() != null)
                            adapter = new PnrAdapter(getActivity(), t);
                        lv.setAdapter(adapter);
                        if (getActivity() != null)
                            Toast.makeText(getActivity(), "NoYes" + p.getResponse_code(), Toast.LENGTH_SHORT).show();

                    } else if (p.getResponse_code() == 410) {
                        if (getActivity() != null) {
                            Toast.makeText(getActivity(), "Yes" + p.getResponse_code(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        if (getActivity() != null)
                            Toast.makeText(getActivity(), "No" + p.getResponse_code(), Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    if (getActivity() != null)
                        Toast.makeText(getActivity(), "No uncessful", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<pnrst> call, Throwable t) {
                if (getActivity() != null)
                Toast.makeText(getActivity(), "failure" , Toast.LENGTH_SHORT).show();
            }
        });
     //  View view= inflater.inflate(R.layout.fragment_pnrfragment, container, false);

        return view;
    }
}


