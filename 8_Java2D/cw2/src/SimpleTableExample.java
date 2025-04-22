import javax.swing.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleTableExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple JTable Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Nagłówki i dane
            String[] columnNames = {"ID", "Name", "Height", "Birthday"};
            Object[][] data = {
                    {1, "Alice", 170, "April 12, 1982"},
                    {2, "Bob", 180, "August 23, 1987"},
                    {3, "Carol", 165, "March 3, 1991"}
            };

            // Model z możliwością edycji
            DefaultTableModel model = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return true; // Wszystkie komórki edytowalne
                }
            };

            JTable table = new JTable(model);
            table.setFillsViewportHeight(true);
            table.setAutoCreateRowSorter(true);

            // Szerokość pierwszej kolumny
            table.getColumnModel().getColumn(0).setPreferredWidth(100);

            // Własny renderer dla kolumny "Name"
            table.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());

            // Obsługa kliknięć myszką
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.rowAtPoint(e.getPoint());
                    int col = table.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        System.out.println("Clicked cell value: " + table.getValueAt(row, col));
                    }
                }
            });

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);

            frame.setSize(500, 200);
            frame.setVisible(true);
        });
    }
    // Prosty renderer: wyróżnij komórki w kolumnie "Name"
    static class CustomRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setForeground(Color.BLUE);
            return c;
        }
    }
}
