package ro.ase.acs.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

    public static final String INSERT_INTO_EMPLOYEES = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
    public static final String INSERT_INTO_EMPLOYEES_PARAMS = "INSERT INTO employees VALUES (?,?,?,?)";

    public void insertData(Connection connection) {
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

}
