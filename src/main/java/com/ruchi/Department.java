package com.ruchi;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String departmentName;
    private List<Manager> departmentManagers;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.departmentManagers = new ArrayList<>();
    }

    public void addManager(Manager m) {
        departmentManagers.add(m);
    }

    public List<String> findAnyManagerWithoutReportees() {
        List<String> managersWithoutReportees = new ArrayList<>();
        for (Manager m : departmentManagers) {
            List<String> abc = m.managersWithoutReportees();
            managersWithoutReportees.addAll(abc);
        }
        return managersWithoutReportees;
    }

    public int calculateDepartmentCost() {
        int cost = 0;
        for (Manager m : departmentManagers) {
            cost = cost + m.calculateCost();
        }
        return cost;
    }

}
