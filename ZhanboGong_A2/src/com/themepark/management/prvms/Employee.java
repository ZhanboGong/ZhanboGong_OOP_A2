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
