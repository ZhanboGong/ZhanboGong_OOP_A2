package com.themepark.management.prvms;

public interface RideInterface {

    public void addVisitorToQueue(Visitor visitor);
    public void removeVisitorFromQueue();
    public void printQueue();
    public void runOneCycle();
    public void addVisitorToHistory();
    public void addVisitorFromHistory();
    public void checkVisitorFromHistory();
    public void numberOfVisitors();
    public void printRideHistory();
}