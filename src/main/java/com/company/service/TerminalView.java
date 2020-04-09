package com.company.service;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TerminalView {
    private static Scanner scanner = new Scanner(System.in);

    public static int intScanner(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        while(!answer.matches("[0-9]+")) {
            System.out.println("            Wrong input! Choose only numbers!");
            answer = scanner.next();
        }
        return Integer.valueOf(answer);

    }

    private static String multiSign(int multiplication, String sign) {
        String out = "";

        for (int i = 0; i < multiplication; i++) {
            out += sign;
        }
        return out;
    }

    public static String repeatString(String c, int times) {
        StringBuffer b = new StringBuffer();

        for (int i = 0; i <= times + 1; i++) {
            b.append(c);
        }

        return b.toString();
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("\n\n-----------------------------");
        System.out.println("| Press any key to continue |");
        System.out.println("-----------------------------");
        scanner.nextLine();
    }

    public static void pressAnyKeyToContinueWithMenu() throws FileNotFoundException {
        System.out.println("\n\n-----------------------------");
        System.out.println("| Press any key to continue |");
        System.out.println("|     Press (m) for MENU    |");
        System.out.println("-----------------------------");
//        scanner.nextLine();

        String choice = scanner.nextLine();
        boolean isRunningMenu = true;
        while (isRunningMenu) {
            switch (choice.toLowerCase()) {
                case "m":
                    menuHandler();
                    isRunningMenu = false;
                    break;
                default:
                    isRunningMenu = false;
                    break;
            }
        }

        System.out.println("\n\n-----------------------------");
        System.out.println("| Press any key to continue |");
        System.out.println("|     Press (m) for MENU    |");
        System.out.println("-----------------------------");
        scanner.nextLine();

    }

    private static void menuHandler() throws FileNotFoundException {
        boolean isMenuRunning = true;
        while (isMenuRunning) {
            displayMenu();
            switch (scanner.nextLine()) {
                case "1":
                    isMenuRunning = false;
                    break;
                case "0":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong input");
            }
        }
    }

    public static void displayMenu() throws FileNotFoundException {
        TerminalManager.clearScreen();
        String FILE_PATH = "src/main/resources/graphic.txt/menu_logo.txt";

        Scanner input = new Scanner(new File(FILE_PATH));

        while (input.hasNextLine()) {
            System.out.print(Color.BLUE);
            System.out.println(input.nextLine());
        }
        System.out.println(Colour.RESET);

        System.out.println("\n                                 GAME IS PAUSED");
        System.out.println("\n\n\n(1) - Back to the game\n(0) - Exit the program\n\n\n");
    }


    public static void displayWelcomeScreen() {
        emptyLinesThree();
        System.out.println("\n\n\n\n\n\n");
        System.out.println("Produced by: ");
        System.out.println("Aleksandra Kasaraba");
        System.out.println("Bartosz Maleta");
        System.out.println("Stanisław ???");
        System.out.println("Przemysław Buszek\n\n\n");
        pressAnyKeyToContinue();
    }

    public static void clearScreen() {
//        multiSign(30, "\n");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----------------------- Clear Screen -----------------------");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void emptyLinesThree() {
        System.out.println("\n\n");
    }

    public static void thirtyLines() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static void showMenu() {
        System.out.println("\033[0;37;49mMenu");
        System.out.println("Choose option");

        System.out.println("1. Play PVP");
        System.out.println("2. Play PvAi");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. Exit program");

    }
    public static void blankLines(int numberOfBlankLines) {
        StringBuffer result = new StringBuffer();

        for (int i = 1; i < numberOfBlankLines; i++) {
            String blankLine = "\n";
            result.append(blankLine);
        }
        System.out.println(result);
        // return result;

    }
//
//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();

//    }



    public static void printString(String message) {
        System.out.println(message);
    }


}
