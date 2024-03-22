/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportsgenerator;

/**
 *
 * @author peta
 */
public class Admin {
    // Declaring fields for username and password to a fixed value
    static String username = "admin";
    static String password = "java";

    // Getters and setters
    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setUsername(String username) {
        Admin.username = username;
    }

    public static void setPassword(String password) {
        Admin.password = password;
    }
}
