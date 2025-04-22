package lab8;

import javax.swing.*;
import java.awt.*;

public class ShapeCanvas extends JPanel {
    private final ShapeTableModel model;

    public ShapeCanvas(ShapeTableModel model) {

        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape shape : model.getShapes()) {
            shape.draw(g2d);
        }
    }
}
