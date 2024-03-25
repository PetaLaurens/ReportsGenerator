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
        // Running the main menu of the program
        try {
            MainMenu main = new MainMenu();
            main.mainMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
