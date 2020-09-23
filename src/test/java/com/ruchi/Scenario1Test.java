package com.ruchi;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Scenario1Test {

    @Test
    public void test_scenario_1() {

        Employee dev1 = new Developer("Developer1");
        Employee qa1 = new QA("QA1");

        Manager managerB = new Manager("ManagerB");
        managerB.addReportee(dev1);
        managerB.addReportee(qa1);

        int managerBCost = managerB.calculateCost();
        assertEquals(3600, managerBCost);

        Manager managerA = new Manager("ManagerA");
        managerA.addReportee(managerB);

        int managerACost = managerA.calculateCost();
        assertEquals(4200, managerACost);

        Manager managerC = new Manager("ManagerC");
        Manager managerD = new Manager("ManagerD");
        managerC.addReportee(managerD);

        int managerCCost = managerC.calculateCost();
        assertEquals(1200, managerCCost);
        assertEquals(600, managerD.calculateCost());

        Employee dev2 = new Developer("Developer2");
        Manager managerE = new Manager("ManagerE");
        managerE.addReportee(dev2);

        int managerECost = managerE.calculateCost();
        assertEquals(2600, managerECost);

        Department departmentZ = new Department("Z");
        departmentZ.addManager(managerA);
        departmentZ.addManager(managerC);
        departmentZ.addManager(managerE);

        int departmentZCost = departmentZ.calculateDepartmentCost();
        assertEquals(8000, departmentZCost);

        List<String> managersWithoutReportees = new ArrayList<>();
        managersWithoutReportees.add(managerD.getName());

        assertEquals(managersWithoutReportees, departmentZ.findAnyManagerWithoutReportees());
    }
}
