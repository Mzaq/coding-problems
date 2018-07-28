package com.harish.CallCenter;

public abstract class Employee {
    private String name;
    private int age;
    private Title title;
    private boolean available;
    private Call call;

    public Employee(String name, int age, Title title) {
        this.name = name;
        this.age = age;
        this.title = title;
        available = true;
        call = null;
    }

    public Employee() {

    }

    public boolean isAvailable() {
        return available;
    }

    public boolean setCall(Call call) {
        if (call != null || !available) {
            return false;
        }
        this.call = call;
        available = false;
        return true;
    }

    public void endCall() {
        call = null;
        available = true;
    }


    public Call getCall() {
        return call;
    }
}
