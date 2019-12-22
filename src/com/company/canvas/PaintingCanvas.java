package com.company.canvas;

import com.company.tools.BaseTool;
import com.company.utils.State;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.*;

public class PaintingCanvas extends JPanel {

    private BaseTool selectedTool;
    private Vector<State> canvasState = new Vector<>();

    public PaintingCanvas() {
        this.initMouseListener();
        this.setVisible(true);
    }
    public PaintingCanvas(BaseTool tool) {
        this();
        this.setSelectedTool(tool);
    }

    public void setSelectedTool(BaseTool tool) {
        this.selectedTool = tool;
    }

    public void initMouseListener() {
        MouseAdapter mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                canvasState.add(new State(new Point(e.getX(), e.getY())));
                selectedTool.paint((Graphics2D)getGraphics(), canvasState.lastElement());
                System.out.println("debug: pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println("debug: released");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                canvasState.lastElement().push(new Point(e.getX(), e.getY()));
                selectedTool.paint((Graphics2D)getGraphics(), canvasState.lastElement());
                System.out.println("debug: dragged");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                System.out.println("debug: moved");
            }
        };
        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);
    }

    @Override
    protected void paintComponent(Graphics g) { //TODO override paint instead of paintComponent
        super.paintComponent(g);
        this.selectedTool.repaint((Graphics2D)g, this.canvasState);
    }
}
