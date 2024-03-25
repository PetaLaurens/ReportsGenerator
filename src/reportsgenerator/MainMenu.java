/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportsgenerator;

import java.util.Scanner;
import static reportsgenerator.User.usersList;

/**
 *
 * @author peta
 */
public class MainMenu {
    
    public void mainMenu() {
        try {
            // Creating the three different users and declaring its usernames and passwords
            User admin = new User("admin", "java");
            User office = new User("office", "paperwork");
            User lecturer = new User("lecturer", "teaching");

            // Stores the above User objects in the usersLists array, declared in the User java class
            usersList.add(admin);
            usersList.add(office);
            usersList.add(lecturer);

            // Declaring the necessary variables to be able to use them inside of other scopes
            int selectedOperation;
            String selectedOperationToString;

            // Main menu
            System.out.println("Hello Admin");
            // Verifying admin credentials as it is the only available user at the beginning
            admin.verifyLoginCredentials(admin);
            System.out.println("Please enter an option.");
            System.out.println("1 - To continue as Admin");
            System.out.println("2 - To login as Office");
            System.out.println("3 - To login as Lecturer");
            System.out.println("4 - To Exit");
            // Getting input from the user
            Scanner userInput = new Scanner(System.in);
            selectedOperation = Integer.parseInt(userInput.nextLine());
            // Parsing the selected operation to string, to be able to check regex condition below
            selectedOperationToString = Integer.toString(selectedOperation);
            // If the user enters wrong input, the program will print a helpful message
            if ((!selectedOperationToString.matches("^[0-9]\\d*$")) || (selectedOperation < 1) || (selectedOperation > 4)) {
                System.out.println("You have not entered the right character, please start again.");
            // ********** MENU FOR THE ADMIN **********
            } else if (selectedOperation == 1) {
                System.out.println("Hello Admin. Please enter an option.");
                System.out.println("1 - To add a user");
                System.out.println("2 - To modify a user");
                System.out.println("3 - To delete a user");
                System.out.println("4 - To change your username");
                System.out.println("5 - To change your password");
                System.out.println("6 - To Exit");
                selectedOperation = Integer.parseInt(userInput.nextLine());
                // Parsing the selected operation to string, to be able to check regex condition below
                selectedOperationToString = Integer.toString(selectedOperation);
                // If the user enters wrong input, the program will print a helpful message
                if ((!selectedOperationToString.matches("^[0-9]\\d*$")) || (selectedOperation < 1) || (selectedOperation > 6)) {
                    System.out.println("You have not entered the right character, please start again.");
                // Option 1 for the admin to add any user
                } else if (selectedOperation == 1) {
                    admin.addUser();
                // Option 2 for the admin to modify any user
                } else if (selectedOperation == 2) {
                    admin.modifyAnyUser();
                // Option 3 for the admin to delete any user
                } else if (selectedOperation == 3) {
                    admin.deleteUser();
                // Option 4 for the admin to modify its username
                } else if (selectedOperation == 4) {
                    admin.changeItsOwnUsername(admin);
                // Option 5 for the admin to modify its password
                } else if (selectedOperation == 5) {
                    admin.changeItsOwnPassword(admin);
                // Option 6 to exit the program
                } else if (selectedOperation == 6) {
                    System.out.println("See you next time!");
                    System.exit(0);
                }
            // ********** MENU FOR THE OFFICE **********
            } else if (selectedOperation == 2) {
                // Verifying office credentials
                office.verifyLoginCredentials(office);
                System.out.println("Hello Office. Please enter an option.");
                System.out.println("1 - To generate reports");
                System.out.println("2 - To change your username");
                System.out.println("3 - To change your password");
                System.out.println("4 - To Exit");
                selectedOperation = Integer.parseInt(userInput.nextLine());
                // Parsing the selected operation to string, to be able to check regex condition below
                selectedOperationToString = Integer.toString(selectedOperation);
                // If the user enters wrong input, the program will print a helpful message
                if ((!selectedOperationToString.matches("^[0-9]\\d*$")) || (selectedOperation < 1) || (selectedOperation > 4)) {
                    System.out.println("You have not entered the right character, please start again.");
                // Option 1 for the office to generate any report
                } else if (selectedOperation == 1) {
                    office.generateReports();
                // Option 2 for the office to modify its username
                } else if (selectedOperation == 2) {
                    office.changeItsOwnUsername(office);
                // Option 3 for the office to modify its password
                } else if (selectedOperation == 3) {
                    office.changeItsOwnPassword(office);
                // Option 4 to exit the program
                } else if (selectedOperation == 4) {
                    System.out.println("See you next time!");
                    System.exit(0);
                }
            // ********** MENU FOR THE LECTURER ********** 
            } else if (selectedOperation == 3) {
                // Verifying lecturer credentials
                lecturer.verifyLoginCredentials(lecturer);
                System.out.println("Hello Lecturer. Please enter an option.");
                System.out.println("1 - To generate Lecturer report");
                System.out.println("2 - To change your username");
                System.out.println("3 - To change your password");
                System.out.println("4 - To Exit");
                selectedOperation = Integer.parseInt(userInput.nextLine());
                // Parsing the selected operation to string, to be able to check regex condition below
                selectedOperationToString = Integer.toString(selectedOperation);
                // If the user enters wrong input, the program will print a helpful message
                if ((!selectedOperationToString.matches("^[0-9]\\d*$")) || (selectedOperation < 1) || (selectedOperation > 4)) {
                    System.out.println("You have not entered the right character, please start again.");
                // Option 1 for the lecturer to generate the lecturer report
                } else if (selectedOperation == 1) {
                    lecturer.generateLecturerReport();
                // Option 2 for the lecturer to modify its username
                } else if (selectedOperation == 2) {
                    lecturer.changeItsOwnUsername(lecturer);
                // Option 3 for the lecturer to modify its password
                } else if (selectedOperation == 3) {
                    lecturer.changeItsOwnPassword(lecturer);
                // Option 4 to exit the program
                } else if (selectedOperation == 4) {
                    System.out.println("See you next time!");
                    System.exit(0);
                }
            // Option 4 to exit the program
            } else if (selectedOperation == 4) {
                System.out.println("See you next time!");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }
