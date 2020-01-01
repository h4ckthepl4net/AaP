package com.company.utils;

import com.company.tools.BaseTool;

import java.awt.*;
import java.util.Vector;

public class State {
    public Vector<Point> points = new Vector<>();
    public BaseTool tool;

    public State() {
        tool = ToolUtils.getSelectedTool();
    }
    public State(Point initialPoint, BaseTool tool) {
        this.points.add(initialPoint);
        this.tool = tool;
    }

    public int push(Point point) {
        this.points.add(point);
        return this.points.size();
    }

    public int size() {
        return this.points.size();
    }
    public Point firstPoint() {
        return this.points.firstElement();
    }
    public Point pointAtIndex(int ind) {
        return this.points.elementAt(ind);
    }
    public Point lastPoint() {
        return this.points.lastElement();
    }
}
