package com.themepark.management.prvms;

public abstract class Person {
    protected int ID;
    protected String firstName;
    protected String lastName;
    protected String mobileNumber;

    public Person(){}

    public Person(int ID, String firstName, String lastName, String mobileNumber) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }

    // Note: Use regular expressions to validate your data, and throw exceptions instead of printing them

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String firstNameRegex = "[A-Z][a-z]*";
        if(firstName == null || firstName.trim().isEmpty()){
            System.out.println("To be written...");
        } else if (!firstName.matches(firstNameRegex)) {
            System.out.println("The first name must begin with an uppercase letter and follow with a lowercase letter!");
        }
        else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        String lastNameRegex = "[A-Z][a-z]*";
        if(lastName == null || lastName.trim().isEmpty()){
            System.out.println("To be written...");
        } else if (!lastName.matches(lastNameRegex)) {
            System.out.println("The last name must begin with an uppercase letter and follow with a lowercase letter!");
        }
        else {
            this.lastName = lastName;
        }
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    //After searching on the Internet, the format of landline telephones in Australia is (0X) XXXX XXXX,
    // and the format of mobile telephones is 04XX XXX XXX,
    // so regular expressions are used to verify the data of the phone number entered or updated
    public void setMobileNumber(String mobileNumber) {
        String mobileRegex = "0\\d[ -]?\\d{2}[ -]?\\d{2}[ -]?\\d[ -]?\\d{3}";
        if(mobileNumber == null || mobileNumber.trim().isEmpty())
        {
            System.out.println("Wrong Input: Mobile number cannot be empty and null!");
        }
        else if (!mobileNumber.matches(mobileRegex)) {
            System.out.println("Wrong Input: Phone numbers are nine or ten digits long!");
        }
        else{
            this.mobileNumber = mobileNumber;
        }
    }
}
