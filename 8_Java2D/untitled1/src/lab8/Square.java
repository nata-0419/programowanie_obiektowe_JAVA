package lab8;

import java.awt.*;

public class Square extends Shape {
    private int size;

    public Square(int x, int y, String colorStr, int size) {
        super(x, y, colorStr);
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, size, size);
    }
}
