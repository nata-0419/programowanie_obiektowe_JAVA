import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RectangleExample());
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}