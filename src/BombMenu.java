import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Random;
import java.util.Scanner;

public class BombMenu {

    /**
     * Scanner used for input within program
     */
    public static Scanner scanner = new Scanner(System.in);
    static Bomb bomb;
    static String sn;
    static int bat;
    static boolean car;
    static boolean frk;

    /**
     * Main method that provides user with a menu in which each number
     * represents a different method (e.g addtion) that they can carry out
     */
    public static void main(String[] args) {

        System.out.println("Please enter the serial number:");
        sn = scanner.next();
        System.out.println("Please enter the number of batteries:");
        bat = scanner.nextInt();
        System.out.println("Is there a lit frk indicator:");
        frk = scanner.next().equals("y");
        System.out.println("Is there a lit car indicator:");
        car = scanner.next().equals("y");
        bomb = new Bomb(sn,bat,frk,car);

        try {
            // Declare variable for user's option and defaulting to 0
            int menuOption = 100;
            do {
                // Setting menuOption equal to return value from showMenu();
                menuOption = showMenu();

                // Switching on the value given from user
                switch (menuOption) {

                    case 0:
                        System.out.println("Quitting Program...");
                        break;
                    case 1:
                        wires();
                        break;
                    case 2:
                        button();
                        break;
                    case 3:
                        keypad();
                        break;
                    case 4:
                        System.out.println("Simon Module Loaded...");
                        bomb.simon();
                        break;
                    case 5:
                        System.out.println("Who's on first Module Loaded...");
                        bomb.whos();
                        break;
                    case 6:
                        System.out.println("Memory Module Loaded...");
                        bomb.memory();
                        break;
                    case 7:
                        password();
                        break;
                    case 8:
                        System.out.println("Wire Sequences Module Loaded...");
                        bomb.sequences();
                        break;
                    case 9:
                        System.out.println("OOF, strike added to the bomb");
                        bomb.strike();
                        break;
                    default:
                        System.out.println("Sorry, please enter valid Option");

                }// End of switch statement

            } while (menuOption != 0);

            // Exiting message when user decides to quit Program
            System.out.println("Thanks for using this Program...");

        } catch (Exception ex) {
            // Error Message
            System.out.println("Sorry problem occurred within Program");
            // flushing scanner
            scanner.next();
        } finally {
            // Ensuring that scanner will always be closed and cleaning up
            // resources
            scanner.close();
        }

    }// End of main Method

    /**
     * Method that prints menu to screen and gets returns user's option from menu
     *
     * @return Returns user Option
     */
    public static int showMenu() {

        // Declaring var for user option and defaulting to 0
        int option = 100;

        // Printing menu to screen
        System.out.println("================================");
        System.out.println("Menu:");
        System.out.println("1. Wires");
        System.out.println("2. Buttons");
        System.out.println("3. Keypad");
        System.out.println("4. Simon");
        System.out.println("5. Who’s on First");
        System.out.println("6. Memory");
        System.out.println("7. Passwords");
        System.out.println("8. Wire Sequence");
        System.out.println("9. Add Strike");
        System.out.println("0. Exit Program");

        // Getting user option from above menu
        System.out.println("Enter Option from above...");
        System.out.println("================================");
        option = scanner.nextInt();

        return option;

    }// End of showMenu

    /**
     * Method that adds two random numbers (from 1-100) and take a user guess
     * for the addition.Then outputs certain statements dependent if user guess
     * is correct or not.
     */
    public static void wires() {
        // Declaring String
        String colors="";
        // Declaring boolean for validity of userAnswer (Defaulted to false)
        boolean validAnswer = false;
        //Do while loop that loops until user gives valid input
        do {
            validAnswer = true;
            System.out.println("Wires Module Loaded...");
            System.out.println("Please enter the color sequence of the wires");
            try {
                colors = scanner.next();
            } catch (Exception ex) {
                // Print error message
                System.out.println("Sorry, Invalid entry for wires...Please Retry!");
                // flush scanner
                scanner.next();
                validAnswer = false;
            }
        } while (!validAnswer);
        System.out.println();
        System.out.println(bomb.wires(colors));
    }

    public static void button() {
        // Declaring String
        String color = "";
        String word;
        // Declaring boolean for validity of userAnswer (Defaulted to false)
        boolean validAnswer = false;
        //Do while loop that loops until user gives valid input
        do {
            validAnswer = true;
            System.out.println("Button Module Loaded...");
            System.out.println("Please enter the word on the button:");
            word = scanner.next();
            System.out.println("Please enter the color of the button");
            try {
                color = scanner.next();
            } catch (Exception ex) {
                // Print error message
                System.out.println("Sorry, Invalid entry for wires...Please Retry!");
                // flush scanner
                scanner.next();
                validAnswer = false;
            }
        } while (!validAnswer);
        System.out.println();
        System.out.println(bomb.button(word, color));
    }

    public static void keypad() {
        System.out.println("Keypad Module Loaded...");
        System.out.println("Please enter the symbols on the buttons separated by commas:");
        String[] symbols = scanner.next().split(",");
        System.out.println();
        System.out.println(bomb.keypad(symbols));
    }

    public static void password() {
        // Declaring String
        String letters;
        System.out.println("Password Module Loaded...");
        System.out.println("Please enter all the possible letters in the first position:");
        letters = scanner.next();
        System.out.println();
        System.out.println(bomb.passwords(letters));
    }


}// End of class