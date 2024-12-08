package com.themepark.management.prvms;

import java.util.ArrayList;

public class Visitor extends Person{

    private String playStatus;
    private String ticketType;
    private final ArrayList<String> rideHistories = new ArrayList<>();
    private int playOfNumber = 1;

    public Visitor(){super();}
    public Visitor(int ID, String firstName, String lastName, String mobileNumber, String playStatus, String ticketType){
        super(ID, firstName, lastName, mobileNumber);
        this.playStatus = playStatus;
        this.ticketType = ticketType;
    }

    @Override
    public void printInformation(){
        System.out.println("================================");
        System.out.println("Visitor ID: " + ID);
        System.out.println("Visitor Name: " + firstName + " " + lastName);
        System.out.println("Contact: " + mobileNumber);
        System.out.println("Ticket Type: " + ticketType);
        System.out.println("Play Status: " + playStatus);
        System.out.println("================================");
    }

    public void personalHistory(String rideType){
        String personalRecord = playOfNumber++ + ":" + rideType;
        rideHistories.add(personalRecord);
        System.out.println("反馈");
    }

    // 可添加方法进行读取历史

    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        String playStatusRegex = "Leisure|On Queue|On Roller Coaster|On Thunder Storm";
        if(!playStatus.matches(playStatusRegex)){
            System.out.println("Wrong Input: The play status must be Leisure, On Queue, On Roller Coaster, or On Thunder Storm!");
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
        return playOfNumber - 1;
    }

    public void setPlayOfNumber(){
        this.playOfNumber++;
    }

    public ArrayList<String> getRideHistories() {
        return rideHistories;
    }
}
