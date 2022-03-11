package ro.ase.acs.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Create {

    public static final String ORG_SQLITE_JDBC = "org.sqlite.JDBC";
    public static final String JDBC_SQLITE_DATABASE_DB = "jdbc:sqlite:database.db";

    public Connection create() {
        try {
            Class.forName(ORG_SQLITE_JDBC);
            Connection connection = DriverManager.getConnection(JDBC_SQLITE_DATABASE_DB);
            connection.setAutoCommit(false);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}