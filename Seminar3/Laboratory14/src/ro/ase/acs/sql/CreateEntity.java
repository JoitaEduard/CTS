package ro.ase.acs.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateEntity {

    public static final String DROP_TABLE_IF_EXISTS_EMPLOYEES = "DROP TABLE IF EXISTS employees";
    public static final String CREATE_TABLE_EMPLOYEES = "CREATE TABLE employees(id INTEGER PRIMARY KEY, name TEXT, address TEXT, salary REAL)";

    public void createEntity(Connection connection) {
        try {
            String sqlDrop = DROP_TABLE_IF_EXISTS_EMPLOYEES;
            String sqlCreate = CREATE_TABLE_EMPLOYEES;

            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDrop);
            statement.executeUpdate(sqlCreate);
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
