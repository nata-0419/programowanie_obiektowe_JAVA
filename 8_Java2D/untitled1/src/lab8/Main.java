package lab8;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rysujemy figury");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            ShapeTableModel model = new ShapeTableModel();
            JTable table = new JTable(model);
            JScrollPane tableScroll = new JScrollPane(table);
            tableScroll.setPreferredSize(new Dimension(300, 150));

            ShapeCanvas canvas = new ShapeCanvas(model);
            model.addTableModelListener(e -> canvas.repaint());

            JPanel buttons = new JPanel();
            JButton addSquare = new JButton("Dodaj Kwadrat");
            JButton addCircle = new JButton("Dodaj Koło");
            JButton addTriangle = new JButton("Dodaj Trójkąt");

            addSquare.addActionListener(e -> {
                model.addShape(new Square(30, 30, "#FF0000", 50));
                canvas.repaint();
            });

            addCircle.addActionListener(e -> {
                model.addShape(new Circle(130, 100, "#0000FF", 50));
                canvas.repaint();
            });

            addTriangle.addActionListener(e -> {
                model.addShape(new Triangle(220, 70, "#00FF00", 60));
                canvas.repaint();
            });

            buttons.add(addSquare);
            buttons.add(addCircle);
            buttons.add(addTriangle);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tableScroll, canvas);
            splitPane.setResizeWeight(0.3);

            frame.add(splitPane, BorderLayout.CENTER);
            frame.add(buttons, BorderLayout.SOUTH);

            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
