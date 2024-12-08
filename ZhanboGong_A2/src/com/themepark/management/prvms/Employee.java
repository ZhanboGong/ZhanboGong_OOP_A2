package com.themepark.management.prvms;

public class Employee extends Person{
    private String employeeType;

    private boolean workingStatus;
    public Employee(){super();}
    public Employee(int ID, String firstName, String lastName, String mobileNumber, String employeeType, boolean workingStatus){
        super(ID, firstName, lastName, mobileNumber);
        this.employeeType = employeeType;
        this.workingStatus = workingStatus;
    }

    @Override
    public void printInformation(){
        System.out.println("================================");
        System.out.println("ID: " + ID);
        System.out.println("Employee Name: " + firstName + " " + lastName);
        System.out.println("Contact: "+ mobileNumber);
        System.out.println("Employee Type: " + employeeType);
        System.out.println("Working Status: " + workingStatus);
        System.out.println("================================");
    }
    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public boolean isWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(boolean workingStatus) {
        this.workingStatus = workingStatus;
    }
}
