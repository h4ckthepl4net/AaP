package com.company.tools;

import java.awt.*;
import java.util.Vector;

import com.company.utils.State;

public abstract class BaseTool {
    protected int size = 1;

    public void setSize(int size) {
        this.size = size;
    }
    public abstract void paint(Graphics2D graphics2D, State stateToDraw);
    public abstract void repaint(Graphics2D graphics2D, Vector<State> stateToDraw);
}
