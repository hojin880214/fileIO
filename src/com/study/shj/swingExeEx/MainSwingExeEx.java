package com.study.shj.swingExeEx;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class MainSwingExeEx {

    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        }catch (Exception e){
            e.printStackTrace();
        }
        new BizMapDBFrame();

    }
}
