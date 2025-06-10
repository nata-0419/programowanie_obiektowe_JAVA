package gui;

import baza.PolaczenieBazaDanych;
import dao.CelDAO;
import model.Cel;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class FormularzCelu extends JDialog {
    private JTextField poleNazwa;
    private JTextField poleKategoria;
    private JTextArea poleOpis;
    private JTextField poleZdjecie;
    private JButton przyciskZatwierdz;
    private JButton przyciskAnuluj;

    private boolean zatwierdzono = false;
    private CelDAO celDAO;
    private Cel edytowanyCel;
    private int idUzytkownika;

    public FormularzCelu(Frame rodzic, Cel cel, int idUzytkownika) {
        super(rodzic, true);
        this.edytowanyCel = cel;
        this.idUzytkownika = idUzytkownika;

        setTitle(cel == null ? "Dodaj cel" : "Edytuj cel");
        setSize(500, 350);
        setLocationRelativeTo(rodzic);
        setLayout(new GridBagLayout());
        setResizable(false);

        try {
            Connection polaczenie = PolaczenieBazaDanych.getPolaczenie();
            celDAO = new CelDAO(polaczenie);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Błąd połączenia z bazą: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
            dispose();
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Nazwa:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        poleNazwa = new JTextField(25);
        add(poleNazwa, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Kategoria:"), gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        poleKategoria = new JTextField(25);
        add(poleKategoria, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Opis:"), gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        poleOpis = new JTextArea(5, 25);
        poleOpis.setLineWrap(true);
        poleOpis.setWrapStyleWord(true);
        JScrollPane scrollOpis = new JScrollPane(poleOpis);
        add(scrollOpis, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Zdjęcie (ścieżka):"), gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        poleZdjecie = new JTextField(25);
        add(poleZdjecie, gbc);

        JPanel panelPrzyciskow = new JPanel();
        przyciskZatwierdz = new JButton("Zatwierdź");
        przyciskAnuluj = new JButton("Anuluj");
        panelPrzyciskow.add(przyciskZatwierdz);
        panelPrzyciskow.add(przyciskAnuluj);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(panelPrzyciskow, gbc);

        if (cel != null) {
            poleNazwa.setText(cel.getNazwa());
            poleKategoria.setText(cel.getKategoria());
            poleOpis.setText(cel.getOpis());
            poleZdjecie.setText(cel.getZdjecie());
        }

        przyciskZatwierdz.addActionListener(e -> zatwierdz());
        przyciskAnuluj.addActionListener(e -> {
            zatwierdzono = false;
            dispose();
        });
    }

    private void zatwierdz() {
        String nazwa = poleNazwa.getText().trim();
        String kategoria = poleKategoria.getText().trim();
        String opis = poleOpis.getText().trim();
        String zdjecie = poleZdjecie.getText().trim();

        if (nazwa.isEmpty() || kategoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nazwa i kategoria są wymagane.", "Uwaga", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            if (edytowanyCel == null) {
                Cel nowyCel = new Cel(0, idUzytkownika, nazwa, kategoria, opis, zdjecie);
                celDAO.utworzCel(nowyCel);
            } else {
                edytowanyCel.setNazwa(nazwa);
                edytowanyCel.setKategoria(kategoria);
                edytowanyCel.setOpis(opis);
                edytowanyCel.setZdjecie(zdjecie);
                celDAO.aktualizujCel(edytowanyCel);
            }
            zatwierdzono = true;
            dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Błąd bazy danych: " + ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isZatwierdzono() {
        return zatwierdzono;
    }
}
