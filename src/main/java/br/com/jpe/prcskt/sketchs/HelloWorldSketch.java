package br.com.jpe.prcskt.sketchs;

import processing.core.PApplet;

/**
 * Minimal example that draws a moving line
 */
public class HelloWorldSketch extends PApplet {

    private int y;

    @Override
    public void settings() {
        size(1024, 768);
    }

    @Override
    public void setup() {
        stroke(255);
        y = height / 2;
    }

    @Override
    public void draw() {
        // Draw background
        background(0);

        // Move line up (or wrap around the screen)
        y = y - 1;
        if (y < 0) {
            y = height;
        }

        // Draw line
        line(0, y, width, y);
    }

}