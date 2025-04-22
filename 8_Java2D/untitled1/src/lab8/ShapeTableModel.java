package lab8;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ShapeTableModel extends AbstractTableModel {
    private final String[] columns = {"Type", "X", "Y", "Color"};
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape s) {
        shapes.add(s);
        fireTableRowsInserted(shapes.size() - 1, shapes.size() - 1);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public int getRowCount() {
        return shapes.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Shape s = shapes.get(row);
        return switch (col) {
            case 0 -> s.getClass().getSimpleName();
            case 1 -> s.getX();
            case 2 -> s.getY();
            case 3 -> s.getColorHex();
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 1 || col == 2 || col == 3;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Shape s = shapes.get(row);
        try {
            if (col == 1 || col == 2) {
                int val = Integer.parseInt(value.toString());
                if (val < 0) return;
                if (col == 1) s.setX(val);
                if (col == 2) s.setY(val);
            } else if (col == 3) {
                String colorStr = value.toString().trim();
                if (!colorStr.startsWith("#")) colorStr = "#" + colorStr;
                s.setColor(colorStr);
            }
            fireTableCellUpdated(row, col);
            fireTableDataChanged();
        } catch (Exception e) {
            System.err.println("Błąd edycji: " + e.getMessage());
        }
    }


}
