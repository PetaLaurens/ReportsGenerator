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
            txt.generateTxtReport(db.lecturerReport());
            csv.generateCsvReport(db.studentReport());
            db.courseReport();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
