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
    private final String DB_URL = "jdbc:mysql://localhost:3306/Reports";
    private final String USER = "integrated_CA";
    private final String PASSWORD = "integrated_CA";
    
    public void readDataBase() throws SQLException {
        try {
            String sql = "SELECT * FROM Reports.students";
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }











