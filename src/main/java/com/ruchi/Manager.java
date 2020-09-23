package com.ruchi;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> listOfReportees;

    public List<Employee> getListOfReportees() {
        return listOfReportees;
    }

    public Manager(String name) {
        super(600, name);
        this.listOfReportees = new ArrayList<>();
    }

    public void addReportee(Employee e) {
        listOfReportees.add(e);
    }

    public List<String> managersWithoutReportees() {
        List<String> managersWithoutReportees = new ArrayList<>();
        if (this.listOfReportees.size() == 0) {
            managersWithoutReportees.add(this.getName());
        } else {
            for (Employee m : listOfReportees) {
                if (m instanceof Manager) {
                    List<String> abc = ((Manager) m).managersWithoutReportees();
                    managersWithoutReportees.addAll(abc);
                }
            }
        }
        return managersWithoutReportees;
    }

    public int calculateCost() {
        int sum = 600;
        for (Employee e : listOfReportees) {
            if (e instanceof Manager) {
                sum = sum + ((Manager) e).calculateCost();
            } else {
                sum = sum + e.getSalary();
            }
        }
        return sum;
    }
}
