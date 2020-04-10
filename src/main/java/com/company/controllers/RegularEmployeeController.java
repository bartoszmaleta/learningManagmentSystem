package com.company.controllers;

import com.company.dao.UserDaoFromCSV;
import com.company.models.users.User;
import com.company.service.FileReader;
import com.company.service.TerminalView;
import com.company.view.View;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class RegularEmployeeController implements EmployeeController, Controller {
    Path path = Paths.get("");
    Path absolutePath = path.toAbsolutePath();
    String location = absolutePath.toString() + "/src/main/resources/Menu CcMS/Small/";

    private User user;
    private List<User> studentsList;
    private UserDaoFromCSV userDaoFromCSV;

    private Scanner scanner = new Scanner(System.in);

    public RegularEmployeeController(User user) {
        this.user = user;
        userDaoFromCSV = new UserDaoFromCSV();
        studentsList = userDaoFromCSV.extractUsersFromListOfRecordsByRoleGiven("student");
    }

    @Override
    public void init() throws FileNotFoundException {
        boolean isRunning = true;
        TerminalView.clearScreen();

        while (isRunning) {

            FileReader.printFromFile(location + "EmployeeMenu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TerminalView.clearScreen();
                    displayStudents();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    @Override
    public void displayStudents() throws FileNotFoundException {
        View.viewAllStudents(studentsList);
    }
}
