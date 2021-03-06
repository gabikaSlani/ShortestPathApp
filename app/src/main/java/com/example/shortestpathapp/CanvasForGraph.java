package com.example.shortestpathapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.shortestpathapp.graph.Edge;
import com.example.shortestpathapp.graph.Graph;
import com.example.shortestpathapp.graph.Node;

public class CanvasForGraph extends View {

    int START_X = 50;
    int START_Y = 50;
    Paint blackNoFillLightStroke;
    Paint blackNoFillHeavyStroke;
    Paint whiteFillPaint;

    public CanvasForGraph(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        blackNoFillLightStroke = new Paint();
        blackNoFillLightStroke.setColor(Color.BLACK);
        blackNoFillLightStroke.setTextSize(40);
        blackNoFillLightStroke.setStyle(Paint.Style.STROKE);

        blackNoFillHeavyStroke = new Paint();
        blackNoFillHeavyStroke.setColor(Color.BLACK);
        blackNoFillHeavyStroke.setStyle(Paint.Style.STROKE);
        blackNoFillHeavyStroke.setStrokeWidth(4);

        whiteFillPaint = new Paint();
        whiteFillPaint.setColor(Color.WHITE);
        whiteFillPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Graph graph = ((MainActivity)getContext()).getGraph();
        int lineGap = paintGrid(canvas, graph);
        paintEdges(canvas, graph, lineGap);
        paintNodes(canvas, graph, lineGap);
    }

    private int paintGrid(Canvas canvas, Graph graph) {
        int minX = (int) Math.floor(graph.getMinimalXPos());
        int maxX = (int) Math.ceil(graph.getMaximalXPos());
        int minY = (int) Math.floor(graph.getMinimalYPos());
        int maxY = (int) Math.ceil(graph.getMaximalYPos());

        // Y lines
        int endX = canvas.getWidth() - START_X;
        int xWidth = endX - START_X;
        int yLineCount = maxX - minX;
        int yLineGap = xWidth / yLineCount;
        for (int i = 0; i <= yLineCount; i++) {
            int x = START_X + (i * yLineGap);
            canvas.drawLine(x, 0, x, (maxY - minY + 1) * yLineGap, blackNoFillLightStroke);
        }

        // X lines
        int xLineCount = maxY - minY;
        for (int i = 0; i <= xLineCount; i++) {
            int y = START_Y + (i * yLineGap);
            canvas.drawLine(0, y, canvas.getWidth(), y, blackNoFillLightStroke);
        }
        return yLineGap;
    }

    private void paintNodes(Canvas canvas, Graph graph, int lineGap) {
        for (Node node : graph.getNodes()) {
            int r = 50;
            int x = (int) (node.getPos_x() * lineGap) + START_X;
            int y = (int) (node.getPos_y() * lineGap) + START_Y;
            RectF rectF = new RectF(x-r, y-r, x+r, y+r);
            canvas.drawOval(rectF, whiteFillPaint);
            canvas.drawOval(rectF, blackNoFillHeavyStroke);
            canvas.drawText(node.getName(), x - (r/4), y + (r/4), blackNoFillLightStroke);
        }
    }

    private void paintEdges(Canvas canvas, Graph graph, int lineGap) {
        for (Edge edge : graph.getEdges()) {
            Node node1 = edge.getNode1();
            Node node2 = edge.getNode2();
            int node1X = (int) (node1.getPos_x() * lineGap) + START_X;
            int node1Y = (int) (node1.getPos_y() * lineGap) + START_Y;
            int node2X = (int) (node2.getPos_x() * lineGap) + START_X;
            int node2Y = (int) (node2.getPos_y() * lineGap) + START_Y;
            canvas.drawLine(node1X, node1Y, node2X, node2Y, blackNoFillHeavyStroke);
            String cost = String.valueOf(edge.getCost());
            int centerX = (node1X + node2X) / 2;
            int centerY = (node1Y + node2Y) / 2;
            canvas.drawText(cost, centerX, centerY, blackNoFillLightStroke);
        }
    }
}
