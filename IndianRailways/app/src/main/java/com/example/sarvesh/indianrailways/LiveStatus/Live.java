package com.example.sarvesh.indianrailways.LiveStatus;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Sarvesh on 7/7/2016.
 */
public class Live {

    private ArrayList<Routes> route;
    @SerializedName("response_code")
    private int response_code;
    @SerializedName("position")
    private String position;

    private String train_number;
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public ArrayList<Routes> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<Routes> route) {
        this.route = route;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }
    // ArrayList<LiveRoute> route;
}
