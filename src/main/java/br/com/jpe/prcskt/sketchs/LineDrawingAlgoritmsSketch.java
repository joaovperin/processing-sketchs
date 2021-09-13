package br.com.jpe.prcskt.sketchs;

import processing.core.PApplet;

/**
 * Minimal example that draws a moving line
 */
public class LineDrawingAlgoritmsSketch extends PApplet {

    private static final int SIZE_X = 1024;
    private static final int SIZE_Y = 768;

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

    void drawLineBresenham(int x0, int y0, int x1, int y1) {
        int x, y;
        int dx, dy;
        int incx, incy;
        int balance;

        if (x1 >= x0) {
            dx = x1 - x0;
            incx = 1;
        } else {
            dx = x0 - x1;
            incx = -1;
        }

        if (y1 >= y0) {
            dy = y1 - y0;
            incy = 1;
        } else {
            dy = y0 - y1;
            incy = -1;
        }

        x = x0;
        y = y0;

        if (dx >= dy) {
            dy <<= 1;
            balance = dy - dx;
            dx <<= 1;

            while (x != x1) {
                point((int) x, (int) y);
                if (balance >= 0) {
                    y += incy;
                    balance -= dx;
                }
                balance += dy;
                x += incx;
            }
            point((int) x, (int) y);
        } else {
            dx <<= 1;
            balance = dx - dy;
            dy <<= 1;

            while (y != y1) {
                point(x, y);
                if (balance >= 0) {
                    x += incx;
                    balance -= dy;
                }
                balance += dx;
                y += incy;
            }
            point(x, y);
        }

    }

}