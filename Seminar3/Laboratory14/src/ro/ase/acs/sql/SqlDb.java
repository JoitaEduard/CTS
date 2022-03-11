package ro.ase.acs.sql;

import ro.ase.acs.Database;

import java.sql.*;

public class SqlDb implements Database {

    public static final String ORG_SQLITE_JDBC = "org.sqlite.JDBC";
    public static final String JDBC_SQLITE_DATABASE_DB = "jdbc:sqlite:database.db";
    public static final String DROP_TABLE_IF_EXISTS_EMPLOYEES = "DROP TABLE IF EXISTS employees";
    public static final String CREATE_TABLE_EMPLOYEES = "CREATE TABLE employees(id INTEGER PRIMARY KEY, name TEXT, address TEXT, salary REAL)";
    public static final String INSERT_INTO_EMPLOYEES = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
    public static final String INSERT_INTO_EMPLOYEES_PARAMS = "INSERT INTO employees VALUES (?,?,?,?)";
    public static final String SELECT_FROM_EMPLOYEES = "SELECT * FROM employees";

    private static Connection connection;

    @Override
    public void createDb() {
        createConnection();
        createEntity();
        insertData();
        readData();
        closeConnection();
    }

    @Override
    public void createConnection() {
        try {
            Class.forName(ORG_SQLITE_JDBC);
            connection = DriverManager.getConnection(JDBC_SQLITE_DATABASE_DB);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createEntity() {
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

    @Override
    public void insertData() {
        try {
            String sqlInsert = INSERT_INTO_EMPLOYEES;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlInsert);
            statement.close();

            String sqlInsertWithParams = INSERT_INTO_EMPLOYEES_PARAMS;
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlInsertWithParams);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Ionescu Vasile");
            preparedStatement.setString(3, "Brasov");
            preparedStatement.setDouble(4, 4500);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readData() {
        try {
            String sqlSelect = SELECT_FROM_EMPLOYEES;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            while (rs.next()) {
                int id = rs.getInt("id");
                System.out.println("id: " + id);
                String name = rs.getString(2);
                System.out.println("name: " + name);
                String address = rs.getString("address");
                System.out.println("address: " + address);
                double salary = rs.getDouble("salary");
                System.out.println("salary: " + salary);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
