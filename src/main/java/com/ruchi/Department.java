package com.ruchi;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String departmentName;
    private List<Manager> departmentManagers;

    public Department(String name) {
        this.departmentName = name;
        this.departmentManagers = new ArrayList<>();
    }

    public void addManager(Manager manager) {
        departmentManagers.add(manager);
    }

    public int calculateDepartmentCost() {
        int sum = 0;
        for(Manager m: departmentManagers) {
            sum = sum + m.calculateCost();
        }
        return sum;
    }

    public List<String> findAnyManagerWithoutReportees() {
        List<String> managersWithoutReportees = new ArrayList<>();
        for(Manager m: departmentManagers) {
            managersWithoutReportees.addAll(m.anyManagerWithoutReportees());
        }
        return managersWithoutReportees;
    }
}
