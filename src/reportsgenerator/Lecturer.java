/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportsgenerator;

/**
 *
 * @author peta
 */
public class Lecturer extends Users {
    // Declaring fields for username and password to a fixed value
    static String username = "lecturer";
    static String password = "teaching";

    public Lecturer(String username, String password) {
        super(username, password);
    }
}
