package com.company.controllers;

import com.company.dao.UserDaoFromCSV;
import com.company.models.users.User;
import com.company.service.FileReader;
import com.company.service.TerminalView;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginController implements Controller {
    Scanner scanner = new Scanner(System.in);
    Path path = Paths.get("");
    Path absolutePath = path.toAbsolutePath();
    String location = absolutePath.toString() + "/src/main/resources/Menu CcMS/Small/";

    @Override
    public void init() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
            TerminalView.clearScreen();
            FileReader.printFromFile(location + "MainScreen");
            TerminalView.displayWelcomeScreen();
            FileReader.printFromFile(location + "MainMenu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loggingUser();
                    break;
                case 2:
                    FileReader.printFromFile(location + "Credits");
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
        FileReader.printFromFile(location + "LoginMenu");

        Scanner scanner = new Scanner(System.in);

        TerminalView.printString("          User name: ");
        String username = scanner.nextLine();

        // OPTION 1 - Ask password with hash!
        //        String password = PasswordField.readPassword("          Enter password: ");
        //        System.out.println("          Password entered was:" + password);

        // OPTION 2 -  Ask password without hash!
        TerminalView.printString("          User password: ");
        String password = scanner.nextLine();

        User user = new UserDaoFromCSV().readUserByUsernameAndPassword(username, password);
        if (user == null) {
            TerminalView.printString("          Wrong username or password.");
            return;
        }
        switch (user.getRole()) {
            case "manager":
                handleManager(user);
                break;
            case "student":
                handleStudent(user);
                break;
            case "mentor":
                handleMentor(user);
                break;
            case "regularEmployee":
                handleRegularEmployee(user);
                break;
        }
    }

    private void handleRegularEmployee(User user) throws FileNotFoundException {
        RegularEmployeeController regularEmployeeController = new RegularEmployeeController(user);
        regularEmployeeController.init();
    }

    private void handleMentor(User user) throws FileNotFoundException {
        MentorController mentorController = new MentorController(user);
        mentorController.init();
    }

    private void handleStudent(User user) throws FileNotFoundException {
        StudentController studentController = new StudentController(user);
        studentController.init();
    }

    private void handleManager(User user) throws FileNotFoundException {
        ManagerController managerController = new ManagerController(user);
        managerController.init();
    }
}
