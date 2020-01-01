package com.company.tools;

import java.awt.*;

import com.company.utils.State;

public abstract class BaseTool {
    protected int size = 1;
    public String name;

    public BaseTool(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public abstract void paint(Graphics2D graphics2D, State stateToDraw);
    public abstract void repaint(Graphics2D graphics2D, State stateToDraw);
    protected abstract void configure(Graphics2D graphics2D);
    protected abstract void draw(Graphics2D graphics2D, State stateToDraw);
    protected abstract void redraw(Graphics2D graphics2D, State stateToDraw);
}
