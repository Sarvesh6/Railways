package com.example.sarvesh.indianrailways.PNRStatus;

/**
 * Created by Sarvesh on 7/9/2016.
 */
public class pass {
    private String booking_status;
    private String current_status;
    private int coach_position;
    private int no;

    public String getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(String booking_status) {
        this.booking_status = booking_status;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    public int getCoach_position() {
        return coach_position;
    }

    public void setCoach_position(int coach_position) {
        this.coach_position = coach_position;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
