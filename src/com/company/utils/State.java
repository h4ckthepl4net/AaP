package com.company.utils;

import java.awt.*;
import java.util.Vector;

public class State {
    public Vector<Point> points = new Vector<>();

    public State() {}
    public State(Point initialPoint) {
        this.points.add(initialPoint);
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
