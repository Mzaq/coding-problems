package com.harish.CallCenter;

public class RespondentEmployee extends Employee {
    public RespondentEmployee (String name, int age) {
        super(name, age, Title.RESPONDENT);
    }

    public boolean passUpCall() {
        ManagerEmployee manager = CallCenter.getAvailableManager();

        if (manager == null) return false;
        manager.setCall(getCall());
        return true;
    }


}
