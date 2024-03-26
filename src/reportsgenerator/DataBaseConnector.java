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
    
    private final String DB_URL = "jdbc:mysql://localhost/Reports";
    private final String USER = "integrated_CA";
    private final String PASSWORD = "integrated_CA";
    
    String data;
    
    // Method that returns the information for the course report, extracted from a Reports database from MySqlWorkbench
    public String courseReport() throws SQLException {
        try {
            // Using sql to combine the different columns I need to be able to extract the Course report
            String sql = "SELECT modules.module_name,\n" +
                        "	   courses.course_name,\n" +
                        "	   COUNT(students.student_ID) AS students_enrolled,\n" +
                        "       lecturers.lecturer_name,\n" +
                        "	   modules.delivery_method\n" +
                        "FROM modules\n" +
                        "JOIN courses ON modules.course_ID = courses.course_ID\n" +
                        "JOIN students ON modules.course_ID = students.course_ID\n" +
                        "JOIN lecturers ON modules.module_ID = lecturers.module_ID\n" +
                        "GROUP BY \n" +
                        "    modules.module_name, \n" +
                        "    courses.course_name, \n" +
                        "    lecturers.lecturer_name, \n" +
                        "    modules.delivery_method";
            // Creating the connection with the Reports database from MySqlWorkbench
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // Declaring a variable with the headers of the columns of the Course report
            String headers = "Module Name, Course Name, Students Enrolled, Lecturer Name, Delivery Method\n";
            
            // Data will be the first line that will be displayed, before iterating through the sql tables
            data = headers;
            
            // Reading the sql tables line by line, and apending these lines to the data variable
            while (rs.next()) {
                data += rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getInt(3) +
                        ", " + rs.getString(4) + ", " + rs.getString(5) + "\n";
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    // Method that returns the information for the student report, extracted from a Reports database from MySqlWorkbench
    public String studentReport() throws SQLException {
        try {
            // Using sql to combine the different columns I need to be able to extract the Student report
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
            // Creating the connection with the Reports database from MySqlWorkbench
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // Declaring a variable with the headers of the columns of the Student report
            String headers = "Student Name, Student ID, Course Name, Module Name, Module Completed, Grade, Modules to be Repeated\n";
            
            // Data will be the first line that will be displayed, before iterating through the sql tables
            data = headers;
            
            // Reading the sql tables line by line, and apending these lines to the data variable
            while (rs.next()) {
                data += rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) +
                        ", " + rs.getString(4) + ", " + rs.getString(5) + ", " + rs.getInt(6) + ", " + rs.getInt(7) + "\n";
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    // Method that returns the information for the lecturer report, extracted from a Reports database from MySqlWorkbench
    public String lecturerReport() throws SQLException {
        try {
            // Using sql to combine the different columns I need to be able to extract the Lecturer report
            String sql = "SELECT lecturers.lecturer_name,\n" +
                        "	   lecturers.lecturer_role,\n" +
                        "       modules.module_name,\n" +
                        "       COUNT(students.student_ID) AS students_enrolled,\n" +
                        "       modules.class_subjects\n" +
                        "FROM modules\n" +
                        "JOIN lecturers ON modules.module_ID = lecturers.module_ID\n" +
                        "JOIN students ON modules.course_ID = students.course_ID\n" +
                        "GROUP BY \n" +
                        "    lecturers.lecturer_name,\n" +
                        "	lecturers.lecturer_role,\n" +
                        "	modules.module_name,\n" +
                        "    modules.class_subjects;";
            // Creating the connection with the Reports database from MySqlWorkbench
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // Declaring a variable with the headers of the columns of the Lecturer report
            String headers = "Lecturer Name, Lecturer Role, Module Name, Students Enrolled, Class Subjects\n";
            
            // Data will be the first line that will be displayed, before iterating through the sql tables
            data = headers;
            
            // Reading the sql tables line by line, and apending these lines to the data variable
            while (rs.next()) {
                data += rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) +
                        ", " + rs.getInt(4) + ", " + rs.getString(5) + "\n";
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}











