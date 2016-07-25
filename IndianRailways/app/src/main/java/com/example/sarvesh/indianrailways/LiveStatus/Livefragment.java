package com.example.sarvesh.indianrailways.LiveStatus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sarvesh.indianrailways.ApiClient;
import com.example.sarvesh.indianrailways.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
// * {@link Livefragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Livefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Livefragment extends Fragment {
AdapterStatus adapter;
ArrayList<Routes> r;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String train = getArguments().getString("train");
        String doj=getArguments().getString("doj");
        final View view = inflater.inflate(R.layout.fragment_blank, container, false);
       final TextView  textView =(TextView) view.findViewById(R.id.t5);
        Call<Live> usercall= ApiClient.getInterface().getSearchResults(train, doj, "vmycl8468");
        //

        usercall.enqueue(new Callback<Live>() {
            @Override
            public void onResponse(Call<Live> call, Response<Live> response) {
                if(response.isSuccessful()) {
                    Live p = response.body();
                    if(p.getResponse_code()==200) {
                        r = p.getRoute();
                        textView.setText(p.getTrain_number() +"position:"+p.getPosition());
                        if (getActivity() != null)
                        adapter = new AdapterStatus(getActivity(), r);
                        ListView lv = (ListView) view.findViewById(R.id.list2);
                        lv.setAdapter(adapter);
                    }
                    else
                    if (getActivity() != null) {
                        Toast.makeText(getActivity(), "Yes"+p.getResponse_code(), Toast.LENGTH_SHORT).show();
                    }
                }

                else
                {
                    if (getActivity() != null) {
                        Toast.makeText(getActivity(), "Yesno1", Toast.LENGTH_SHORT).show();
                    }
                }
                }


            @Override
            public void onFailure(Call<Live> call, Throwable t) {
                if (getActivity() != null) {
                    Toast.makeText(getActivity(), "Yesno2", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }



}
