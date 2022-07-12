package com.study.shj.abstractionEx;

public abstract class Vehicle{

    int passengerCount;
    int money;

    public void take(int money){
        this.money += money;
        passengerCount++;
    }

    public abstract void showInfo();

}