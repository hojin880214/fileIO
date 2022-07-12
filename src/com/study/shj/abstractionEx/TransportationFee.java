package com.study.shj.abstractionEx;

public class TransportationFee extends Student{

    int balanceTransportationExpenses;

    TransportationFee(String studentName, int balanceTransportationExpenses){
        super(studentName);
        this.balanceTransportationExpenses = balanceTransportationExpenses;
    }

    public void takeBus(Bus bus){
        bus.take(1000);
        this.balanceTransportationExpenses -= 1000;
    }

    public void takeSubway(Subway subway){
        subway.take(1500);
        this.balanceTransportationExpenses -= 1500;
    }

    @Override
    public void showInfo() {

        System.out.println(studentName + "님의 남은 돈은 " + balanceTransportationExpenses + "입니다.");

    }
}
