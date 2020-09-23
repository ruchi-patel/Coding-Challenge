package com.ruchi;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> listOfReportees;

    public Manager(String name) {
        super(600, name);
        this.listOfReportees = new ArrayList<>();
    }

}
