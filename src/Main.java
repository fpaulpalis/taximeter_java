package Main;

import Methods.LoginMethod;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Variable for shits
        int total = 0;
        int[] totalkm = new int[50];
        int totalEarns = 0;

        // Instantiate the imports
        boolean isLoggedIn = false;
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> history = new ArrayList<>();

        HashMap<String, String> users = new HashMap<>();
        users.put("admin", "1234");

        while (true) {
            System.out.println("===============================================");
            System.out.println("");
            System.out.println("Fare Management System\n[L] Login\n[R] Register\n[H] Help");
            String act = s.nextLine().toLowerCase();
            if (act.equalsIgnoreCase("L")) {
                System.out.print("Enter username: ");
                String username = s.nextLine();
                System.out.print("Enter password: ");
                String password = s.nextLine();

                if (LoginMethod.checkUser(username, password, users)) {
                    System.out.println("Login successful!");
                    isLoggedIn = true;
                    break;
                } else {
                    System.out.println("Invalid username or password.");
                }
            } else if (act.equalsIgnoreCase("R")) {
                System.out.print("Enter new username: ");
                String newUsername = s.nextLine().toLowerCase();
                System.out.print("Enter new password: ");
                String newPassword = s.nextLine().toLowerCase();

                users.put(newUsername, newPassword);
                System.out.println("User registered successfully!");
            } else if (act.equalsIgnoreCase("H")) {
                System.out.println("Login Menu:\n");
                System.out.println("Admin \"Default\" Account");
                System.out.println("Username: admin");
                System.out.println("Password: 1234\n");
                System.out.println("   - If you haven't registered yet, start by creating an account.");
                System.out.println(
                        "   - Once registered, log in with your username and password to access the system.\n");
                System.out.println(
                        "   - Warning: Note that data will be lost after program exit due to Java array limitations on temporary memory.\n");
                System.out.println("   - Register to create a new account or log in to an existing one to proceed.");
            } else {
                System.out.println("Invalid input.");
            }
        }
        int i = 0;
        if (isLoggedIn) {
            try {
                while (true) {
                    System.out.println("===============================================");
                    System.out.println("\n");
                    System.out.println(
                            "[S] start ride\n[R] show rates\n[H] history\n[E] total earnings\n[A] about app\n[P] profile\n[i] help\n[X] quit");
                    System.out.println("\n");
                    String act2 = s.nextLine().toLowerCase();
                    System.out.println("");
                    int fareRate = 50;
                    int fareRate2 = 100;
                    int fareRate3 = 150;

                    switch (act2) {
                        case "s":
                            System.out.print("Enter how many km: ");
                            int km = Integer.parseInt(s.nextLine());
                            total = LoginMethod.rateChecker(km, fareRate, fareRate2, fareRate3);
                            totalkm[i] = km; // Add kilometers traveled to the array
                            history.add(total);
                            i++; // Increment the index for the next entry
                            System.out.println("The total fare is: " + total + " Pesos");
                            break;
                        case "r":
                            System.out.println("The fare rate are: ");
                            System.out.println("1-4km = 50 \n5-10km = 100 \n11km above = 150");
                            break;
                        case "h":
                            System.out.println("History:");
                            for (int j = 0; j < history.size(); j++) {
                                System.out
                                        .println("Distance: " + totalkm[j] + " km, Fare: " + history.get(j) + " Pesos");
                            }
                            break;
                        case "e":
                            System.out.println("The Total earning are: ");
                            for (int j = 0; j < history.size(); j++) {
                                totalEarns += history.get(j);
                            }
                            System.out.println(totalEarns + " Pesos");
                            break;
                        case "a":
                            System.out.println("About App");
                            System.out.println("");
                            System.out.println(
                                    "Title: Java Fare Management System (Taxi Meter)\nDescription: The Java Fare Management System is a Java terminal program tailored for \ntransportation services. It simplifies fare tracking by collecting rates per kilometer.\nFeatures include starting rides, displaying rates, accessing fare history, checking total \nearnings, and managing profiles. Users can find detailed information and assistance through\nthe help menu.");
                            System.out.println("=====================");
                            System.out.println("");
                            System.out.println(
                                    "Copyright\nITE186-P3 PeTa Java Program\nSubmitted to: Sir Rofer Junio Savella");
                            System.out.println("");
                            System.out.println("Submitted by: ");
                            System.out.println(
                                    "1. Benitez, Kenley Russel S.\n2. Fernandez, Rainer U.\n3. Garcia, Dean Aynslie N\n4. Genuino, Sir Xziann Jeano P.\n5. Palis, Francis Paul A.");
                            System.out.println("");
                            System.out.println("=====================");
                            System.out.println("");
                            System.out.println("c2024; Fare Management System. All rights reserved.");

                            break;
                        case "p":
                            System.out.println("The registered users:");
                            for (HashMap.Entry<String, String> entry : users.entrySet()) {
                                String key = entry.getKey();
                                String value = entry.getValue();
                                System.out.println("Username: " + key + ", Passwords: " + value);
                            }
                            System.out.println("Press [1] to remove a user\n[2] to add a user ");
                            int cmd3 = s.nextInt();
                            s.nextLine();
                            if (cmd3 == 1) {
                                System.out.print("Enter a username you wanna remove: ");
                                String rmv = s.nextLine().toLowerCase();
                                users.remove(rmv);
                                System.out.println("Successfully Removed");
                            } else if (cmd3 == 2) {
                                System.out.print("Enter new username: ");
                                String newUsername = s.nextLine().toLowerCase();
                                System.out.print("Enter new password: ");
                                String newPassword = s.nextLine().toLowerCase();

                                users.put(newUsername, newPassword);
                                System.out.println("User registered successfully!");
                            } else {
                                System.out.println("Invalid key!!");
                            }
                            break;
                        case "i":
                            System.out.println("=====================================");
                            System.out.println("Help Guide:");
                            System.out.println("=====================================");
                            System.out.println();
                            System.out.println("1. Start Ride:");
                            System.out.println("- To Begin a new ride, select this option.");
                            System.out.println("    - Input the distance traveled in kilometers.");
                            System.out.println("- The program will calculate the fare based on the provided distance.");
                            System.out.println(
                                    "- Simple and straightforward, requiring only the distance traveled as input.");
                            System.out.println();
                            System.out.println("2. Show Rates:");
                            System.out.println("- This option allows you to view the current fare rates.");
                            System.out.println(
                                    "- It displays the rates per kilometer applicable for different distances.");
                            System.out.println(
                                    "- You can refer to this information to inform passengers or plan your routes.");
                            System.out.println();
                            System.out.println("3. Fare Timeline:");
                            System.out.println("- Use this feature to track the fare during an ongoing ride.");
                            System.out
                                    .println("- It continuously updates the fare as the distance traveled increases.");
                            System.out.println(
                                    "- Helpful for keeping passengers informed about the fare as the journey progresses.");
                            System.out.println();
                            System.out.println("4. History:");
                            System.out
                                    .println("- Accesses the fare history, listing previous rides and their details.");
                            System.out.println(
                                    "- You can review past rides, including starting point, destination, distance, and fare.");
                            System.out.println(
                                    "- Helps in keeping track of past transactions for record-keeping or reporting purposes.");
                            System.out.println();
                            System.out.println("5. Total Earnings:");
                            System.out.println("- Displays the total earnings accumulated from completed rides.");
                            System.out
                                    .println("- It provides a summary of all fares collected over a specified period.");
                            System.out.println("- Useful for monitoring income and assessing business performance.");
                            System.out.println();
                            System.out.println("6. Profile:");
                            System.out.println("- Manage your user profile through this option.");
                            System.out.println(
                                    "- You can update personal information, such as name, contact details, and vehicle information.");
                            System.out.println(
                                    "- Ensures accurate records and facilitates communication with passengers if needed.");
                            System.out.println();
                            System.out.println("7. About App:");
                            System.out.println("- Provides information about the Java Fare Management System.");
                            System.out.println(
                                    "- Includes details about the application, its purpose, and development team.");
                            System.out.println(
                                    "- Offers insight into the background of the program for users' reference.");
                            System.out.println("    - Displays copyright information.");

                            break;
                        case "x":
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Entered an invalid key!!");
                    }
                }
            } catch (Exception e) {
                System.out.println("invalid key command");
            }
        } else {
            System.out.println("Not logged in.");
        }
    }
}
