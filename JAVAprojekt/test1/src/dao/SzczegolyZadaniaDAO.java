package dao;

import model.SzczegolyZadania;

import java.sql.*;

public class SzczegolyZadaniaDAO {
    private Connection polaczenie;

    public SzczegolyZadaniaDAO(Connection polaczenie) {
        this.polaczenie = polaczenie;
    }

    public void utworzSzczegolyZadania(SzczegolyZadania szczegoly) throws SQLException {
        String sql = "INSERT INTO szczegoly_zad (id_zadania, data, godzina, stan_realizacji, szczegoly) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, szczegoly.getIdZadania());
            stmt.setDate(2, Date.valueOf(szczegoly.getData()));
            stmt.setTime(3, Time.valueOf(szczegoly.getGodzina()));
            stmt.setString(4, szczegoly.getStanRealizacji());
            stmt.setString(5, szczegoly.getSzczegoly());
            stmt.executeUpdate();
        }
    }

    public SzczegolyZadania pobierzSzczegolyZadaniaPoIdZadania(int idZadania) throws SQLException {
        String sql = "SELECT * FROM szczegoly_zad WHERE id_zadania = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, idZadania);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new SzczegolyZadania(
                        rs.getInt("id_zadania"),
                        rs.getDate("data").toLocalDate(),
                        rs.getTime("godzina").toLocalTime(),
                        rs.getString("stan_realizacji"),
                        rs.getString("szczegoly")
                );
            }
        }
        return null;
    }

    public void aktualizujSzczegolyZadania(SzczegolyZadania szczegoly) throws SQLException {
        String sql = "UPDATE szczegoly_zad SET data = ?, godzina = ?, stan_realizacji = ?, szczegoly = ? WHERE id_zadania = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(szczegoly.getData()));
            stmt.setTime(2, Time.valueOf(szczegoly.getGodzina()));
            stmt.setString(3, szczegoly.getStanRealizacji());
            stmt.setString(4, szczegoly.getSzczegoly());
            stmt.setInt(5, szczegoly.getIdZadania());
            stmt.executeUpdate();
        }
    }

    public void usunSzczegolyZadania(int idZadania) throws SQLException {
        String sql = "DELETE FROM szczegoly_zad WHERE id_zadania = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, idZadania);
            stmt.executeUpdate();
        }
    }
}
