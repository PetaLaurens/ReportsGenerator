/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reportsgenerator;

/**
 *
 * @author peta
 */
public class ReportsGenerator {

    // GitHub repository: https://github.com/PetaLaurens/ReportsGenerator
    
    public static void main(String[] args) {
        // For this program, I have created three users with the below credentials
        // Username: admin | Password: java
        // Username: office | Password: paperwork
        // Username: lecturer | Password: teaching
        
        // Calling the MainMenu method to run the program
        try {
            MainMenu main = new MainMenu();
            main.mainMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
