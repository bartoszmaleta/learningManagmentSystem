package com.company.controllers;

import com.company.dao.UserDAOFromCSV;
import com.company.models.Assignment;
import com.company.models.users.User;
import com.company.models.users.students.Student;
import com.company.service.TerminalManager;
import com.company.view.View;
import com.company.view.menu.MentorMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MentorController implements Employee {
    private User user;
    UserDAOFromCSV userDAOFromCSV;
    private List<User> studentsList;
    private HashMap<String, ArrayList<User>> classes; //there will be class name as string
    private List <Assignment> assignmentsList;

    public MentorController(User user) {
        this.user = user;
        userDAOFromCSV = new UserDAOFromCSV();
        studentsList = new UserDAOFromCSV().extractUserFromListByRoleGiven("student");
    }


    public void init()  {
        boolean isRunning = true;

        while(isRunning) {
    //        TerminalView.clearScreen();
            MentorMenu.displayMenu();

            int choice = TerminalManager.takeIntInputWithoutMessage();
            switch(choice) {
                case 1:
                    displayStudents();
                    break;
                case 2:
//                    addStudentToClass();
                    break;
                case 3:
//                    removeStudentFromClass();
                    break;
                case 4:
                    MentorMenu.displayFirstEditingStudentMenu();
                    displayStudents();
//                    String studentUsernameToEdit = TerminalManager.askForString("Enter username of student you want to edit");
//                    User studentToEdit = getStudentFromListByUsername(studentUsernameToEdit);
                    int studentId = TerminalManager.askForInt("Enter id ow student you want to edit");
                    User studentToEdit = getStudentFromListById(studentId);
                    MentorMenu.displaySecondEditingStudentMenu();
                    editStudent(studentToEdit);
                    break;
                case 5:
//                    gradeStudentAssignment();
                    break;
                case 6:
                    checkAttendence();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");


            }
        }

    }

    public void addAssignment(Assignment assignment) {

    }

    public void gradeStudentAssignment(Student student, String assignmentTitle) {

    }

    public void addStudentToClass(Student studen) {

    }

    public void removeStudentFromClass(Student student) {

    }

    public void checkAttendence() {

    }

    public User getStudentFromListByUsername(String username) {
        for(User user: studentsList) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getStudentFromListById(int id) {
        for(User user: studentsList) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void editStudent(User student) {
        int option = TerminalManager.takeIntInputWithoutMessage();
        switch(option) {
            case 1:
                String newUsername = TerminalManager.askForString("Enter student's new username: ");
                student.setUsername(newUsername);
                break;
            case 2:
                String newPassword = TerminalManager.askForString("Enter student's new password: ");
                student.setPassword(newPassword);
                break;
            case 3:
                String newName = TerminalManager.askForString("Enter student's new name: ");
                student.setName(newName);
                break;
            case 4:
                String newSurname = TerminalManager.askForString("Enter student's new surname: ");
                student.setSurname(newSurname);
                break;
            case 5:
                String username = TerminalManager.askForString("Enter student's new username: ");
                student.setUsername(username);
                String password= TerminalManager.askForString("Enter student's new password: ");
                student.setPassword(password);
                String name = TerminalManager.askForString("Enter student's new name: ");
                student.setName(name);
                String surname = TerminalManager.askForString("Enter student's new surname: ");
                student.setSurname(surname);
                break;
        }
        this.userDAOFromCSV.edit(student);
    }

    @Override
    public void displayStudents() {
        View.viewAllStudents(studentsList);
    }


}
