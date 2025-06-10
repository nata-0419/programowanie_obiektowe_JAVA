package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Uzytkownik;
import org.mindrot.jbcrypt.BCrypt;

public class UzytkownikDAO {
    private Connection polaczenie;

    public UzytkownikDAO(Connection polaczenie) {
        this.polaczenie = polaczenie;
    }

    public boolean utworzUzytkownika(Uzytkownik uzytkownik) throws SQLException {
        String sql = "INSERT INTO uzytkownik (imie, nazwisko, nick, haslo) VALUES (?, ?, ?, ?)";
        String hasloHaszowane = BCrypt.hashpw(uzytkownik.getHasloHaszowane(), BCrypt.gensalt());

        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setString(1, uzytkownik.getImie());
            stmt.setString(2, uzytkownik.getNazwisko());
            stmt.setString(3, uzytkownik.getNick());
            stmt.setString(4, hasloHaszowane);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    // Pobranie hash hasła po nicku
    public String pobierzHaslo(String nick) throws SQLException {
        String sql = "SELECT haslo FROM uzytkownik WHERE nick = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setString(1, nick);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("haslo");
            } else {
                return null;
            }
        }
    }

    // Pobranie pełnego obiektu użytkownika po nicku
    public Uzytkownik pobierzUzytkownika(String nick) throws SQLException {
        String sql = "SELECT id, imie, nazwisko, nick, haslo FROM uzytkownik WHERE nick = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setString(1, nick);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Uzytkownik(
                        rs.getInt("id"),
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        rs.getString("nick"),
                        rs.getString("haslo")
                );
            } else {
                return null;
            }
        }
    }


    public Uzytkownik pobierzUzytkownikaPoId(int id) throws SQLException {
        String sql = "SELECT * FROM uzytkownik WHERE id = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Uzytkownik(
                        rs.getInt("id"),
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        rs.getString("nick"),
                        rs.getString("haslo")
                );
            }
        }
        return null;
    }

    public Uzytkownik pobierzUzytkownikaPoNicku(String nick) throws SQLException {
        String sql = "SELECT * FROM uzytkownik WHERE nick = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setString(1, nick);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Uzytkownik(
                        rs.getInt("id"),
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        rs.getString("nick"),
                        rs.getString("haslo")
                );
            }
        }
        return null;
    }

    public void aktualizujUzytkownika(Uzytkownik uzytkownik) throws SQLException {
        String sql = "UPDATE uzytkownik SET imie = ?, nazwisko = ?, nick = ?, haslo = ? WHERE id = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setString(1, uzytkownik.getImie());
            stmt.setString(2, uzytkownik.getNazwisko());
            stmt.setString(3, uzytkownik.getNick());
            stmt.setString(4, uzytkownik.getHasloHaszowane());
            stmt.setInt(5, uzytkownik.getId());
            stmt.executeUpdate();
        }
    }

    public void usunUzytkownika(int id) throws SQLException {
        String sql = "DELETE FROM uzytkownik WHERE id = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public static String haszujHaslo(String haslo) {
        return BCrypt.hashpw(haslo, BCrypt.gensalt());
    }

    public static boolean sprawdzHaslo(String haslo, String hasloHaszowane) {
        if (hasloHaszowane != null && hasloHaszowane.startsWith("$2y$")) {
            hasloHaszowane = "$2a$" + hasloHaszowane.substring(4);
        }
        return BCrypt.checkpw(haslo, hasloHaszowane);
    }

}
