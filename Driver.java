import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String [] args){
        learnPython();
    }
    public static void learnPython(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the class! We will be learning Python today");
        boolean exit = false;
        while(!exit) {
            System.out.println("Let's begin! Enter (e) at any point to exit.");
            System.out.println("Choose a module to start learning: ");
            System.out.println("(1) for Module 1");
            System.out.println("(2) for Module 2");
            System.out.println("(3) for Module 3");
            System.out.println("(4) for Module 4");
            // Get user choice for the module
            String choice = keyboard.nextLine();
            try {
                int newChoice = Integer.parseInt(choice);

                if (newChoice == 1) {

                } else if (newChoice == 2) {

                } else if (newChoice == 3) {

                } else if (newChoice == 4){

                } else {
                    System.out.println("Enter 1, 2, 3, or 4 to choose a Module or enter (e) to exit: ");
                    newChoice = keyboard.nextLine();
                }

            }
            catch (NumberFormatException e) {
                if (choice == "e") {
                    System.exit(0);
                }
                System.out.println("Enter 1, 2, 3, or 4 to choose a Module or enter (e) to exit: ");
                choice = keyboard.nextInt();
            }
        }
    }
}