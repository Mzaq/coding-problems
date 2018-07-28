package com.harish.CallCenter;

import java.util.ArrayList;
import java.util.EnumMap;

public class CallCenter {
    private static ArrayList<RespondentEmployee> respondentEmployees = new ArrayList<>();
    private static ArrayList<ManagerEmployee> managerEmployees = new ArrayList<>();
    //director list
    public Boolean handleCall(Call call) {
        for (RespondentEmployee employee : respondentEmployees) {
            if (employee.isAvailable()) {
                employee.setCall(call);
                return true;
            }
        }
        for (ManagerEmployee employee : managerEmployees) {
            if (employee.isAvailable()) {
                employee.setCall(call);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<ManagerEmployee> getManagerEmployees() {
        return managerEmployees;
    }

    public static ArrayList<RespondentEmployee> getRespondentEmployees() {
        return respondentEmployees;
    }

    public static ManagerEmployee getAvailableManager() {
        for (ManagerEmployee manager : managerEmployees) {
            if (manager.isAvailable()) {
                return manager;
            }
        }
        return null;
    }
}
