package lab8;

import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, String colorStr, int radius) {
        super(x, y, colorStr);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(x, y, radius, radius);
    }
}
