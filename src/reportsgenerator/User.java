/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportsgenerator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
    
    // Creates the usersList empty array outside of the methods scopes
    public static ArrayList<User> usersList = new ArrayList<>();
    
    // Declaring the different methods that will be accessible to different users
    public void verifyLoginCredentials(User user) {
        // Declaring all necessary variables to be able to use them inside of other scopes
        String correctUsername = user.username;
        String correctPassword = user.password;
        String inputUsername;
        String inputPassword;

        // Asking the user for input
        Scanner userInput = new Scanner(System.in);

        // Conditional statements for the user to login
        for (int attemptsRemaining = 2; attemptsRemaining >= 0; attemptsRemaining--) {
            System.out.println("Please enter your username: ");
            inputUsername = userInput.nextLine();
            System.out.println("Please enter your password: ");
            inputPassword = userInput.nextLine();
            // User will have three attempts to login with the right credentials
            if (((!correctUsername.equals(inputUsername)) || (!correctPassword.equals(inputPassword))) && (attemptsRemaining > 0)) {
                System.out.println("Incorrect. You have " + attemptsRemaining + " attempts remaining.");
            // If the user fails to login, program will stop and the access will be denied
            } else if (((!correctUsername.equals(inputUsername)) || (!correctPassword.equals(inputPassword))) && (attemptsRemaining == 0)) {
                System.out.println("Access denied. You are now locked out of the system.");
                System.exit(0);
            // If the user logins with the right credentials, then the program will continue
            } else if ((correctUsername.equals(inputUsername)) && (correctPassword.equals(inputPassword)) && (attemptsRemaining >= 0)) {
                System.out.println("Welcome.");
                attemptsRemaining += -2;
            }
        }
    }
    
    // Method to add a new user
    public void addUser() {
        // Declaring all necessary variables to be able to use them inside of other scopes
        String newUsername;
        String newPassword;
        
        // Asking the user for input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the username for the new user: ");
        newUsername = userInput.nextLine();
        System.out.println("Please enter the password for the new user: ");
        newPassword = userInput.nextLine();
        
        // Creates a new User object
        User newUser = new User(newUsername, newPassword);
        
        usersList.add(newUser);
        
        // Displaying the results for the admin
        System.out.println("");
        System.out.println("The new user has been succesfully created with the below credentials.");
        System.out.println("Username: " +  newUsername);
        System.out.println("Password: " +  newPassword);
        
        // Displaying the existent users
        System.out.println("");
        System.out.println("See below the current list of users:");
        System.out.println("");
        
        // Code to search and display the name of each of the users in the usersList array
        for (User user : usersList) {
            System.out.println("User: " + user.username);
            }

    }
    
    // Method to modify any user
    public void modifyAnyUser() {
        // Declaring all necessary variables to be able to use them inside of other scopes
        String userToBeModified;
        
        // Asking the user for input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the username of the user you want to modify: ");
        userToBeModified = userInput.nextLine();
        
        // Boolean to check if the user is found
        boolean userFound = false;
        // Using Iterator to modify the chosen user
        
        // Using enhanced for loop to modify the chosen user
        for (User user : usersList) {
            // If the user is found, it will be modified, otherwise, the program will print a useful message for the admin
            if (user.username.equals(userToBeModified)) {
                System.out.println("Please enter the new username for user " + userToBeModified + ": ");
                String newUsername = userInput.nextLine();
                System.out.println("Please enter the new password for user " + userToBeModified + ": ");
                String newPassword = userInput.nextLine();
                user.username = newUsername;
                user.password = newPassword;
                userFound = true;
                // Using break as there is no need to continue once the user is found and modified
                break; 
            }
        }
        
        // Message to inform the admin if the chosen user has been modified or not
        System.out.println("");
        if (userFound) {
            System.out.println("The user " + userToBeModified + " has been modified.");
        } else {
            System.out.println("User " + userToBeModified + " not found.");
        }
        
        // Displaying the existent users
        System.out.println("");
        System.out.println("See below the current list of users:");
        System.out.println("");
        
        // Code to search and display the name of each of the users in the usersList array
        for (User user : usersList) {
            System.out.println("User: " + user.username);
            }
    }
    
    // Method to delete a user
    public void deleteUser() {
        // Declaring all necessary variables to be able to use them inside of other scopes
        String userToBeDeleted;
        
        // Asking the user for input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the username of the user you want to delete: ");
        userToBeDeleted = userInput.nextLine();
        
        // Boolean to check if the user is found
        boolean userFound = false;
        
        // Using Iterator to remove the chosen user
        Iterator<User> iterator = usersList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            // If the user is found, it will be deleted, otherwise, the program will print a useful message for the admin
            if (user.username.equals(userToBeDeleted)) {
                iterator.remove();
                userFound = true;
                // Using break as there is no need to continue once the user is found and deleted
                break; 
            }
        }
        
        // Message to inform the admin if the chosen user has been removed or not
        System.out.println("");
        if (userFound) {
            System.out.println("The user " + userToBeDeleted + " has been removed.");
        } else {
            System.out.println("User " + userToBeDeleted + " not found.");
        }
        
        // Displaying the existent users
        System.out.println("");
        System.out.println("See below the current list of users:");
        System.out.println("");
        
        // Code to search and display the name of each of the users in the usersList array
        for (User user : usersList) {
            System.out.println("User: " + user.username);
            }
    }
    
    // Method for the user to change its own username
    public void changeItsOwnUsername() {
        // Declaring all necessary variables to be able to use them inside of other scopes
        String currentUsername;
        String newUsername;
        
        // Asking the user for input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your current username: ");
        currentUsername = userInput.nextLine();
        
        // Boolean to check if the username is found
        boolean usernameFound = false;
        
        // Using enhanced for loop to modify the chosen username
        for (User user : usersList) {
            // If the username is found, it will be modified, otherwise, the program will print a useful message for the user
            if (user.username.equals(currentUsername)) {
                System.out.println("Please enter your new username: ");
                newUsername = userInput.nextLine();
                user.username = newUsername;
                usernameFound = true;
                // Using break as there is no need to continue once the username is found and modified
                break; 
            }
        }
        
        // Message to inform the user if the username has been modified or not
        System.out.println("");
        if (usernameFound) {
            System.out.println("The username " + currentUsername + " has been modified.");
        } else {
            System.out.println("Username " + currentUsername + " not found.");
        }
        
        // Displaying the existent users
        System.out.println("");
        System.out.println("See below the current list of users:");
        System.out.println("");
        
        // Code to search and display the name of each of the users in the usersList array
        for (User user : usersList) {
            System.out.println("User: " + user.username);
            }
    }
    
    // Method for the user to change its own password
    public void changeItsOwnPassword() {
        // Declaring all necessary variables to be able to use them inside of other scopes
        String currentPassword;
        String newPassword;
        
        // Asking the user for input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        currentPassword = userInput.nextLine();
        
        // Boolean to check if the password is found
        boolean passwordFound = false;
        
        // Using enhanced for loop to modify the chosen password
        for (User user : usersList) {
            // If the password is found, it will be modified, otherwise, the program will print a useful message for the user
            if (user.password.equals(currentPassword)) {
                System.out.println("Please enter your new password: ");
                newPassword = userInput.nextLine();
                user.password = newPassword;
                passwordFound = true;
                // Using break as there is no need to continue once the user is found and modified
                break; 
            }
        }
        
        // Message to inform the user if the password has been modified or not
        System.out.println("");
        if (passwordFound) {
            System.out.println("Your password has been succesfully modified.");
        } else {
            System.out.println("Password not found.");
        }
        
        // Displaying the existent users
        System.out.println("");
        System.out.println("See below the current list of users:");
        System.out.println("");
        
        // Code to search and display the name of each of the users in the usersList array
        for (User user : usersList) {
            System.out.println("User: " + user.username);
            }
    }
    
    // Method to generate the different reports in different formats
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
    
    //Method to generate the Lecturer report
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
    
