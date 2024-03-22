/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportsgenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author peta
 */
public class TxtReport {
    
    public void TxtFile(Class reportName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("report.txt", true));
        bw.write(reportName.getName());
        bw.close();
    }
}
