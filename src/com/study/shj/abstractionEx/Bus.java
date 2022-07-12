package com.study.shj.abstractionEx;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Bus extends Vehicle{

    private final int busNumber;

    @Override
    public void showInfo() {
        System.out.println("버스 " + busNumber + "번의 승객은 "
                + passengerCount + "명이고, 수입은 " + money +  "입니다.");
    }

}
