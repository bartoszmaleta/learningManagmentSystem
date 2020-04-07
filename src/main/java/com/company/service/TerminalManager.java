package com.company.service;

import java.util.Scanner;

public class TerminalManager {

    public static void clearScreen() {
//        multiSign(30, "----------------------- Clear Screen -----------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----------------------- Clear Screen -----------------------");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String multiSign(int multiplication, String sign) {
        String out = "";

        for (int i = 0; i < multiplication; i++) {
            out += sign;
        }
        return out;
    }

    public static String askForString(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String out = scanner.nextLine();
        return out;
    }

    public static int askForInt(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String out = scanner.next();
        while (!out.matches("[0-9]+")) {
            printString("Use only numbers");
            out = scanner.next();
        }
        return Integer.valueOf(out);
    }

    public static Double askForDouble(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String out = scanner.next();
        while (!out.matches("([0-9]*)\\.([0-9]*)")) {
            printString("Use only doubles with . as separator ");
            out = scanner.next();
        }
        return Double.valueOf(out);
    }

    public static void printString(String message) {
        System.out.println(message);
    }

    public static boolean askForBool(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.toLowerCase().equals("y")) {
            return true;
        } else if (answer.toLowerCase().equals("n")) {
            return false;
        } else {
            printString("Wrong input! Enter (y) or (n)!");
        }
        return false;
    }

    public static boolean askForBoolean(String ask) {
        System.out.println(ask);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next().toLowerCase();
        if (!answer.equals("y") || !answer.equals("n")) {
            printString("Wrong input! Enter (y) or (n)!");
            answer = scanner.nextLine();
        }
        if (answer.equals("y")) {
            return true;
        } else if (answer.equals("n")) {
            return false;
        }

        return false;
    }
}
