package gui;

import dao.UzytkownikDAO;
import model.Uzytkownik;
import baza.PolaczenieBazaDanych;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class OknoLogowania extends JFrame {

    private JTextField poleNick;
    private JPasswordField poleHaslo;

    public OknoLogowania() {
        setTitle("Logowanie");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labelNick = new JLabel("Nick:");
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        add(labelNick, gbc);

        poleNick = new JTextField(15);
        gbc.gridx = 1;
        add(poleNick, gbc);

        JLabel labelHaslo = new JLabel("Hasło:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(labelHaslo, gbc);

        poleHaslo = new JPasswordField(15);
        gbc.gridx = 1;
        add(poleHaslo, gbc);

        JButton przyciskZaloguj = new JButton("Zaloguj");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        add(przyciskZaloguj, gbc);

        przyciskZaloguj.addActionListener(this::zaloguj);

        JButton przyciskRejestracja = new JButton("Rejestracja");
        gbc.gridy = 3;
        add(przyciskRejestracja, gbc);

        przyciskRejestracja.addActionListener(e -> {
            dispose();
            OknoRejestracji oknoRejestracji = new OknoRejestracji();
            oknoRejestracji.setVisible(true);
        });
    }

    private void zaloguj(ActionEvent e) {
        String nick = poleNick.getText();
        String haslo = new String(poleHaslo.getPassword());

        if (nick.isEmpty() || haslo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Proszę wypełnić wszystkie pola.", "Błąd", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection polaczenie = PolaczenieBazaDanych.getPolaczenie()) {
            UzytkownikDAO uzytkownikDAO = new UzytkownikDAO(polaczenie);
            String hash = uzytkownikDAO.pobierzHaslo(nick);

            if (hash == null) {
                JOptionPane.showMessageDialog(this, "Nie znaleziono użytkownika.", "Błąd", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obsługa prefiksu $2y$ (jeśli występuje)
            if (hash.startsWith("$2y$")) {
                hash = "$2a$" + hash.substring(4);
            }

            if (BCrypt.checkpw(haslo, hash)) {
                Uzytkownik uzytkownik = uzytkownikDAO.pobierzUzytkownika(nick);
                if (uzytkownik != null) {
                    dispose();
                    OknoGlowne oknoGlowne = new OknoGlowne(uzytkownik);
                    oknoGlowne.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Błąd podczas pobierania danych użytkownika.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Niepoprawne hasło.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Błąd bazy danych: " + ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
