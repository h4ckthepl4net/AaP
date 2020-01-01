package com.company.canvas;

import com.company.utils.ToolUtils;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

public class PaintingCanvas extends JPanel {

    private static Dimension drawingAreaSize = new Dimension(550, 550);
    private Vector<Layer> canvasLayers = new Vector<>();
    private Layer selectedLayer;

    public PaintingCanvas() {
        this.setLayout(null);
        this.setVisible(true);
    }
    public PaintingCanvas(String toolName) {
        this();
        ToolUtils.setSelectedTool(toolName);
    }

    public static void setDrawingAreaSize(Dimension size) {
        PaintingCanvas.drawingAreaSize = new Dimension(size);
    }
    public static void setDrawingAreaSize(int width, int height) {
        PaintingCanvas.drawingAreaSize = new Dimension(width, height);
    }
    public static Dimension getDrawingAreaSize() {return PaintingCanvas.drawingAreaSize;}

    public int addLayer() {
        Layer newLayer = new Layer();
        newLayer.setOpaque(false);
        newLayer.setSize(PaintingCanvas.drawingAreaSize);
        this.canvasLayers.add(newLayer);
        this.setSelectedLayer(newLayer);
        this.add(newLayer);
        return this.canvasLayers.size();
    }

    public int removeLayer() {
        return this.removeLayer(-1);
    }
    public int removeLayer(int ind) {
        if(ind < -1 || ind >= this.canvasLayers.size()) {
            throw new IllegalArgumentException("Exception in PaintingCanvas@removeLayer(): Layer index out of bounds");
        }
        if(ind == -1) {
            ind = this.canvasLayers.size() - 1;
        }
        this.canvasLayers.remove(ind);
        this.remove(ind);
        return this.canvasLayers.size();
    }

    public void setSelectedLayer(int ind) {
        this.setSelectedLayer(this.canvasLayers.get(ind));
    }
    public void setSelectedLayer(Layer newLayer) {
        if(this.selectedLayer != null) {
            this.removeMouseMotionListener(this.selectedLayer);
            this.removeMouseListener(this.selectedLayer);
        }
        this.addMouseMotionListener(newLayer);
        this.addMouseListener(newLayer);
        this.selectedLayer = newLayer;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Layer layer : this.canvasLayers) {
            layer.setSize(PaintingCanvas.drawingAreaSize);
        }
    }

}
