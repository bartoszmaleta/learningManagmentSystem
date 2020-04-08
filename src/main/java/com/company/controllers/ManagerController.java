package com.company.controllers;

import com.company.dao.MentorDAO;
import com.company.dao.RegularEmployeeDAO;
import com.company.dao.StudentDAO;
import com.company.dao.UserDAOFromCSV;
import com.company.models.users.User;
import com.company.models.users.employees.Mentor;
import com.company.models.users.employees.RegularEmployee;
import com.company.models.users.students.Student;
import com.company.service.TerminalManager;
import com.company.view.View;
import com.company.view.menu.ManagerMenu;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Scanner;

public class ManagerController implements Employee{
    private User user;
    private List <User> mentorList;
    private List <User> studentsList;
    private List <User> regularEmployeesList;
    Scanner scanner = new Scanner(System.in);
    UserDAOFromCSV userDAOFromCSV;

    public ManagerController(User user) {
        System.out.println("Manager Controller constructor here");
        userDAOFromCSV = new UserDAOFromCSV();
        this.user = user;
        mentorList = new UserDAOFromCSV().extractUserFromListByRoleGiven("mentor");
        studentsList = new UserDAOFromCSV().extractUserFromListByRoleGiven("student");
        regularEmployeesList = new UserDAOFromCSV().extractUserFromListByRoleGiven("regularEmployee");
    }


    public void init() {
        boolean isRunning = true;
//        TerminalView.displayWelcomeScreen();

        while (isRunning) {
//            TerminalView.clearScreen();
            ManagerMenu.displayMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    User mentorToAdd = getMentorFromProvidedData();
                    addMentor(mentorToAdd);
                    break;
                case 2:
                    displayMentors();
                    String usernameOfMentorToRemove = TerminalManager.askForString("Enter username of mentor you want to remove: ");
                    removeMentor(getMentorFromListByUsername(usernameOfMentorToRemove));
                    break;
                case 3:
                    ManagerMenu.displayFirstEditingMentorMenu();
                    displayMentors();
                    String usernameOfMentorToEdit = TerminalManager.askForString("\n" + "Enter username of mentor you want to edit: ");
                    User mentorToEdit = getMentorFromListByUsername(usernameOfMentorToEdit);
                    ManagerMenu.displaySecondEditingMentorMenu();
                    editMentor(mentorToEdit);
                    break;
                case 4:
                    displayMentors();
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
        System.out.println("before size of mentorList = " + mentorList.size());
        this.mentorList.add(mentor);
        System.out.println("after size of mentorList = " + mentorList.size());
        this.userDAOFromCSV.write(mentor);
    }

    public void removeMentor(User mentor) {
        this.mentorList.remove(mentor);
        this.userDAOFromCSV.remove(mentor);
    }

    public void editMentor(User mentor) {
        int option = TerminalManager.takeIntInputWithoutMessage();
        switch(option) {
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
                String password= TerminalManager.askForString("Enter mentor's new password: ");
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
        for(User user : mentorList) {
            if (user.getRole().equals("mentor")) {
                if(user.getUsername().equals(username)) {
                    return user;
                }
            }
        }
        return null;
    }

    public void displayMentors() {
        View.viewAllMentors(new UserDAOFromCSV().extractUserFromListByRoleGiven("mentor"));
    }

    public void getMentorFromList(Mentor mentor) {
        mentorList.get(mentorList.indexOf(mentor));
    }

    @Override
    public void displayStudents() {
        View.viewAllStudents(studentsList);
    }

}
