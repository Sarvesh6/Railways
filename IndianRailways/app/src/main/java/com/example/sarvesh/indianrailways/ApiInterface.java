package com.example.sarvesh.indianrailways;

import com.example.sarvesh.indianrailways.LiveStatus.Live;
import com.example.sarvesh.indianrailways.PNRStatus.pnrst;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Sarvesh on 7/7/2016.
 */
public interface ApiInterface {
    @GET("live/train/{train}/doj/{doj}/apikey/{myapikey}/")
    Call<Live> getSearchResults(@Path("train") String train,@Path("doj") String doj,@Path("myapikey") String key);
    @GET("pnr_status/pnr/{pnr2}/apikey/{myapikey}/")
    Call<pnrst> getresults(@Path("pnr2") String pnr,@Path("myapikey") String key);

}
