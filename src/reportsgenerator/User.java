/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportsgenerator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author peta
 */
public class User {
    String username;
    String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void verifyLoginCredentials() {
        
    }
    
    public void addUser() {
        
    }
    
    public void modifyUser() {
        
    }
    
    public void deleteUser() {
        
    }
    
    public void changeUsername() {
        
    }
    
    public void changePassword() {
        
    }
    
    public void generateReports() throws SQLException, IOException {
        // Declaring the necessary variables to be able to use them inside of other scopes
        int selectedOperation;
        String selectedOperationToString; 
        
        // Getting input from the user
        Scanner userInput = new Scanner(System.in);
        // Menu options
        System.out.println("Please enter an option.");
        System.out.println("1 - To generate Course Report");
        System.out.println("2 - To generate Student Report");
        System.out.println("3 - To generate Lecturer Report");
        System.out.println("4 - To Exit");
        selectedOperation = Integer.parseInt(userInput.nextLine());
        // Parsing the selected operation to string, to be able to check regex condition later on
        selectedOperationToString = Integer.toString(selectedOperation);
        // If the user enters wrong input, the program will print a helpful message
        if ((!selectedOperationToString.matches("^[0-9]\\d*$")) || (selectedOperation < 1) || (selectedOperation > 4)) {
            System.out.println("You have not entered the right character, please start again.");
            
        // ********** COURSE REPORT **********
        // If the user wants to generate the Course report, I will ask for information about the file format
        } else if (selectedOperation == 1) {
            System.out.println("Please enter an option.");
            System.out.println("1 - To generate Course Report in txt format");
            System.out.println("2 - To generate Course Report in csv format");
            System.out.println("3 - To generate Course Report in the console");
            System.out.println("4 - To Exit");
            selectedOperation = Integer.parseInt(userInput.nextLine());
            // Parsing the selected operation to string, to be able to check regex condition later on
            selectedOperationToString = Integer.toString(selectedOperation);
            // If the user enters wrong input, the program will print a helpful message
            if ((!selectedOperationToString.matches("^[0-9]\\d*$")) || (selectedOperation < 1) || (selectedOperation > 4)) {
                System.out.println("You have not entered the right character, please start again.");
            // If the user enters 1, the program will generate the course report in txt format
            } else if (selectedOperation == 1) {
                DataBaseConnector db = new DataBaseConnector();
                TxtReport txt = new TxtReport();
                txt.generateTxtReport(db.courseReport());
                System.out.println("The Course report in txt format has now been generated.");
            // If the user enters 2, the program will generate the course report in csv format
            } else if (selectedOperation == 2) {
                DataBaseConnector db = new DataBaseConnector();
                CsvReport csv = new CsvReport();
                csv.generateCsvReport(db.courseReport());
                System.out.println("The Course report in csv format has now been generated.");
            // If the user enters 3, the program will output the course report in the terminal
            } else if (selectedOperation == 3) {
                System.out.println("Please see the Course Report below.");
                System.out.println("");
                DataBaseConnector db = new DataBaseConnector();
                System.out.println(db.courseReport());
            // If the user enters 4, the program will exit
            } else if (selectedOperation == 4) {
                System.out.println("See you next time!");
                System.exit(0);
            }
        // ********** STUDENT REPORT **********
        // If the user wants to generate the Student report, I will ask for information about the file format
        } else if (selectedOperation == 2) {
            System.out.println("Please enter an option.");
            System.out.println("1 - To generate Student Report in txt format");
            System.out.println("2 - To generate Student Report in csv format");
            System.out.println("3 - To generate Student Report in the console");
            System.out.println("4 - To Exit");
            selectedOperation = Integer.parseInt(userInput.nextLine());
            // Parsing the selected operation to string, to be able to check regex condition later on
            selectedOperationToString = Integer.toString(selectedOperation);
            // If the user enters wrong input, the program will print a helpful message
            if ((!selectedOperationToString.matches("^[0-9]\\d*$")) || (selectedOperation < 1) || (selectedOperation > 4)) {
                System.out.println("You have not entered the right character, please start again.");
            // If the user enters 1, the program will generate the student report in txt format
            } else if (selectedOperation == 1) {
                DataBaseConnector db = new DataBaseConnector();
                TxtReport txt = new TxtReport();
                txt.generateTxtReport(db.studentReport());
                System.out.println("The Student report in txt format has now been generated.");
            // If the user enters 2, the program will generate the student report in csv format
            } else if (selectedOperation == 2) {
                DataBaseConnector db = new DataBaseConnector();
                CsvReport csv = new CsvReport();
                csv.generateCsvReport(db.studentReport());
                System.out.println("The Student report in csv format has now been generated.");
            // If the user enters 3, the program will output the student report in the terminal
            } else if (selectedOperation == 3) {
                System.out.println("Please see the Student Report below.");
                System.out.println("");
                DataBaseConnector db = new DataBaseConnector();
                System.out.println(db.studentReport());
            // If the user enters 4, the program will exit
            } else if (selectedOperation == 4) {
                System.out.println("See you next time!");
                System.exit(0);
            }
            
        // ********** LECTURER REPORT **********
        // If the user wants to generate the Lecturer report, I will call the method to generate the lecturer report
        } else if (selectedOperation == 3) {
            generateLecturerReport();
            
        // If the user enters 4, the program will exit
        } else if (selectedOperation == 4) {
            System.out.println("See you next time!");
                System.exit(0);
        }
        }
    
    
    public void generateLecturerReport() throws SQLException, IOException {
        // Declaring the necessary variables to be able to use them inside of other scopes
        int selectedOperation;
        String selectedOperationToString; 
        
        // Getting input from the user
        Scanner userInput = new Scanner(System.in);
        // Menu options
        System.out.println("Please enter an option.");
        System.out.println("1 - To generate Lecturer Report in txt format");
        System.out.println("2 - To generate Lecturer Report in csv format");
        System.out.println("3 - To generate Lecturer Report in the console");
        System.out.println("4 - To Exit");
        selectedOperation = Integer.parseInt(userInput.nextLine());
        // Parsing the selected operation to string, to be able to check regex condition later on
        selectedOperationToString = Integer.toString(selectedOperation);
        // If the user enters wrong input, the program will print a helpful message
        if ((!selectedOperationToString.matches("^[0-9]\\d*$")) || (selectedOperation < 1) || (selectedOperation > 4)) {
            System.out.println("You have not entered the right character, please start again.");
        // If the user enters 1, the program will generate the lecturer report in txt format
        } else if (selectedOperation == 1) {
            DataBaseConnector db = new DataBaseConnector();
            TxtReport txt = new TxtReport();
            txt.generateTxtReport(db.lecturerReport());
            System.out.println("The Lecturer report in txt format has now been generated.");
        // If the user enters 2, the program will generate the lecturer report in csv format
        } else if (selectedOperation == 2) {
            DataBaseConnector db = new DataBaseConnector();
            CsvReport csv = new CsvReport();
            csv.generateCsvReport(db.lecturerReport());
            System.out.println("The Lecturer report in csv format has now been generated.");
        // If the user enters 3, the program will output the lecturer report in the terminal
        } else if (selectedOperation == 3) {
            System.out.println("Please see the Lecturer Report below.");
            System.out.println("");
            DataBaseConnector db = new DataBaseConnector();
            System.out.println(db.lecturerReport());
        // If the user enters 4, the program will exit
        } else if (selectedOperation == 4) {
            System.out.println("See you next time!");
            System.exit(0);
        }

    }
}
    
