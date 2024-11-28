package com.themepark.management.entity;

public interface RideInterface {

    public void addVisitorToQueue();
    public void removeVisitorFromQueue();
    public void printQueue();
    public void runOneCycle();
    public void addVisitorToHistory();
    public void addVisitorFromHistory();
    public void checkVisitorFromHistory();
    public void numberOfVisitors();
    public void printRideHistory();
}
