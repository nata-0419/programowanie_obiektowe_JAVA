package dao;
import model.SzczegolyCelu;
import java.sql.*;

public class SzczegolyCeluDAO {
    private Connection polaczenie;

    public SzczegolyCeluDAO(Connection polaczenie) {
        this.polaczenie = polaczenie;
    }

    public void utworzSzczegolyCelu(SzczegolyCelu szczegoly) throws SQLException {
        String sql = "INSERT INTO szczegoly_celu (id_celu, koszty, uzbierana_kwota, data_rozpoczecia, data_zakonczenia, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, szczegoly.getIdCelu());
            stmt.setDouble(2, szczegoly.getKoszty());
            stmt.setDouble(3, szczegoly.getUzbieranaKwota());
            stmt.setDate(4, Date.valueOf(szczegoly.getDataRozpoczecia()));
            stmt.setDate(5, Date.valueOf(szczegoly.getDataZakonczenia()));
            stmt.setString(6, szczegoly.getStatus());
            stmt.executeUpdate();
        }
    }

    public SzczegolyCelu pobierzSzczegolyCeluPoIdCelu(int idCelu) throws SQLException {
        String sql = "SELECT * FROM szczegoly_celu WHERE id_celu = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, idCelu);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new SzczegolyCelu(
                        rs.getInt("id_celu"),
                        rs.getDouble("koszty"),
                        rs.getDouble("uzbierana_kwota"),
                        rs.getDate("data_rozpoczecia").toLocalDate(),
                        rs.getDate("data_zakonczenia").toLocalDate(),
                        rs.getString("status")
                );
            }
        }
        return null;
    }

    public void aktualizujSzczegolyCelu(SzczegolyCelu szczegoly) throws SQLException {
        String sql = "UPDATE szczegoly_celu SET koszty = ?, uzbierana_kwota = ?, data_rozpoczecia = ?, data_zakonczenia = ?, status = ? WHERE id_celu = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setDouble(1, szczegoly.getKoszty());
            stmt.setDouble(2, szczegoly.getUzbieranaKwota());
            stmt.setDate(3, Date.valueOf(szczegoly.getDataRozpoczecia()));
            stmt.setDate(4, Date.valueOf(szczegoly.getDataZakonczenia()));
            stmt.setString(5, szczegoly.getStatus());
            stmt.setInt(6, szczegoly.getIdCelu());
            stmt.executeUpdate();
        }
    }

    public void usunSzczegolyCelu(int idCelu) throws SQLException {
        String sql = "DELETE FROM szczegoly_celu WHERE id_celu = ?";
        try (PreparedStatement stmt = polaczenie.prepareStatement(sql)) {
            stmt.setInt(1, idCelu);
            stmt.executeUpdate();
        }
    }
}
