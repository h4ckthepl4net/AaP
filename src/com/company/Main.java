package com.company;

import java.awt.*;
import javax.swing.*;

import com.company.canvas.PaintingCanvas;
import com.company.tools.PencilTool;

public class Main {

    public static JFrame mainWindow = new JFrame();
    public static JPanel mainContent;

    public static void main(String[] args) {
	    // write your code here
        Main.mainWindow.setTitle("ain't a Paint");
        Main.mainWindow.setSize(1000, 500);
        Main.mainWindow.setMinimumSize(new Dimension(500, 500));
        Main.mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Main.mainContent = (JPanel) Main.mainWindow.getContentPane();
        Main.mainContent.add(new PaintingCanvas(new PencilTool()));
        Main.mainWindow.setVisible(true);
    }
}
