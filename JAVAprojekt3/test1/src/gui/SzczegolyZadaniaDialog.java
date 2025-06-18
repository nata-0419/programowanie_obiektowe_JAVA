package gui;

import model.Zadanie;
import model.SzczegolyZadania;

import javax.swing.*;
import java.awt.*;

public class SzczegolyZadaniaDialog extends JDialog {
    public SzczegolyZadaniaDialog(Frame rodzic, Zadanie zadanie, SzczegolyZadania szczegoly) {
        super(rodzic, "Szczegóły zadania", true);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;

        add(new JLabel("Nazwa:"), gbc);
        gbc.gridx = 1;
        add(new JLabel(zadanie.getNazwa()), gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Priorytet:"), gbc);
        gbc.gridx = 1;
        add(new JLabel(String.valueOf(zadanie.getPriorytet())), gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Kategoria:"), gbc);
        gbc.gridx = 1;
        add(new JLabel(zadanie.getKategoria()), gbc);

        if (szczegoly != null) {
            gbc.gridx = 0; gbc.gridy++;
            add(new JLabel("Data:"), gbc);
            gbc.gridx = 1;
            add(new JLabel(szczegoly.getData().toString()), gbc);

            gbc.gridx = 0; gbc.gridy++;
            add(new JLabel("Godzina:"), gbc);
            gbc.gridx = 1;
            add(new JLabel(szczegoly.getGodzina().toString()), gbc);

            gbc.gridx = 0; gbc.gridy++;
            add(new JLabel("Stan realizacji:"), gbc);
            gbc.gridx = 1;
            add(new JLabel(szczegoly.getStanRealizacji()), gbc);

            gbc.gridx = 0; gbc.gridy++;
            add(new JLabel("Szczegóły:"), gbc);
            gbc.gridx = 1;
            JTextArea szczegolyArea = new JTextArea(szczegoly.getSzczegoly());
            szczegolyArea.setEditable(false);
            szczegolyArea.setLineWrap(true);
            szczegolyArea.setWrapStyleWord(true);
            JScrollPane scroll = new JScrollPane(szczegolyArea);
            scroll.setPreferredSize(new Dimension(250, 100));
            add(scroll, gbc);
        }

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton przyciskZamknij = new JButton("Zamknij");
        przyciskZamknij.addActionListener(e -> dispose());
        add(przyciskZamknij, gbc);

        setSize(400, 400);
        setLocationRelativeTo(rodzic);
    }
}
