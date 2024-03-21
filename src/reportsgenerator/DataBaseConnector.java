/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportsgenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author peta
 */
public class DataBaseConnector {
    private final String DB_URL = "jdbc:mysql://localhost";
    private final String USER = "integrated_CA";
    private final String PASSWORD = "integrated_CA";
    
    public void readDataBase() throws SQLException {
    try {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students;");
        while (resultSet.next()) {
            System.out.println("Hello");
        }
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}


