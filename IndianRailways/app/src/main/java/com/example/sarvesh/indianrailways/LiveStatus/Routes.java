package com.example.sarvesh.indianrailways.LiveStatus;

/**
 * Created by Sarvesh on 7/8/2016.
 */
public class Routes {
    private Station station_;
    private String scharr;
    private String schdep;
    private String actarr;
    private String actdep;
    private int latemin;
    private boolean has_departed;

    public Station getStation_() {
        return station_;
    }

    public void setStation_(Station station_) {
        this.station_ = station_;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public String getActarr() {
        return actarr;
    }

    public void setActarr(String actarr) {
        this.actarr = actarr;
    }

    public String getActdep() {
        return actdep;
    }

    public void setActdep(String actdep) {
        this.actdep = actdep;
    }

    public int getLatemin() {
        return latemin;
    }

    public void setLatemin(int latemin) {
        this.latemin = latemin;
    }

    public boolean isHas_departed() {
        return has_departed;
    }

    public void setHas_departed(boolean has_departed) {
        this.has_departed = has_departed;
    }
}
