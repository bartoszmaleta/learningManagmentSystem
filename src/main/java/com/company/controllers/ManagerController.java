package com.company.controllers;

import com.company.dao.UserDaoFromCSV;
import com.company.models.users.User;
import com.company.models.users.notUsedModels.employees.Mentor;
import com.company.service.DataHandler;
import com.company.service.TerminalManager;
import com.company.service.TerminalView;
import com.company.view.View;
import com.company.view.menu.ManagerMenu;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ManagerController implements EmployeeController, Controller {

    private final Path path = Paths.get("");
    private final Path absolutePath = path.toAbsolutePath();
    private final String location = absolutePath.toString() + "/src/main/resources/Menu CcMS/Small/";

    private User user;
    private List<User> mentorList;
    private List<User> studentsList;
    private List<User> regularEmployeesList;
    Scanner scanner = new Scanner(System.in);
    UserDaoFromCSV userDAOFromCSV;

    public ManagerController(User user) {
        userDAOFromCSV = new UserDaoFromCSV();
        this.user = user;
        mentorList = new UserDaoFromCSV().extractUsersFromListOfRecordsByRoleGiven("mentor");
        studentsList = new UserDaoFromCSV().extractUsersFromListOfRecordsByRoleGiven("student");
        regularEmployeesList = new UserDaoFromCSV().extractUsersFromListOfRecordsByRoleGiven("regularEmployee");
    }

    @Override
    public void init() throws FileNotFoundException {
        boolean isRunning = true;
        TerminalView.clearScreen();

        while (isRunning) {
            DataHandler.printFromFile(location + "ManagerMenu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TerminalView.clearScreen();
                    User mentorToAdd = getMentorFromProvidedData();
                    addMentor(mentorToAdd);
                    break;
                case 2:
                    TerminalView.clearScreen();
                    displayMentors();
                    String usernameOfMentorToRemove = TerminalManager.askForString("Enter username of mentor you want to remove: ");
                    removeMentor(getMentorFromListByUsername(usernameOfMentorToRemove));
                    break;
                case 3:
                    TerminalView.clearScreen();
                    ManagerMenu.displayFirstEditingMentorMenu();
                    displayMentors();
                    String usernameOfMentorToEdit = TerminalManager.askForString("\n" + "Enter username of mentor you want to edit: ");
                    User mentorToEdit = getMentorFromListByUsername(usernameOfMentorToEdit);
                    ManagerMenu.displaySecondEditingMentorMenu();
                    editMentor(mentorToEdit);
                    break;
                case 4:
                    TerminalView.clearScreen();
                    displayMentors();
                    break;
                case 5:
                    TerminalView.clearScreen();
                    displayStudents();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }


    public void addMentor(User mentor) {
        this.mentorList.add(mentor);
        this.userDAOFromCSV.write(mentor);
    }

    public void removeMentor(User mentor) {
        this.mentorList.remove(mentor);
        this.userDAOFromCSV.remove(mentor);
    }

    public void editMentor(User mentor) {
        int option = TerminalManager.takeIntInputWithoutMessage();
        switch (option) {
            case 1:
                String newUsername = TerminalManager.askForString("Enter mentor's new username: ");
                mentor.setUsername(newUsername);
                break;
            case 2:
                String newPassword = TerminalManager.askForString("Enter mentor's new password: ");
                mentor.setPassword(newPassword);
                break;
            case 3:
                String newName = TerminalManager.askForString("Enter mentor's new name: ");
                mentor.setName(newName);
                break;
            case 4:
                String newSurname = TerminalManager.askForString("Enter mentor's new surname: ");
                mentor.setSurname(newSurname);
                break;
            case 5:
                String username = TerminalManager.askForString("Enter mentor's new username: ");
                mentor.setUsername(username);
                String password = TerminalManager.askForString("Enter mentor's new password: ");
                mentor.setPassword(password);
                String name = TerminalManager.askForString("Enter mentor's new name: ");
                mentor.setName(name);
                String surname = TerminalManager.askForString("Enter mentor's new surname: ");
                mentor.setSurname(surname);
                break;
        }
        this.userDAOFromCSV.edit(mentor);
    }

    public User getMentorFromProvidedData() {
//        int id = TerminalManager.askForInt("Enter mentor's id: ");
        int id = this.userDAOFromCSV.getLastIndex() + 1;
        String username = TerminalManager.askForString("Enter mentor's username: ");
        String password = TerminalManager.askForString("Enter mentor's password: ");
        String name = TerminalManager.askForString("Enter mentor's name: ");
        String surname = TerminalManager.askForString("Enter mentor's surname: ");

        return new User(id, username, password, name, surname, "mentor");
    }

    public User getMentorFromListByUsername(String username) {
        for (User user : mentorList) {
            if (user.getRole().equals("mentor")) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
        }
        // TODO: no user handle!
        TerminalManager.printString("No user found");
        return null;
    }

    public void displayMentors() throws FileNotFoundException {
        View.viewAllMentors(new UserDaoFromCSV().extractUsersFromListOfRecordsByRoleGiven("mentor"));
    }

    public void getMentorFromList(Mentor mentor) {
        mentorList.get(mentorList.indexOf(mentor));
    }

    @Override
    public void displayStudents() throws FileNotFoundException {
        View.viewAllStudents(studentsList);
    }

}
