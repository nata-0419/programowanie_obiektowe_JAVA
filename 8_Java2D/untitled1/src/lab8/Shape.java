package lab8;

import java.awt.*;

public abstract class Shape {
    protected int x, y;
    protected Color color;

    public Shape(int x, int y, String colorStr) {
        this.x = x;
        this.y = y;
        this.color = Color.decode(colorStr);
    }

    public void setColor(String colorStr) {
        try {
            this.color = Color.decode(colorStr);
        } catch (NumberFormatException e) {
            System.err.println("Niepoprawny format koloru: " + colorStr);
        }
    }

    public abstract void draw(Graphics2D g2d);

    public int getX() { return x; }
    public int getY() { return y; }
    public String getColorHex() {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}
