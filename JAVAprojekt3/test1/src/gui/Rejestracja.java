package gui;
import model.Uzytkownik;
import dao.UzytkownikDAO;
import baza.PolaczenieBazaDanych;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Rejestracja {

    public static boolean zarejestrujUzytkownika(String imie, String nazwisko, String nick, String haslo) {
        try (Connection polaczenie = PolaczenieBazaDanych.getPolaczenie()) {
            UzytkownikDAO uzytkownikDAO = new UzytkownikDAO(polaczenie);
            Uzytkownik nowyUzytkownik = new Uzytkownik(0, imie, nazwisko, nick, haslo);
            boolean sukces = uzytkownikDAO.utworzUzytkownika(nowyUzytkownik);
            return sukces;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd podczas rejestracji: " + e.getMessage(),
                    "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
