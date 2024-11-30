package com.themepark.management.prvms;

import java.util.ArrayList;

public class Visitor {

    private String playStatus;
    private String ticketType;
    private final ArrayList<String> rideHistories = new ArrayList<>();
    private int playOfNumber = 1;

    public Visitor(){super();}
    public Visitor(int ID, String firstName, String lastName, String mobileNumber, String playStatus, String ticketType){
        super();
        this.playStatus = playStatus;
        this.ticketType = ticketType;
    }

    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        String playStatusRegex = "Leisure|On Queue|On Roller Coaster|On Thunder Storm";
        if(!playStatus.matches(playStatusRegex)){
            System.out.println("Wrong Input: The play state must be Leisure, On Queue, On Roller Coaster, or On Thunder Storm!");
        }
        else{
            this.playStatus = playStatus;
        }
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        String ticketTypeRegex = "Children|Adult|Elder";
        if(!ticketType.matches(ticketTypeRegex)){
            System.out.println("Wrong Input: The ticket type must be Children, Adult or Elder!");
        }
        else{
            this.ticketType = ticketType;
        }
    }

    public int getPlayOfNumber() {
        return playOfNumber;
    }

    public void setPlayOfNumber(){
        this.playOfNumber++;
    }

    public ArrayList<String> getRideHistories() {
        return rideHistories;
    }
}
