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
        setRideType(rideType);
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
            System.out.println("--");
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
                System.out.println("反馈");
            }
        }
        else {
            System.out.println("反馈");
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
            // visitor.getRideHistories();
            lastVisitors.add(visitor);
        }
    }
    @Override
    public void printQueue(){}
    @Override
    public void runOneCycle(){}
    @Override
    public void addVisitorToHistory(Visitor visitor){
        //添加null检测以及反馈
        if(visitor != null){
            rideVisitorHistory.add(visitor);
        }
        else {
            System.out.println("到时候写反馈描述，可选择换成throw out");
        }
    }
    @Override
    public void checkVisitorFromHistory(Visitor visitor){
        //对visitor是否为空进行判断
        int historyCount = 0;
        Iterator<Visitor> visitorIterator = rideVisitorHistory.iterator();
        while (visitorIterator.hasNext()){
            Visitor visitorHistory = visitorIterator.next();
            if (visitorHistory.equals(visitor)){
                historyCount++;
            }
        }
        if (historyCount == 0){
            System.out.println("未找到");
        }
        else {
            System.out.println(historyCount);
        }
    }
    @Override
    public void numberOfVisitors(){
        //相同ID的游客只计数一次
    }
    @Override
    public void printRideHistory(){
        //相同ID的游客只计数一次
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
