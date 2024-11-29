package com.themepark.management.prvms;

import java.util.ArrayList;

public class Visitor {

    private String playStatus;
    private int playOfNumber = 1;
    private final ArrayList<String> rideHistories = new ArrayList<>();

    public Visitor(){super();}
    public Visitor(int ID, String firstName, String lastName, String mobileNumber, String playStatus){
        super();
        this.playStatus = playStatus;
    }

    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        this.playStatus = playStatus;
    }

    public int getPlayOfNumber() {
        return playOfNumber;
    }

    public ArrayList<String> getRideHistories() {
        return rideHistories;
    }
}
