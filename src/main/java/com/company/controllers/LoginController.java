package com.company.controllers;

import com.company.dao.UserDaoFromCSV;
import com.company.models.users.User;
import com.company.service.DataHandler;
import com.company.service.TerminalView;
import com.company.service.passwordHasher.PasswordField;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginController implements Controller {
    Scanner scanner = new Scanner(System.in);
    Path path = Paths.get("");
    Path absolutePath = path.toAbsolutePath();
    String location = absolutePath.toString()+"/src/main/resources/Menu CcMS/Small/";

    @Override
    public void init() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
            TerminalView.clearScreen();
            DataHandler.printFromFile(location + "MainScreen");
            TerminalView.displayWelcomeScreen();
            DataHandler.printFromFile(location + "MainMenu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loggingUser();
                    break;
                case 2:
                    DataHandler.printFromFile(location + "Credits");
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("            Wrong input !!!");
            }
        }
    }

    public void loggingUser() throws FileNotFoundException {
        DataHandler.printFromFile(location + "LoginMenu");

        Scanner scanner = new Scanner(System.in);

        TerminalView.printString("          User name: ");
        String username = scanner.nextLine();

        // OPTION 1 - Ask password with hash!
//        String password = PasswordField.readPassword("          Enter password: ");
//        System.out.println("          Password entered was:" + password);

        // OPTION 2 -  Ask password without hash!
        TerminalView.printString("          User password: ");
        String password = scanner.nextLine();

        if (new UserDaoFromCSV().readUserByUsernameAndPassword(username,password).getName()==null){
            TerminalView.printString("          Wrong username or password.");
        } else {
            User user = new UserDaoFromCSV().readUserByUsernameAndPassword(username,password);
            if (user.getRole().equals("manager")) {
                ManagerController managerController = new ManagerController(user);
                managerController.init();
            } else if (user.getRole().equals("student")) {
                StudentController studentController = new StudentController(user);
                studentController.init();
            } else if (user.getRole().equals("mentor")) {
                MentorController mentorController = new MentorController(user);
                mentorController.init();
            } else if (user.getRole().equals("regularEmployee")) {
                RegularEmployeeController regularEmployeeController = new RegularEmployeeController(user);
                regularEmployeeController.init();
            }
        }
    }
}
