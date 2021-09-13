package br.com.jpe.prcskt.sketchs;

import processing.core.PApplet;

/**
 * Minimal example that draws a moving line
 */
public class LineDrawingAlgoritmsSketch extends PApplet {

    @Override
    public void settings() {
        size(1024, 768);
    }

    @Override
    public void setup() {
        stroke(255);
    }

    @Override
    public void draw() {
        // Draw background
        background(0);

        stroke(color(80, 32, 203)); // blue
        drawLineBresenham(10, 10, 100, 100);

        stroke(color(200, 80, 97)); // red
        drawLineDDA(60, 10, 160, 100);
    }

    void drawLineDDA(int x0, int y0, int x1, int y1) {
        int length;
        float xincrement;
        float yincrement;

        length = Math.abs(x1 - x0);
        if (Math.abs(y1 - y0) > length) {
            length = Math.abs(y1 - y0);
        }

        xincrement = (x1 - x0) / (float) length;
        yincrement = (y1 - y0) / (float) length;

        float x = x0, y = y0;
        for (int i = 1; i <= length; ++i) {
            point(x, y);
            x += xincrement;
            y += yincrement;
        }
    }

    void drawLineBresenham(int x1, int y1, int x2, int y2) {
        int dx, dy, p, p2, xy2, x, y, xf;
        dx = x2 - x1;
        dy = y2 - y1;
        p = 2 * dy - dx;
        p2 = 2 * dy;
        xy2 = 2 * (dy - dx);

        if (x1 > x2) {
            x = x2;
            y = y2;
            xf = x1;
        } else {
            x = x1;
            y = y1;
            xf = x2;
        }

        point(x, y);
        while (x < xf) {
            x++;
            if (p < 0) {
                p += p2;
            } else {
                y++;
                p += xy2;
            }
            point(x, y);
        }
    }

}