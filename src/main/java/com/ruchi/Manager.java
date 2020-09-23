package com.ruchi;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> listOfReportees;

    public Manager(String name) {
        super(600, name);
        this.listOfReportees = new ArrayList<>();
    }

    public void addReportee(Employee employee) {
        listOfReportees.add(employee);
    }

    public int calculateCost() {
        int sum = this.getSalary();
        for (Employee e : listOfReportees) {
            // if employee type is manager then get cost for manager then add
            // else do employee.getSalary
            if (e.getClass() == Manager.class) {
                // if (e instanceof Manager) {
                Manager m = (Manager) e;
                sum = sum + m.calculateCost();
            } else {
                sum = sum + e.getSalary();
            }
        }
        return sum;
    }

    public boolean hasReportees() {
        return this.listOfReportees.size() != 0;
    }

    public List<String> anyManagerWithoutReportees() {
        List<String> managersWithoutReportees = new ArrayList<>();
        if (this.listOfReportees.size() == 0) {
            managersWithoutReportees.add(this.getName());
        } else {
            for (Employee e : listOfReportees) {
                // if employee type is manager then get cost for manager then add
                // else do employee.getSalary
                if (e.getClass() == Manager.class) {
                    // if (e instanceof Manager) {
                    Manager m = (Manager) e;
                    managersWithoutReportees.addAll(m.anyManagerWithoutReportees());
                }
            }
        }
        return managersWithoutReportees;
    }

    public List<Employee> getListOfReportees() {
        return listOfReportees;
    }
}
