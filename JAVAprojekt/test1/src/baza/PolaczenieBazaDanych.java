package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PolaczenieBazaDanych {
    private static final String URL = "jdbc:mysql://localhost:3306/harmonogramjava";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection polaczenie;

    public static Connection getPolaczenie() throws SQLException {
        if (polaczenie == null || polaczenie.isClosed()) {
            polaczenie = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return polaczenie;
    }

    public static void zamknijPolaczenie() throws SQLException {
        if (polaczenie != null && !polaczenie.isClosed()) {
            polaczenie.close();
        }
    }
}
