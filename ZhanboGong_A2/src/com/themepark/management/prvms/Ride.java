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
    private LinkedList<Visitor> rideVisitorHistory;


    public Ride(){}
    public Ride(String rideType, Employee employee, boolean operatingState) {
        this.rideType = rideType;
        this.employee = employee;
        this.operatingState = operatingState;
        this.visitorsQueue = new LinkedList<>();
        this.lastVisitors = new ArrayList<>();
        this.rideVisitorHistory = new LinkedList<>();
        if(rideType.equals("Roller Coaster")){
            this.setting = 2;
        }
        else if(rideType.equals("Thunder Storm")){
            this.setting = 4;
;        }
        else{
            System.out.println("反馈");
        }
    }

    @Override
    public void addVisitorToQueue(Visitor visitor){
        if (visitor != null){
            if(visitor.getPlayStatus().equals("Leisure"))
            {
                visitorsQueue.offer(visitor);
                visitor.setPlayStatus("On Queue");
            }
            else{
                System.out.println("The current status of the visitor is " + visitor.getPlayStatus() + ", unable to join queue!");
            }
        }
        else {
            System.out.println("The visitor object is null and cannot join the queue!");
        }
    }
    @Override
    public void removeVisitorFromQueue(){
        changeLastVisitors();
        // 后续添加对Queue中的人数进行判断
        for (int i = 0; i < setting; i++) {
            Visitor visitor = visitorsQueue.poll();
            if(visitor != null){
                if (setting == 4){
                    visitor.setPlayStatus("On Thunder Storm");
                }
                else {
                    visitor.setPlayStatus("On Roller Coaster");
                }
                visitor.personalHistory(rideType);
            }
            else {
                System.out.println("The visitor object is null and cannot be modified!");
            }
            lastVisitors.add(visitor);
        }
    }
    @Override
    public void printQueue(){
        if (visitorsQueue.isEmpty()){
            System.out.println("There are no visitors in the queue!");
        }
        else {
            for (Visitor visitor : visitorsQueue) {
                visitor.printInformation();
            }
        }
    }
    //maxRider就是我现在的Setting
    @Override
    public void runOneCycle(){}
    @Override
    public void addVisitorToHistory(Visitor visitor){
        if(visitor != null){
            rideVisitorHistory.add(visitor);
        }
        else {
            System.out.println("The visitor object is null and cannot be added to the history!");
        }
    }
    @Override
    public void checkVisitorFromHistory(Visitor visitor){
        if(visitor != null) {
            Iterator<Visitor> visitorIterator = rideVisitorHistory.iterator();
            while (visitorIterator.hasNext()){
                Visitor visitorHistory = visitorIterator.next();
                if (visitorHistory.equals(visitor)){
                    System.out.println("The visitor has been found with a total of " +
                            visitor.getPlayOfNumber() +
                            " visits. Please check the visitor's personal history for details.");
                    return;
                }
            }
            System.out.println("The visitor was not found!");
            return;
        }
        else {
            System.out.println("The visitor object is null and cannot be checked!");
        }
    }
    @Override
    public int numberOfVisitors(){
        return rideVisitorHistory.size();
    }
    @Override
    public void printRideHistory(){
        if (rideVisitorHistory.isEmpty()){
            System.out.println("The queue is empty!");
        }
        else {
            Iterator<Visitor> visitorIterator = rideVisitorHistory.iterator();
            System.out.println("---" + rideType + " Visiting History" + "---");
            while (visitorIterator.hasNext()){
                Visitor visitor = visitorIterator.next();
                visitor.printInformation();
            }
        }
    }

    private void changeLastVisitors(){
        for (Visitor lastVisitor : lastVisitors) {
            lastVisitor.setPlayStatus("Leisure");
        }
        lastVisitors.clear();
    }

    public void exportRideHistory(){

    }
    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        String rideTypeRegex = "Roller Coaster|Thunder Storm";
        if(!rideType.matches(rideTypeRegex)){
            System.out.println("Wrong Input: The ride status must be Roller Coaster and Thunder Storm!");
        }
        else {
            this.rideType = rideType;
        }
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
    public LinkedList<Visitor> getRideVisitorHistory(){return rideVisitorHistory;}
}
