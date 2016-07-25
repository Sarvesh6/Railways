package com.example.sarvesh.indianrailways.PNRStatus;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class pnrst {
    @SerializedName("response_code")
    private int response_code;
    private String train_name;
    private long pnr;
    private String doj;
    private String chart_prepared;
    @SerializedName("class")
    private String clas;

    private ArrayList<pass> passengers;

    private Boarding boarding_point;
    private To to_station;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public long getPnr() {
        return pnr;
    }

    public void setPnr(long pnr) {
        this.pnr = pnr;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getChart_prepared() {
        return chart_prepared;
    }

    public void setChart_prepared(String chart_prepared) {
        this.chart_prepared = chart_prepared;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public ArrayList<pass> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<pass> passengers) {
        this.passengers = passengers;
    }

    public Boarding getBoarding_point() {
        return boarding_point;
    }

    public void setBoarding_point(Boarding boarding_point) {
        this.boarding_point = boarding_point;
    }

    public To getTo_station() {
        return to_station;
    }

    public void setTo_station(To to_station) {
        this.to_station = to_station;
    }
}
