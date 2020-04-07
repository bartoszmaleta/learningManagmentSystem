package com.company.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataHandler {

    public static void printFromFile(String filepath) throws FileNotFoundException {
        TerminalManager.clearScreen();

        Scanner input = new Scanner(new File(filepath));

        while (input.hasNextLine()) {
//            System.out.print(Color.CYAN);
            System.out.println(input.nextLine());
        }
//        System.out.println(Color.RESET);
    }

    public static String stringFromFile(String filepath) throws FileNotFoundException {

        Scanner input = new Scanner(new File(filepath));

        String dataInString = "";

        while (input.hasNextLine()) {
            dataInString += input.nextLine() + "\n";
        }
        return dataInString;
    }
}
