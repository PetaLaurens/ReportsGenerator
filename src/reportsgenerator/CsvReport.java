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
public class CsvReport {
    
    public void generateCsvReport(String reportName) throws IOException, SQLException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("CollegeReport.csv", true));
        bw.write(reportName);
        bw.close();
    }
}
