package ro.ase.acs.sql;

import java.sql.Connection;
import java.sql.SQLException;

public class Close {
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}