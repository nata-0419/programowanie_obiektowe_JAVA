package dao;

import java.sql.Connection;


public abstract class AbstractDAO {
    protected Connection polaczenie;

    public AbstractDAO(Connection polaczenie) {
        this.polaczenie = polaczenie;
    }

    protected void closeResources(AutoCloseable... resources) {
        for (AutoCloseable res : resources) {
            if (res != null) {
                try {
                    res.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
