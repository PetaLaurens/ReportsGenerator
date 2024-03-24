/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reportsgenerator;

import static reportsgenerator.User.usersList;


/**
 *
 * @author peta
 */
public class ReportsGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DataBaseConnector db = new DataBaseConnector();
            TxtReport txt = new TxtReport();
            CsvReport csv = new CsvReport();
            // Generates TXT report
            //txt.generateTxtReport(db.lecturerReport());
            // Generates CSV report
            //csv.generateCsvReport(db.studentReport());
            // Prints report in the terminal
            //System.out.println(db.courseReport());
            
            //UserInput ui = new UserInput();
            //ui.userMainMenu();
            
            // Creating the three different users and declaring its usernames and passwords
            User admin = new User("admin", "java");
            User office = new User("office", "paperwork");
            User lecturer = new User("lecturer", "teaching");

            // Declares an array, called usersList, to store the above User objects 
            usersList.add(admin);
            usersList.add(office);
            usersList.add(lecturer);
            
            //test
            admin.addUser();

            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
