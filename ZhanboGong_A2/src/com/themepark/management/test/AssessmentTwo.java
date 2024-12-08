package com.themepark.management.test;

import com.themepark.management.prvms.Employee;
import com.themepark.management.prvms.Person;
import com.themepark.management.prvms.Ride;
import com.themepark.management.prvms.Visitor;

public class AssessmentTwo {
    public static void main(String[] args) {
        partSix();
    }
    public static void partThree(){
        Visitor visitor1 = new Visitor(1, "Zhanbo", "Gong", "1234567890", "Leisure", "Children");
        Visitor visitor2 = new Visitor(2, "Stephen", "Curry", "2233 223 223", "Leisure", "Adult");
        Visitor visitor3 = new Visitor(3, "Li", "Tian", "1123112312", "Leisure", "Adult");
        Visitor visitor4 = new Visitor(4, "Lionel", "Messi", "1145141234", "Leisure", "Adult");
        Visitor visitor5 = new Visitor(5, "JiaShuo", "Gao", "1122334455", "Leisure", "Elder");
        Employee employee1 = new Employee(11, "San", "Zhang", "5544332211", "Roller Coaster Operator", true);
        Ride ride1 = new Ride("Roller Coaster", employee1, true);
        ride1.addVisitorToQueue(visitor1);
        ride1.addVisitorToQueue(visitor2);
        ride1.addVisitorToQueue(visitor3);
        ride1.addVisitorToQueue(visitor4);
        ride1.addVisitorToQueue(visitor5);
        ride1.removeVisitorFromQueue();
        ride1.printQueue();

    }
    public static void partFourA(){
        Visitor visitor1 = new Visitor(1, "Zhanbo", "Gong", "1234567890", "Leisure", "Children");
        Visitor visitor2 = new Visitor(2, "Stephen", "Curry", "2233 223 223", "Leisure", "Adult");
        Visitor visitor3 = new Visitor(3, "Li", "Tian", "1123112312", "Leisure", "Adult");
        Visitor visitor4 = new Visitor(4, "Lionel", "Messi", "1145141234", "Leisure", "Adult");
        Visitor visitor5 = new Visitor(5, "JiaShuo", "Gao", "1122334455", "Leisure", "Elder");
        Employee employee1 = new Employee(11, "San", "Zhang", "5544332211", "Roller Coaster Operator", true);
        Ride ride1 = new Ride("Roller Coaster", employee1, true);
        ride1.addVisitorToHistory(visitor1);
        ride1.addVisitorToHistory(visitor2);
        ride1.addVisitorToHistory(visitor3);
        ride1.addVisitorToHistory(visitor4);
        ride1.addVisitorToHistory(visitor5);
        ride1.checkVisitorFromHistory(visitor1);
        ride1.printRideHistory();
    }
    public void partFourB(){
    }
    public void partFive(){
    }
    public static void partSix(){
        Visitor visitor1 = new Visitor(1, "Zhanbo", "Gong", "1234567890", "Leisure", "Children");
        Visitor visitor2 = new Visitor(2, "Stephen", "Curry", "2233 223 223", "Leisure", "Adult");
        Visitor visitor3 = new Visitor(3, "Li", "Tian", "1123112312", "Leisure", "Adult");
        Visitor visitor4 = new Visitor(4, "Lionel", "Messi", "1145141234", "Leisure", "Adult");
        Visitor visitor5 = new Visitor(5, "JiaShuo", "Gao", "1122334455", "Leisure", "Elder");
        Employee employee1 = new Employee(11, "San", "Zhang", "5544332211", "Roller Coaster Operator", true);
        Ride ride1 = new Ride("Roller Coaster", employee1, true);
        ride1.addVisitorToHistory(visitor1);
        ride1.addVisitorToHistory(visitor2);
        ride1.addVisitorToHistory(visitor3);
        ride1.addVisitorToHistory(visitor4);
        ride1.addVisitorToHistory(visitor5);
        ride1.exportRideHistory();
        ride1.importRideHistory();
    }
    public void partSeven(){
    }
}
