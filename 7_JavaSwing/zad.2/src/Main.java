import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame lista = new JFrame("Moja Lista zadań");
        lista.setSize(400, 200);
        lista.setLayout(new BorderLayout(5, 5));

        DefaultListModel<String> zadania = new DefaultListModel<>();
        zadania.addElement("Kup mleko");
        zadania.addElement("Odebrać paczkę");
        zadania.addElement("Wyprowadzić psa");

        JList<String> zadaniaLista = new JList<>(zadania);
        JScrollPane scrollPane = new JScrollPane(zadaniaLista);

        JButton dodajButton = new JButton("Dodaj");
        JButton usunButton = new JButton("Usuń zaznaczony element");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(dodajButton);
        buttonPanel.add(usunButton);

        lista.add(scrollPane, BorderLayout.CENTER);
        lista.add(buttonPanel, BorderLayout.SOUTH);

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTask = JOptionPane.showInputDialog(lista, "Wprowadź nowe zadanie:");
                if (newTask != null && !newTask.trim().isEmpty()) {
                    zadania.addElement(newTask.trim());
                }
            }
        });

        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = zadaniaLista.getSelectedValue();
                if (selected != null) {
                    zadania.removeElement(selected);
                } else {
                    JOptionPane.showMessageDialog(lista, "Nie wybrano żadnego zadania!", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        lista.setLocationRelativeTo(null);
        lista.setVisible(true);
    }
}