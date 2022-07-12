package com.study.shj.abstractionEx;

public abstract class Student {

    String studentName;
    int grade;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public abstract void showInfo();

}
