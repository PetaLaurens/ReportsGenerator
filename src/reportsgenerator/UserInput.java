/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportsgenerator;

import java.util.Scanner;

/**
 *
 * @author peta
 */
public class UserInput {

    public void userMenu() {
        // Declaring all necessary variables to be able to use them inside of other scopes
        int selectedUser;
        String correctUsername = Admin.username;
        String correctPassword = Admin.password;
        String inputUsername;
        String inputPassword;
        int selectedOperation;
        String selectedOperationToString;

        // Asking input from the admin user
        try {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Welcome Admin! Please enter an option.");
            System.out.println("1 - To continue as Admin user");
            System.out.println("2 - To login as Office user");
            System.out.println("3 - To login as Lecturer");
            System.out.println("4 - To Exit");
            selectedUser = Integer.parseInt(userInput.nextLine());
            if (selectedUser == 1) {
                for (int attemptsRemaining = 2; attemptsRemaining >= 0; attemptsRemaining--) {
                    System.out.println("Please enter your username: ");
                    inputUsername = userInput.nextLine();
                    System.out.println("Please enter your password: ");
                    inputPassword = userInput.nextLine();
                    // Admin suer will have three attempts to login with the right credentials
                    if (((!correctUsername.equals(inputUsername)) || (!correctPassword.equals(inputPassword))) && (attemptsRemaining > 0)) {
                        System.out.println("Incorrect. You have " + attemptsRemaining + " attempts remaining.");
                        // If the manager fails to login, program will stop and the access will be denied
                    } else if (((!correctUsername.equals(inputUsername)) || (!correctPassword.equals(inputPassword))) && (attemptsRemaining == 0)) {
                        System.out.println("Access denied. You are now locked out of the system.");
                        // If the admin user logins with the right credentials, then the program will continue
                        // and will ask the admin user to choose from his different permissions
                    } else if ((correctUsername.equals(inputUsername)) && (correctPassword.equals(inputPassword)) && (attemptsRemaining >= 0)) {
                        try {
                            do {
                                System.out.println("Please enter an option.");
                                System.out.println("1 - To add, modify or delete other users.");
                                System.out.println("2 - To change your username and password.");
                                System.out.println("3 - To Exit");
                                selectedOperation = Integer.parseInt(userInput.nextLine());
                                // Parsing the selected operation to string, to be able to check regex condition later on
                                selectedOperationToString = Integer.toString(selectedOperation);
                            } while (selectedOperation != 3);
                            if (selectedOperation == 1) {
                                System.out.println("Adds, modifies and deletes users");
                            } else if (selectedOperation == 2) {
                                System.out.println("Changes username and password");
                            } else if ((!selectedOperationToString.matches("^[0-9]\\d*$")) || (selectedOperation < 1) || (selectedOperation > 3)) {
                                System.out.println("You have not entered the right character, please start again.");
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
