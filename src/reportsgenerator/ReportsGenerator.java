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
            
            UserInput ui = new UserInput();
            ui.userMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
