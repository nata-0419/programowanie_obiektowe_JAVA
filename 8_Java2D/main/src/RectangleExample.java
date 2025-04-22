import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleExample extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D rectangle = new Rectangle2D.Double(0, 0, 200, 100);
        g2d.draw(rectangle);
    }
}