package gui;

import baza.PolaczenieBazaDanych;
import dao.ZadanieDAO;
import model.Zadanie;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class FormularzZadania extends JDialog {
    private JTextField poleNazwa;
    private JTextField polePriorytet;
    private JTextField poleKategoria;
    private JButton przyciskZatwierdz;
    private JButton przyciskAnuluj;

    private boolean zatwierdzono = false;
    private ZadanieDAO zadanieDAO;
    private Zadanie edytowaneZadanie;
    private int idUzytkownika;

    public FormularzZadania(Frame rodzic, Zadanie zadanie, int idUzytkownika) {
        super(rodzic, true);
        this.edytowaneZadanie = zadanie;
        this.idUzytkownika = idUzytkownika;

        setTitle(zadanie == null ? "Dodaj zadanie" : "Edytuj zadanie");
        setSize(400, 250);
        setLocationRelativeTo(rodzic);
        setLayout(new GridLayout(5, 2, 10, 10));
        setResizable(false);

        try {
            Connection polaczenie = PolaczenieBazaDanych.getPolaczenie();
            zadanieDAO = new ZadanieDAO(polaczenie);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Błąd połączenia z bazą: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
            dispose();
        }

        add(new JLabel("Nazwa:"));
        poleNazwa = new JTextField();
        add(poleNazwa);

        add(new JLabel("Priorytet (liczba):"));
        polePriorytet = new JTextField();
        add(polePriorytet);

        add(new JLabel("Kategoria:"));
        poleKategoria = new JTextField();
        add(poleKategoria);

        przyciskZatwierdz = new JButton("Zatwierdź");
        przyciskAnuluj = new JButton("Anuluj");

        add(przyciskZatwierdz);
        add(przyciskAnuluj);

        if (zadanie != null) {
            poleNazwa.setText(zadanie.getNazwa());
            polePriorytet.setText(String.valueOf(zadanie.getPriorytet()));
            poleKategoria.setText(zadanie.getKategoria());
        }

        przyciskZatwierdz.addActionListener(e -> zatwierdz());
        przyciskAnuluj.addActionListener(e -> {
            zatwierdzono = false;
            dispose();
        });
    }

    private void zatwierdz() {
        String nazwa = poleNazwa.getText().trim();
        String priorytetStr = polePriorytet.getText().trim();
        String kategoria = poleKategoria.getText().trim();

        if (nazwa.isEmpty() || priorytetStr.isEmpty() || kategoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Wypełnij wszystkie pola.", "Uwaga", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int priorytet;
        try {
            priorytet = Integer.parseInt(priorytetStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Priorytet musi być liczbą całkowitą.", "Uwaga", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            if (edytowaneZadanie == null) {
                Zadanie noweZadanie = new Zadanie(0, idUzytkownika, nazwa, priorytet, kategoria);
                zadanieDAO.utworzZadanie(noweZadanie);
            } else {
                edytowaneZadanie.setNazwa(nazwa);
                edytowaneZadanie.setPriorytet(priorytet);
                edytowaneZadanie.setKategoria(kategoria);
                zadanieDAO.aktualizujZadanie(edytowaneZadanie);
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
