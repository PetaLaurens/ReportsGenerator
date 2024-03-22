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
    
    public void courseReport() throws SQLException {
        try {
            String sql = "SELECT modules.module_name,\n" +
                        "	 courses.course_name,\n" +
                        "	 COUNT(students.student_ID) AS student_enrolled,\n" +
                        "        lecturers.lecturer_name,\n" +
                        "	 modules.delivery_method\n" +
                        "FROM modules\n" +
                        "JOIN courses ON modules.course_ID = courses.course_ID\n" +
                        "JOIN students ON modules.course_ID = students.course_ID\n" +
                        "JOIN lecturers ON modules.module_ID = lecturers.module_ID\n" +
                        "GROUP BY \n" +
                        "    modules.module_name, \n" +
                        "    courses.course_name, \n" +
                        "    lecturers.lecturer_name, \n" +
                        "    modules.delivery_method;";
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("Module Name, Course Name, Students Enrolled, Lecturer Name, Delivery Method");
            System.out.println("");
            
            while (rs.next()) {
                System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getInt(3) + ", " + rs.getString(4) + ", " + rs.getString(5));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void studentReport() throws SQLException {
        try {
            String sql = "SELECT students.student_name,\n" +
                        "	   students.student_ID,\n" +
                        "	   courses.course_name,\n" +
                        "	   modules.module_name,\n" +
                        "       grades.module_completed,\n" +
                        "       grades.grade,\n" +
                        "       students.modules_to_be_repeated\n" +
                        "FROM students\n" +
                        "JOIN courses ON students.course_ID = courses.course_ID\n" +
                        "JOIN modules ON students.course_ID = modules.course_ID\n" +
                        "JOIN grades ON students.course_ID = grades.course_ID;";
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("Student Name, Student ID, Course Name, Module Name, Module Completed, Grade, Modules to be Repeated");
            System.out.println("");
            
            while (rs.next()) {
                System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) +
                        ", " + rs.getString(4) + ", " + rs.getString(5) + ", " + rs.getInt(6) + ", " + rs.getInt(7));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }











