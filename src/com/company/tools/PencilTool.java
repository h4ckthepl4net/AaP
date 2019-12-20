package com.company.tools;

import java.awt.*;
import java.util.Vector;

import com.company.utils.State;

public class PencilTool extends BaseTool {
    @Override
    public void paint(Graphics2D graphics2D, State stateToDraw) {
        if (stateToDraw.size() > 0) {
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setStroke(new BasicStroke(this.size));
            if(stateToDraw.size() == 1) {
                graphics2D.fillOval(stateToDraw.pointAtIndex(0).x-size/2, stateToDraw.pointAtIndex(0).y-size/2, size, size);
            } else {
                int pointCount = stateToDraw.size();
                graphics2D.drawLine(stateToDraw.pointAtIndex(pointCount-2).x, stateToDraw.pointAtIndex(pointCount-2).y,
                                    stateToDraw.lastPoint().x, stateToDraw.lastPoint().y);
            }
        }
    }

    @Override
    public void repaint(Graphics2D graphics2D, Vector<State> stateArrayToDraw) {
        if (stateArrayToDraw.size() > 0) {
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setStroke(new BasicStroke(this.size));
            for(int i = 0, length = stateArrayToDraw.size(); i < length; i++) {
                State currentState = stateArrayToDraw.elementAt(i);
                graphics2D.fillOval(currentState.pointAtIndex(0).x - size / 2,
                                    currentState.pointAtIndex(0).y - size / 2,
                                        size, size);
                for (int j = 0, pointCount = currentState.size() - 1; j < pointCount; j++) {
                    graphics2D.drawLine(currentState.pointAtIndex(j).x, currentState.pointAtIndex(j).y,
                                        currentState.pointAtIndex(j + 1).x, currentState.pointAtIndex(j + 1).y);
                }
            }
        }
    }
}
