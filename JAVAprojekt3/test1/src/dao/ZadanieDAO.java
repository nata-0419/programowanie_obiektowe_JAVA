package dao;

import baza.PolaczenieBazaDanych;
import model.NiepoprawnyPiorytetException;
import model.Zadanie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZadanieDAO extends AbstractDAO implements ZadanieDAOInterface {
    public ZadanieDAO(Connection polaczenie) {
        super(polaczenie);
    }

    public void utworzZadanie(Zadanie zadanie) throws SQLException, NiepoprawnyPiorytetException {
        if (zadanie.getPriorytet() <= 0) {
            throw new NiepoprawnyPiorytetException();
        }
        String sql = "INSERT INTO zadania (id_uzytkownika, nazwa, piorytet, kategoria) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, zadanie.getIdUzytkownika());
            stmt.setString(2, zadanie.getNazwa());
            stmt.setInt(3, zadanie.getPriorytet());
            stmt.setString(4, zadanie.getKategoria());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                zadanie.setId(rs.getInt(1));
            }
        }
    }

    public Zadanie pobierzZadaniePoId(int id) throws SQLException {
        String sql = "SELECT * FROM zadania WHERE id = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Zadanie(
                        rs.getInt("id"),
                        rs.getInt("id_uzytkownika"),
                        rs.getString("nazwa"),
                        rs.getInt("piorytet"),
                        rs.getString("kategoria")
                );
            }
        }
        return null;
    }

    public List<Zadanie> pobierzZadaniaUzytkownika(int idUzytkownika) throws SQLException {
        String sql = "SELECT * FROM zadania WHERE id_uzytkownika = ?";
        List<Zadanie> lista = new ArrayList<>();
        try (Connection conn = PolaczenieBazaDanych.getPolaczenie();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUzytkownika);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Zadanie(
                            rs.getInt("id"),
                            rs.getInt("id_uzytkownika"),
                            rs.getString("nazwa"),
                            rs.getInt("piorytet"),
                            rs.getString("kategoria")
                    ));
                }
            }
        }
        return lista;
    }


    public void aktualizujZadanie(Zadanie zadanie) throws SQLException {
        String sql = "UPDATE zadania SET nazwa = ?, piorytet = ?, kategoria = ? WHERE id = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setString(1, zadanie.getNazwa());
            stmt.setInt(2, zadanie.getPriorytet());
            stmt.setString(3, zadanie.getKategoria());
            stmt.setInt(4, zadanie.getId());
            stmt.executeUpdate();
        }
    }

    public void usunZadanie(int id) throws SQLException {
        String sql = "DELETE FROM zadania WHERE id = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
