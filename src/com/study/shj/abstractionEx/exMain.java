package com.study.shj.abstractionEx;

public class exMain {

    public static void main(String[] args) {

        TransportationFee studentJames = new TransportationFee("James", 5000);
        TransportationFee studentTomas = new TransportationFee("Tomas", 10000);

        Bus bus100 = new Bus(100);
        studentJames.takeBus(bus100);
        studentJames.showInfo();
        bus100.showInfo();

        Subway subwayGreen = new Subway("2호선");
        studentTomas.takeSubway(subwayGreen);
        studentTomas.showInfo();
        studentTomas.takeSubway(subwayGreen);
        studentTomas.showInfo();
        subwayGreen.showInfo();

    }

}
