package gui;

import baza.PolaczenieBazaDanych;
import dao.CelDAO;
import dao.SzczegolyCeluDAO;
import dao.SzczegolyZadaniaDAO;
import dao.ZadanieDAO;
import model.Cel;
import model.Uzytkownik;
import model.Zadanie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OknoGlowne extends JFrame {
    private Uzytkownik zalogowanyUzytkownik;

    private ZadanieDAO zadanieDAO;
    private SzczegolyZadaniaDAO szczegolyZadaniaDAO;
    private CelDAO celDAO;
    private SzczegolyCeluDAO szczegolyCeluDAO;

    private JTable tabelaZadan;
    private DefaultTableModel modelZadan;

    private JTable tabelaCelow;
    private DefaultTableModel modelCelow;

    public OknoGlowne(Uzytkownik uzytkownik) {
        this.zalogowanyUzytkownik = uzytkownik;

        setTitle("Harmonogram - " + uzytkownik.getNick());
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Connection polaczenie = null;
        try {
            polaczenie = PolaczenieBazaDanych.getPolaczenie();
            zadanieDAO = new ZadanieDAO(polaczenie);
            szczegolyZadaniaDAO = new SzczegolyZadaniaDAO(polaczenie);
            celDAO = new CelDAO(polaczenie);
            szczegolyCeluDAO = new SzczegolyCeluDAO(polaczenie);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Błąd połączenia z bazą: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        JTabbedPane zakladki = new JTabbedPane();

        zakladki.add("Zadania", stworzPanelZadan());
        zakladki.add("Cele", stworzPanelCelow());

        add(zakladki, BorderLayout.CENTER);

        odswiezListeZadan();
        odswiezListeCelow();
    }

    private JPanel stworzPanelZadan() {
        JPanel panel = new JPanel(new BorderLayout());

        modelZadan = new DefaultTableModel(new String[]{"ID", "Nazwa", "Priorytet", "Kategoria"}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaZadan = new JTable(modelZadan);
        tabelaZadan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(tabelaZadan);
        panel.add(scroll, BorderLayout.CENTER);

        JPanel panelPrzyciskow = new JPanel();
        JButton btnDodaj = new JButton("Dodaj");
        JButton btnEdytuj = new JButton("Edytuj");
        JButton btnUsun = new JButton("Usuń");

        panelPrzyciskow.add(btnDodaj);
        panelPrzyciskow.add(btnEdytuj);
        panelPrzyciskow.add(btnUsun);

        panel.add(panelPrzyciskow, BorderLayout.SOUTH);

        btnDodaj.addActionListener(e -> dodajZadanie());
        btnEdytuj.addActionListener(e -> edytujZadanie());
        btnUsun.addActionListener(e -> usunZadanie());

        return panel;
    }

    private JPanel stworzPanelCelow() {
        JPanel panel = new JPanel(new BorderLayout());

        modelCelow = new DefaultTableModel(new String[]{"ID", "Nazwa", "Kategoria", "Opis"}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaCelow = new JTable(modelCelow);
        tabelaCelow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(tabelaCelow);
        panel.add(scroll, BorderLayout.CENTER);

        JPanel panelPrzyciskow = new JPanel();
        JButton btnDodaj = new JButton("Dodaj");
        JButton btnEdytuj = new JButton("Edytuj");
        JButton btnUsun = new JButton("Usuń");

        panelPrzyciskow.add(btnDodaj);
        panelPrzyciskow.add(btnEdytuj);
        panelPrzyciskow.add(btnUsun);

        panel.add(panelPrzyciskow, BorderLayout.SOUTH);

        btnDodaj.addActionListener(e -> dodajCel());
        btnEdytuj.addActionListener(e -> edytujCel());
        btnUsun.addActionListener(e -> usunCel());

        return panel;
    }

    private void odswiezListeZadan() {
        try {
            List<Zadanie> lista = zadanieDAO.pobierzZadaniaUzytkownika(zalogowanyUzytkownik.getId());
            modelZadan.setRowCount(0);
            for (Zadanie z : lista) {
                modelZadan.addRow(new Object[]{z.getId(), z.getNazwa(), z.getPriorytet(), z.getKategoria()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Błąd podczas ładowania zadań: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void odswiezListeCelow() {
        try {
            List<Cel> lista = celDAO.pobierzCeleUzytkownika(zalogowanyUzytkownik.getId());
            modelCelow.setRowCount(0);
            for (Cel c : lista) {
                modelCelow.addRow(new Object[]{c.getId(), c.getNazwa(), c.getKategoria(), c.getOpis()});
            }
        } catch (SQLException e) {
            pokazBlad("Błąd podczas ładowania celów: " + e.getMessage());
        }
    }

    // --- Metody obsługi zadań ---

    private void dodajZadanie() {
        FormularzZadania formularz = new FormularzZadania(this, null, zalogowanyUzytkownik.getId());
        formularz.setVisible(true);
        if (formularz.isZatwierdzono()) {
            odswiezListeZadan();
        }
    }

    private void edytujZadanie() {
        int wybrany = tabelaZadan.getSelectedRow();
        if (wybrany == -1) {
            pokazBlad("Wybierz zadanie do edycji.");
            return;
        }
        int idZadania = (int) modelZadan.getValueAt(wybrany, 0);
        try {
            Zadanie zadanie = zadanieDAO.pobierzZadaniePoId(idZadania);
            FormularzZadania formularz = new FormularzZadania(this, zadanie, zalogowanyUzytkownik.getId());
            formularz.setVisible(true);
            if (formularz.isZatwierdzono()) {
                odswiezListeZadan();
            }
        } catch (SQLException e) {
            pokazBlad("Błąd podczas pobierania zadania: " + e.getMessage());
        }
    }

    private void usunZadanie() {
        int wybrany = tabelaZadan.getSelectedRow();
        if (wybrany == -1) {
            pokazBlad("Wybierz zadanie do usunięcia.");
            return;
        }
        int idZadania = (int) modelZadan.getValueAt(wybrany, 0);
        int potwierdzenie = JOptionPane.showConfirmDialog(this, "Czy na pewno chcesz usunąć zadanie?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
        if (potwierdzenie == JOptionPane.YES_OPTION) {
            try {
                szczegolyZadaniaDAO.usunSzczegolyZadania(idZadania);
                zadanieDAO.usunZadanie(idZadania);
                odswiezListeZadan();
            } catch (SQLException e) {
                pokazBlad("Błąd podczas usuwania zadania: " + e.getMessage());
            }
        }
    }

    // --- Metody obsługi celów ---

    private void dodajCel() {
        FormularzCelu formularz = new FormularzCelu(this, null, zalogowanyUzytkownik.getId());
        formularz.setVisible(true);
        if (formularz.isZatwierdzono()) {
            odswiezListeCelow();
        }
    }

    private void edytujCel() {
        int wybrany = tabelaCelow.getSelectedRow();
        if (wybrany == -1) {
            pokazBlad("Wybierz cel do edycji.");
            return;
        }
        int idCelu = (int) modelCelow.getValueAt(wybrany, 0);
        try {
            Cel cel = celDAO.pobierzCelPoId(idCelu);
            FormularzCelu formularz = new FormularzCelu(this, cel, zalogowanyUzytkownik.getId());
            formularz.setVisible(true);
            if (formularz.isZatwierdzono()) {
                odswiezListeCelow();
            }
        } catch (SQLException e) {
            pokazBlad("Błąd podczas pobierania celu: " + e.getMessage());
        }
    }

    private void usunCel() {
        int wybrany = tabelaCelow.getSelectedRow();
        if (wybrany == -1) {
            pokazBlad("Wybierz cel do usunięcia.");
            return;
        }
        int idCelu = (int) modelCelow.getValueAt(wybrany, 0);
        int potwierdzenie = JOptionPane.showConfirmDialog(this, "Czy na pewno chcesz usunąć cel?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
        if (potwierdzenie == JOptionPane.YES_OPTION) {
            try {
                szczegolyCeluDAO.usunSzczegolyCelu(idCelu);
                celDAO.usunCel(idCelu);
                odswiezListeCelow();
            } catch (SQLException e) {
                pokazBlad("Błąd podczas usuwania celu: " + e.getMessage());
            }
        }
    }

    private void pokazBlad(String komunikat) {
        JOptionPane.showMessageDialog(this, komunikat, "Błąd", JOptionPane.ERROR_MESSAGE);
    }
}
