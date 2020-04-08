package com.company.controllers;

import com.company.dao.MentorDAO;
import com.company.dao.RegularEmployeeDAO;
import com.company.dao.StudentDAO;
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
    private List <Mentor> mentorList;
    private List <Student> studentsList;
    private List <RegularEmployee> regularEmployees;
    Scanner scanner = new Scanner(System.in);

    public ManagerController(User user) {
        System.out.println("Manager Controller constructor here");
        this.user = user;
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
                    Mentor mentorToAdd = getMentorFromProvidedData();
                    addMentor(mentorToAdd);
                    break;
                case 2:
                    displayMentors();
                    String usernameOfMentorToRemove = TerminalManager.askForString("Enter username of mentor you want to remove: ");
                    removeMentor(getMentorFromListByUsername(usernameOfMentorToRemove));
                    break;
                case 3:
                    ManagerMenu.displayFirstEditingMentorMenu();
                    View.viewAllMentors(mentorList);
                    String usernameOfMentorToEdit = TerminalManager.askForString("\n" + "Enter username of mentor you want to edit: ");
                    Mentor mentorToEdit = getMentorFromListByUsername(usernameOfMentorToEdit);
                    ManagerMenu.displaySecondEditingMentorMenu();
                    editMentor(mentorToEdit);
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }


    public void addMentor(Mentor mentor) {
        mentorList.add(mentor);
    }

    public void removeMentor(Mentor mentor) {
        mentorList.remove(mentor);
    }

    public void editMentor(Mentor mentor) {
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
    }
    public Mentor getMentorFromProvidedData() {
        int id = TerminalManager.askForInt("Enter mentor's id: ");
        String username = TerminalManager.askForString("Enter mentor's username: ");
        String password = TerminalManager.askForString("Enter mentor's password: ");
        String name = TerminalManager.askForString("Enter mentor's name: ");
        String surname = TerminalManager.askForString("Enter mentor's surname: ");

        return new Mentor(id, username, password, name, surname, "mentor");
    }

    public Mentor getMentorFromListByUsername(String username) {
        for(Mentor mentor: mentorList) {
            if(mentor.getUsername().equals(username)) {
                return mentor;
            }
        }
        return null;
    }

    public void displayMentors() {
        View.viewAllMentors(mentorList);
    }

    public void getMentorFromList(Mentor mentor) {
        mentorList.get(mentorList.indexOf(mentor));
    }
    @Override
    public void displayStudents() {
        View.viewAllStudents(studentsList);
    }

    public void init() {        System.out.println("Manager Controller init here ");

    }
}
