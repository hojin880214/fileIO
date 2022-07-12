package com.study.shj.abstractionEx;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Subway extends Vehicle{

    private final String lineNumber;

    @Override
    public void showInfo() {
        System.out.println("지하철 " + lineNumber + "의 승객은 "
                + passengerCount + "명이고, 수입은 " + money +  "입니다.");
    }

}
