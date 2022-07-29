package com.study.shj.swingExeEx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingEx{

    private JFrame frame;
    private JMenu fileMenu;

    public SwingEx(){
        initialize();
    }

    private void initialize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("비즈맵 Notepad");
        frame.setBounds(screenSize.width / 4, screenSize.height / 4, screenSize.width / 2, screenSize.height / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/favicon_lh.png")));

        JPanel menuPannel = new JPanel();
        FlowLayout fl_menuPannel = (FlowLayout) menuPannel.getLayout();
        fl_menuPannel.setHgap(0);
        fl_menuPannel.setVgap(0);
        fl_menuPannel.setAlignment(FlowLayout.LEFT);
        frame.getContentPane().add(menuPannel, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        menuPannel.add(menuBar);

        fileMenu = new JMenu("파일");
        menuBar.add(fileMenu);

        JMenuItem newFile = new JMenuItem("새 파일");
        fileMenu.add(newFile);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        JTextPane textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        tabbedPane.addTab("New tab", null, scrollPane, null);
        TextLineNumber tln = new TextLineNumber(textPane);
        scrollPane.setRowHeaderView( tln );

        frame.setVisible(true);
    }

}