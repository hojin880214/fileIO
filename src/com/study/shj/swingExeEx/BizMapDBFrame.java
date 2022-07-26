package com.study.shj.swingExeEx;

import javax.swing.*;
import java.awt.*;

public class BizMapDBFrame extends JFrame {

    BizMapDBFrame(){
        super("비즈맵 DB작업툴");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds (screenSize.width / 4, screenSize.height / 4, screenSize.width / 2, screenSize.height / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/favicon_lh.png")));
        setVisible(true);
    }

}
