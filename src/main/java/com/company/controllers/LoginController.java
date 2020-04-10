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

// WHY??? generics?
public class LoginController {
    Scanner scanner = new Scanner(System.in);
    Path path = Paths.get("");
    Path absolutePath = path.toAbsolutePath();
    String location = absolutePath.toString()+"/src/main/resources/Menu CcMS/Small/";


    public void init() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
//            TerminalView.clearScreen();
            DataHandler.printFromFile(location + "MainScreen");
            DataHandler.printFromFile(location + "MainMenu");
//            DataHandler.printFromFile(location);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
//                    TODO: logging user

                    DataHandler.printFromFile(location + "MainScreen");
                    DataHandler.printFromFile(location + "MainMenu");

                    loggingUser();
                    break;
                case 2:
                    DataHandler.printFromFile(location + "Credits");
//                    TODO: show credits
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
        String password = PasswordField.readPassword("          Enter password: ");
        System.out.println("          Password entered was:" + password);

        // OPTION 2 -  Ask password without hash!
//        TerminalView.printString("          User password: ");
//        String password = scanner.nextLine();

        if (new UserDaoFromCSV().readUserByUsernameAndPassword(username,password).getName()==null){
            TerminalView.printString("          Wrong username or password.");
        } else {
            User user = new UserDaoFromCSV().readUserByUsernameAndPassword(username,password);
//            System.out.println("            userFound name = " + user.getName());
//            System.out.println("            userFound role = " + user.getRole());

            if (user.getRole().equals("manager")) {
                System.out.println("            Manager Role here");
                ManagerController managerController = new ManagerController(user);
                managerController.init();
            } else if (user.getRole().equals("student")) {
                System.out.println("            Student Role here");
                StudentController studentController = new StudentController(user);
                studentController.init();
            } else if (user.getRole().equals("mentor")) {
                System.out.println("            Mentor Role here");
                MentorController mentorController = new MentorController(user);
                mentorController.init();
            } else if (user.getRole().equals("regularEmployee")) {
                System.out.println("            RegularEmployee Role here");
                RegularEmployeeController regularEmployeeController = new RegularEmployeeController(user);
                regularEmployeeController.init();
            }
        }
    }
}
