package com.themepark.management.prvms;
import java.io.*;
import java.util.*;

/**
 * The Ride class implements RideInterface and overrides its methods
 * The required attribute Settings in Assessment 2 are satisfied
 * It provides empty and parameter constructors, as well as getters and setters to validate and read data.
 * To make the logic even more logical, we add the changeLastVisitors method to manage the state of the previous round of visitors.
 */
public class Ride implements RideInterface{
    // rollerCoaster carries 2 people at a time and enters history after playing, while thunderstorm carries 4 people at a time
    private String rideType;
    private Employee employee;
    private boolean operatingState;
    private int maxRider;
    private int numOfCycles;
    private Set<Visitor> onRideVisitor;
    private Queue<Visitor> visitorsQueue;
    private LinkedList<Visitor> rideVisitorHistory;



    public Ride(){}
    public Ride(String rideType, Employee employee, boolean operatingState) {
        this.rideType = rideType;
        this.employee = employee;
        this.numOfCycles = 0;
        this.operatingState = operatingState;
        this.visitorsQueue = new LinkedList<>();
        this.rideVisitorHistory = new LinkedList<>();
        this.onRideVisitor = new LinkedHashSet<>();
        //判断是否type为null
        if(rideType.equals("Roller Coaster")){
            this.maxRider = 2;
        }
        else if(rideType.equals("Thunder Storm")){
            this.maxRider = 4;
;        }
        else{
            System.out.println("A Ride containing the number of seats was not found!");
        }
    }

    /**
     * Override the addVisitorToQueue method in the RideInterface
     * Main function 1: visitor objects that are not null are added to the queue
     * Main function 2: Modify the current tourist status to facilitate subsequent management
     * Main function 3: Print suitable success/failure messages.
     * @param visitor: Object Visitor to be added to the queue
     */
    @Override
    public void addVisitorToQueue(Visitor visitor){
        if (visitor != null){
            if(visitor.getPlayStatus().equals("Leisure"))
            {
                visitorsQueue.offer(visitor);
                visitor.setPlayStatus("On Queue");
                System.out.println("Visitor " + visitor.getFirstName() + " is successfully added to the queue!");
            }
            else{
                System.out.println("The current status of the visitor is " + visitor.getPlayStatus() + ", unable to join queue!");
            }
        }
        else {
            System.out.println("The visitor object is null and cannot join the queue!");
        }
    }

    /**
     * Override the removeVisitorFromQueue method in the RideInterface
     * Main function 1: The relationship between the actual tourists in the queue and maxRider is judged to ensure that when the number of tourists in the queue is less than maxRider, the Ride can also run normally.
     * Main function 2: Remove Visitor from the queue
     * Main function 3: Modify the status of the visitor, easy to manage
     */
    @Override
    public void removeVisitorFromQueue(){
        int actualRiders = visitorsQueue.size();
        if (actualRiders > maxRider){
            actualRiders = maxRider;
        }
        for (int i = 0; i < actualRiders; i++) {
            Visitor visitor = visitorsQueue.poll();
            if(visitor != null){
                visitor.setPlayStatus("On " + rideType);
                visitor.personalHistory(rideType);
                onRideVisitor.add(visitor);
                addVisitorToHistory(visitor);
            }
            else {
                System.out.println("The visitor object is null and cannot be modified!");
            }
        }
    }

    /**
     * Override the printQueue method in the RideInterface
     * Main function 1: Loop through the Queue and print information about the visitor
     */
    @Override
    public void printQueue(){
        if (visitorsQueue.isEmpty()){
            System.out.println("There are no visitors in the queue!");
        }
        else {
            System.out.println("=============Start printing=============");
            for (Visitor visitor : visitorsQueue) {
                visitor.printInformation();
            }
            System.out.println("=============End of print=============");
        }
    }

    /**
     * Override the printQueue method in the RideInterface
     * Main function 1: The status of the operator currently riding is detected
     * Main function 2: Make a run of Ride using the relevant method
     */
    @Override
    public void runOneCycle(){
        if (employee == null || !employee.getEmployeeType().equals(rideType + " Operator") || !employee.isWorkingStatus()){
            System.out.println("The Ride cannot be run without an operator!");
            return;
        }
        if (visitorsQueue.isEmpty()){
            System.out.println("No one is currently queuing, so the Ride cannot run!");
            return;
        }
        changeLastVisitors();
        removeVisitorFromQueue();
        numOfCycles++;
    }

    /**
     * Override the addVisitorToHistory method in the RideInterface
     * Main function 1: Checks whether the visitor has been included in the history and is null
     * Main function 2: Add the visitor to the history
     * @param visitor: visitor to be added to the history
     */
    @Override
    public void addVisitorToHistory(Visitor visitor){
        if(visitor != null){
            if (rideVisitorHistory.contains(visitor)){
                System.out.println("The visitor is already included in the history.");
                return;
            }
            rideVisitorHistory.add(visitor);
            System.out.println("Visitor " + visitor.getFirstName() + " added successfully!");
        }
        else {
            System.out.println("The visitor object is null and cannot be added to the history!");
        }
    }

    /**
     * Override the checkVisitorFromHistory method in the RideInterface
     * Main function 1: The visitor that contains the input is detected from the history.
     * @param visitor: Visitor that need to be checked from the history
     */
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
        }
        else {
            System.out.println("The visitor object is null and cannot be checked!");
        }
    }

    /**
     * Override the numberOfVisitors method in the RideInterface
     * Main function 1: Returns the number of visitors in the history
     * @return The length of the LinkedList, that is, the number of visitors in the History.
     */
    @Override
    public int numberOfVisitors(){
        if (rideVisitorHistory == null){
            System.out.println("The history is null!");
            return 0;
        }
        return rideVisitorHistory.size();
    }

    /**
     * Override the printRideHistory method in the RideInterface
     * Main function 1: Check whether rideVisitorHistory is not null or empty.
     * Main function 2: Use iterator to print the history
     */
    @Override
    public void printRideHistory(){
        if (rideVisitorHistory == null || rideVisitorHistory.isEmpty()){
            System.out.println("The history is null or empty!");
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

    /**
     * The method outside the assignment requirement is used to modify the state of a visitor after riding the Ride
     */
    private void changeLastVisitors(){
        for (Visitor lastVisitor : onRideVisitor) {
            lastVisitor.setPlayStatus("Leisure");
        }
        onRideVisitor.clear();
    }

    /**
     * The visitor information in the history is exported and stored in a CSV file
     * The exported information is the visitor's current ID, Name, Ticket Type and current status
     * Export the files to the backup package for easier management
     */
    public void exportRideHistory(){
        String rideHistoryFilePath = "ZhanboGong_OOP_A2/ZhanboGong_A2/src/com/themepark/management/backup/rideHistory.csv";
        File file = new File(rideHistoryFilePath);
        try (FileWriter writer = new FileWriter(rideHistoryFilePath, true)) {
            if (file.length() == 0){
                writer.append("ID, Name, Ticket Type, Play Status\n");
            }
            for (Visitor visitor : rideVisitorHistory){
                writer.append(String.valueOf(visitor.getID())).append(", ")
                        .append(visitor.getFirstName()).append(" ").append(visitor.getLastName()).append(", ")
                        .append(visitor.getTicketType()).append(", ")
                        .append(visitor.getPlayStatus()).append("\n");
            }
            System.out.println("The history export was successful!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     *
     */
    public void importRideHistory() {
        String rideHistoryFilePath = "ZhanboGong_OOP_A2/ZhanboGong_A2/src/com/themepark/management/backup/rideHistory.csv";
        File file = new File(rideHistoryFilePath);
        if (file.length() == 0 || !file.exists()) {
            System.out.println("The file does not exist or is empty and cannot be read!");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(rideHistoryFilePath))) {
            String lineRecord;
            reader.readLine();
            while ((lineRecord = reader.readLine()) != null) {
                String[] columns = lineRecord.split(",");
                if (columns.length == 4){
                    System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Ticket Type: " + columns[2] + ", Play Status: " + columns[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // These are all getters and setters, some of which require data validation using regular expressions
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


    public int getMaxRider() {
        return maxRider;
    }


    public LinkedList<Visitor> getRideVisitorHistory(){return rideVisitorHistory;}

    public int getNumOfCycles() {
        return numOfCycles;
    }


}
