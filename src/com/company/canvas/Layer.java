package com.company.canvas;

import com.company.utils.AbstractLayer;
import com.company.utils.State;
import com.company.utils.ToolUtils;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class Layer extends AbstractLayer {
    private Vector<State> layerState = new Vector<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        for(State stateToDraw : this.layerState) {
            stateToDraw.tool.repaint(g2d, stateToDraw);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Dimension drawingArea = PaintingCanvas.getDrawingAreaSize();
        if(drawingArea.height > 0 && drawingArea.width > 0) {
            this.layerState.add(new State(new Point(e.getX(), e.getY()), ToolUtils.getSelectedTool()));
            ToolUtils.getSelectedTool().paint((Graphics2D) this.getGraphics(), this.layerState.lastElement());
            System.out.println("debug: pressed");
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        Dimension drawingArea = PaintingCanvas.getDrawingAreaSize();
        if(drawingArea.height > 0 && drawingArea.width > 0) {
            System.out.println("debug: released");
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        Dimension drawingArea = PaintingCanvas.getDrawingAreaSize();
        if(drawingArea.height > 0 && drawingArea.width > 0) {
            this.layerState.lastElement().push(new Point(e.getX(), e.getY()));
            ToolUtils.getSelectedTool().paint((Graphics2D) this.getGraphics(), this.layerState.lastElement());
            System.out.println("debug: dragged");
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        Dimension drawingArea = PaintingCanvas.getDrawingAreaSize();
        if(drawingArea.height > 0 && drawingArea.width > 0) {
            System.out.println("debug: moved");
        }
    }
}
