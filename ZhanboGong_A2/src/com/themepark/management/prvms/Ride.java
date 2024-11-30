package com.themepark.management.prvms;
import java.util.*;

public class Ride implements RideInterface{
    // rollerCoaster carries 2 people at a time and enters history after playing, while thunderstorm carries 4 people at a time
    private String rideType;
    private Employee employee;
    private boolean operatingState;
    private int setting;
    private Queue<Visitor> visitorsQueue;
    private ArrayList<Visitor> lastVisitors;


    public Ride(){}
    public Ride(String rideType, Employee employee, boolean operatingState) {
        this.rideType = rideType;
        setRideType(rideType);
        this.employee = employee;
        this.operatingState = operatingState;
        this.visitorsQueue = new LinkedList<>();
        this.lastVisitors = new ArrayList<>();
        if(rideType.equals("Roller Coaster")){
            this.setting = 2;
        }
        else if(rideType.equals("Thunder Storm")){
            this.setting = 4;
;        }
        else{
            System.out.println("--");
        }
    }

    @Override
    public void addVisitorToQueue(Visitor visitor){
        if(visitor.getPlayStatus().equals("Leisure"))
        {
            visitorsQueue.offer(visitor);
            visitor.setPlayStatus("On Queue");
        }
        else{
            System.out.println();
        }
    }
    @Override
    public void removeVisitorFromQueue(){
        changeLastVisitors();
        for (int i = 0; i < setting; i++) {
            Visitor visitor = visitorsQueue.poll();
            if(visitor != null){
                if (setting == 4){
                    visitor.setPlayStatus("On Thunder Storm");
                }
                else {
                    visitor.setPlayStatus("On Roller Coaster");
                }
            }
            else {
                System.out.println("--");
            }
            lastVisitors.add(visitor);
        }
    }
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

    private void changeLastVisitors(){
        for (Visitor lastVisitor : lastVisitors) {
            lastVisitor.setPlayStatus("Leisure");
        }
        lastVisitors.clear();
    }

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

    public int getSetting() {
        return setting;
    }

    public List<Visitor> getLastVisitors() {
        return lastVisitors;
    }
}
