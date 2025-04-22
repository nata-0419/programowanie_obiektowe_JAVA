package lab8;

import java.awt.*;

public class Triangle extends Shape {
    private int size;

    public Triangle(int x, int y, String colorStr, int size) {
        super(x, y, colorStr);
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        int[] xPoints = {x, x + size / 2, x - size / 2};
        int[] yPoints = {y, y + size, y + size};
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}

