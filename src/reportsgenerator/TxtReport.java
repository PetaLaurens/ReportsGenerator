/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportsgenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author peta
 */
public class TxtReport {
    
    public void generateTxtReport(String reportName) throws IOException, SQLException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Report.txt", true));
        bw.write(reportName);
        bw.close();
    }
}
