package gui;

import dao.UzytkownikDAO;
import model.Uzytkownik;
import baza.PolaczenieBazaDanych;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class OknoRejestracji extends JFrame {

    private JTextField poleImie;
    private JTextField poleNazwisko;
    private JTextField poleNick;
    private JPasswordField poleHaslo;

    public OknoRejestracji() {
        setTitle("Rejestracja");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labelImie = new JLabel("Imię:");
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        add(labelImie, gbc);

        poleImie = new JTextField(20);
        gbc.gridx = 1;
        add(poleImie, gbc);

        JLabel labelNazwisko = new JLabel("Nazwisko:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(labelNazwisko, gbc);

        poleNazwisko = new JTextField(20);
        gbc.gridx = 1;
        add(poleNazwisko, gbc);

        JLabel labelNick = new JLabel("Nick:");
        gbc.gridx = 0; gbc.gridy = 2;
        add(labelNick, gbc);

        poleNick = new JTextField(20);
        gbc.gridx = 1;
        add(poleNick, gbc);

        JLabel labelHaslo = new JLabel("Hasło:");
        gbc.gridx = 0; gbc.gridy = 3;
        add(labelHaslo, gbc);

        poleHaslo = new JPasswordField(20);
        gbc.gridx = 1;
        add(poleHaslo, gbc);

        JButton przyciskZarejestruj = new JButton("Zarejestruj");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        add(przyciskZarejestruj, gbc);

        przyciskZarejestruj.addActionListener(this::zarejestruj);

        JButton przyciskPowrot = new JButton("Powrót do logowania");
        gbc.gridy = 5;
        add(przyciskPowrot, gbc);

        przyciskPowrot.addActionListener(e -> {
            dispose();
            OknoLogowania oknoLogowania = new OknoLogowania();
            oknoLogowania.setVisible(true);
        });
    }

    private void zarejestruj(ActionEvent e) {
        String imie = poleImie.getText();
        String nazwisko = poleNazwisko.getText();
        String nick = poleNick.getText();
        String haslo = new String(poleHaslo.getPassword());

        if (imie.isEmpty() || nazwisko.isEmpty() || nick.isEmpty() || haslo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Proszę wypełnić wszystkie pola.", "Błąd", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection polaczenie = PolaczenieBazaDanych.getPolaczenie()) {
            UzytkownikDAO uzytkownikDAO = new UzytkownikDAO(polaczenie);

            Uzytkownik nowyUzytkownik = new Uzytkownik(0, imie, nazwisko, nick, haslo);
            boolean sukces = uzytkownikDAO.utworzUzytkownika(nowyUzytkownik);

            if (sukces) {
                JOptionPane.showMessageDialog(this, "Rejestracja zakończona sukcesem!");
                dispose();
                OknoLogowania oknoLogowania = new OknoLogowania();
                oknoLogowania.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Nie udało się zarejestrować użytkownika.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Błąd bazy danych: " + ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
