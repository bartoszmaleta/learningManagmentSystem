package com.company.controllers;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginController {
    Scanner scanner = new Scanner(System.in);

    public void init() throws FileNotFoundException {
        boolean isRunning = true;
//        TerminalView.displayWelcomeScreen();

        while (isRunning) {
//            TerminalView.clearScreen();
//            LoginMenu.display();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
//                    TODO: logging user
                    loggingUser();
                    break;
                case 2:
//                    TODO: show credits
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private void loggingUser() {
//        TODO:
    }
}
