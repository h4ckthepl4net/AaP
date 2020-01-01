package com.company;

import com.company.canvas.PaintingCanvas;

import javax.swing.*;
import java.awt.*;

public class WindowContent extends JPanel {
    private JPanel header, leftSideBar, drawingArea, rightSideBar, footer;
    private PaintingCanvas canvas;

    public WindowContent() {
        this.setLayout(new BorderLayout());
        this.initHeader();
        this.initLeftSideBar();
        this.initDrawingArea();
        this.initRightSideBar();
        this.initFooter();
    }

    private void initHeader() {
        this.header = new JPanel();
        this.header.setLayout(new BoxLayout(this.header, BoxLayout.LINE_AXIS));
        this.header.setBackground(new Color(194, 194, 194));
        this.header.add(new JButton("as"));
        this.add(this.header, BorderLayout.PAGE_START);
    }
    private void initLeftSideBar() {
        this.leftSideBar = new JPanel();
        this.leftSideBar.setLayout(new BoxLayout(this.leftSideBar, BoxLayout.PAGE_AXIS));
        this.leftSideBar.setBackground(new Color(194, 194, 194));
        this.leftSideBar.add(new JButton("as"));
        this.add(this.leftSideBar, BorderLayout.LINE_START);
    }
    private void initDrawingArea() {
        this.drawingArea = new JPanel();
        this.drawingArea.setLayout(new BoxLayout(this.drawingArea, BoxLayout.LINE_AXIS));
        this.drawingArea.setBackground(new Color(128, 128,128));
        this.canvas = new PaintingCanvas("pencil");
        this.canvas.addLayer();
        this.drawingArea.add(this.canvas);
        this.add(this.drawingArea, BorderLayout.CENTER);
    }
    private void initRightSideBar() {
        this.rightSideBar = new JPanel();
        this.rightSideBar.setLayout(new BoxLayout(this.rightSideBar, BoxLayout.PAGE_AXIS));
        this.rightSideBar.setBackground(new Color(194, 194, 194));
        this.rightSideBar.add(new JButton("as"));
        this.add(this.rightSideBar, BorderLayout.LINE_END);
    }
    private void initFooter() {
        this.footer = new JPanel();
        this.footer.setLayout(new BoxLayout(this.footer, BoxLayout.LINE_AXIS));
        this.footer.setBackground(new Color(194, 194, 194));
        this.footer.add(new JButton("as"));
        this.add(this.footer, BorderLayout.PAGE_END);
    }
}
