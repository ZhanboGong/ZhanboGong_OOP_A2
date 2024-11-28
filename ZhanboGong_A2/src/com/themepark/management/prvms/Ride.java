package com.themepark.management.prvms;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface{
    // rollerCoaster carries 2 people at a time and enters history after playing, while thunderstorm carries 4 people at a time
    private String rideType;
    private Employee employee;
    private boolean operatingState;
    private Queue<Visitor> visitorsQueue;

    public Ride(){}
    public Ride(String rideType, Employee employee, boolean operatingState) {
        this.rideType = rideType;
        this.employee = employee;
        this.operatingState = operatingState;
        this.visitorsQueue = new LinkedList<>();
    }

    @Override
    public void addVisitorToQueue(Visitor visitor){}
    @Override
    public void removeVisitorFromQueue(){}
    @Override
    public void printQueue(){}
    @Override
    public void runOneCycle(){}
    @Override
    public void addVisitorToHistory(){}
    @Override
    public void addVisitorFromHistory(){}
    @Override
    public void checkVisitorFromHistory(){}
    @Override
    public void numberOfVisitors(){}
    @Override
    public void printRideHistory(){}

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isOperatingState() {
        return operatingState;
    }

    public void setOperatingState(boolean operatingState) {
        this.operatingState = operatingState;
    }

    public Queue<Visitor> getVisitorsQueue() {
        return visitorsQueue;
    }

    public void setVisitorsQueue(Queue<Visitor> visitorsQueue) {
        this.visitorsQueue = visitorsQueue;
    }
}
