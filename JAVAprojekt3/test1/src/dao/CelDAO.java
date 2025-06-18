package dao;

import model.Cel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CelDAO {
    private Connection polaczenie;

    public CelDAO(Connection polaczenie) {
        this.polaczenie = polaczenie;
    }

    public void utworzCel(Cel cel) throws SQLException {
        String sql = "INSERT INTO cele (id_uzytkownika, nazwa, kategoria, opis, zdjecie) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, cel.getIdUzytkownika());
            stmt.setString(2, cel.getNazwa());
            stmt.setString(3, cel.getKategoria());
            stmt.setString(4, cel.getOpis());
            stmt.setString(5, cel.getZdjecie());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                cel.setId(rs.getInt(1));
            }
        }
    }

    public Cel pobierzCelPoId(int id) throws SQLException {
        String sql = "SELECT * FROM cele WHERE id = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cel(
                        rs.getInt("id"),
                        rs.getInt("id_uzytkownika"),
                        rs.getString("nazwa"),
                        rs.getString("kategoria"),
                        rs.getString("opis"),
                        rs.getString("zdjecie")
                );
            }
        }
        return null;
    }

    public List<Cel> pobierzCeleUzytkownika(int idUzytkownika) throws SQLException {
        String sql = "SELECT * FROM cele WHERE id_uzytkownika = ?";
        List<Cel> lista = new ArrayList<>();
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, idUzytkownika);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Cel(
                        rs.getInt("id"),
                        rs.getInt("id_uzytkownika"),
                        rs.getString("nazwa"),
                        rs.getString("kategoria"),
                        rs.getString("opis"),
                        rs.getString("zdjecie")
                ));
            }
        }
        return lista;
    }

    public void aktualizujCel(Cel cel) throws SQLException {
        String sql = "UPDATE cele SET nazwa = ?, kategoria = ?, opis = ?, zdjecie = ? WHERE id = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setString(1, cel.getNazwa());
            stmt.setString(2, cel.getKategoria());
            stmt.setString(3, cel.getOpis());
            stmt.setString(4, cel.getZdjecie());
            stmt.setInt(5, cel.getId());
            stmt.executeUpdate();
        }
    }

    public void usunCel(int id) throws SQLException {
        String sql = "DELETE FROM cele WHERE id = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
