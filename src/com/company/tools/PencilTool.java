package com.company.tools;

import java.awt.*;
import java.util.Vector;

import com.company.utils.State;

public class PencilTool extends BaseTool {

    @Override
    public void paint(Graphics2D graphics2D, State stateToDraw) {
        if (stateToDraw.size() > 0) {
            this.configure(graphics2D);
            this.draw(graphics2D, stateToDraw);
        }
    }

    @Override
    public void repaint(Graphics2D graphics2D, Vector<State> stateArrayToDraw) {
        if (stateArrayToDraw.size() > 0) {
            this.configure(graphics2D);
            for(int i = 0, length = stateArrayToDraw.size(); i < length; i++) {
                this.redraw(graphics2D, stateArrayToDraw.elementAt(i));
            }
        }
    }

    @Override
    public void configure(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setStroke(new BasicStroke(this.size));
    }

    @Override
    protected void draw(Graphics2D graphics2D, State stateToDraw) {
        if(stateToDraw.size() == 1) {
            graphics2D.fillOval(stateToDraw.pointAtIndex(0).x-size/2, stateToDraw.pointAtIndex(0).y-size/2, size, size);
        } else {
            int pointCount = stateToDraw.size();
            graphics2D.drawLine(stateToDraw.pointAtIndex(pointCount-2).x, stateToDraw.pointAtIndex(pointCount-2).y,
                    stateToDraw.lastPoint().x, stateToDraw.lastPoint().y);
        }
    }

    @Override
    protected void redraw(Graphics2D graphics2D, State stateToDraw) {
        graphics2D.fillOval(stateToDraw.pointAtIndex(0).x - size / 2,
                            stateToDraw.pointAtIndex(0).y - size / 2,
                size, size);
        for (int j = 0, pointCount = stateToDraw.size() - 1; j < pointCount; j++) {
            graphics2D.drawLine(stateToDraw.pointAtIndex(j).x, stateToDraw.pointAtIndex(j).y,
                                stateToDraw.pointAtIndex(j + 1).x, stateToDraw.pointAtIndex(j + 1).y);
        }
    }

}
