package com.company;

import com.company.components.layout.AppMenuBar;

import java.awt.*;
import javax.swing.*;

public class Main {

    public static JFrame mainWindow = new JFrame();
    public static WindowContent contentLayout;

    public static void main(String[] args) {
	    // write your code here
        Main.initAndConfigureWindow();
        Main.initAndConfigureMenuBar();
        Main.initAndConfigureContent();
        Main.mainWindow.setVisible(true);
    }

    public static void initAndConfigureWindow() {
        Main.mainWindow.setTitle("ain't a Paint");
        Main.mainWindow.setSize(1000, 500);
        Main.mainWindow.setMinimumSize(new Dimension(500, 500));
        Main.mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void initAndConfigureMenuBar() {
        Main.mainWindow.setJMenuBar(new AppMenuBar());
    }

    public static void initAndConfigureContent() {
        JPanel contentPane = (JPanel) Main.mainWindow.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(Main.mainWindow.getWidth(), Main.mainWindow.getHeight()));

        Main.contentLayout = new WindowContent();
        Main.contentLayout.setSize(contentPane.getWidth(), contentPane.getHeight());
        contentPane.add(Main.contentLayout, BorderLayout.CENTER);
    }
}
