import java.sql.*;
import java.util.*;

public class DzbanDAO {
    private final String url = "jdbc:mysql://localhost:3306/dzbany_po";
    private final String user = "root";
    private final String password = "";

    public DzbanDAO() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Połączono z bazą!");
        } catch (SQLException e) {
            System.out.println(" Błąd połączenia z bazą!");
            e.printStackTrace();
        }
    }

    public void add(Dzban dzban) {
        String sql = "INSERT INTO dzbany (nazwa, opis, pojemnosc, wysokosc) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dzban.getNazwa());
            stmt.setString(2, dzban.getOpis());
            stmt.setInt(3, dzban.getPojemnosc());
            stmt.setInt(4, dzban.getWysokosc());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Dzban> getAll() {
        List<Dzban> dzbany = new ArrayList<>();
        String sql = "SELECT * FROM dzbany";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dzban dzban = new Dzban(
                        rs.getInt("Id"),
                        rs.getString("nazwa"),
                        rs.getString("opis"),
                        rs.getInt("pojemnosc"),
                        rs.getInt("wysokosc")
                );
                dzbany.add(dzban);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dzbany;
    }

    public Dzban getById(int Id) {
        String sql = "SELECT * FROM dzbany WHERE Id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Dzban(
                            rs.getInt("Id"),
                            rs.getString("nazwa"),
                            rs.getString("opis"),
                            rs.getInt("pojemnosc"),
                            rs.getInt("wysokosc")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Dzban dzban) {
        String sql = "UPDATE dzbany SET nazwa = ?, opis = ?, pojemnosc = ?, wysokosc = ? WHERE Id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dzban.getNazwa());
            stmt.setString(2, dzban.getOpis());
            stmt.setInt(3, dzban.getPojemnosc());
            stmt.setInt(4, dzban.getWysokosc());
            stmt.setInt(5, dzban.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int Id) {
        String sql = "DELETE FROM dzbany WHERE Id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
