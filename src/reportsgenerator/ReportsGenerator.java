/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reportsgenerator;

import java.sql.SQLException;

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
            db.lecturerReport();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
