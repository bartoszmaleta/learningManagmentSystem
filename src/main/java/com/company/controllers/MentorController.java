package com.company.controllers;

import com.company.dao.AssignmentDao;
import com.company.dao.AssignmentDaoFromCsv;
import com.company.dao.UserDaoFromCSV;
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
    UserDaoFromCSV userDaoFromCSV;
    private List<User> studentsList;
    private HashMap<String, ArrayList<User>> classes;
    private List <Assignment> assignmentsList;
    private AssignmentDaoFromCsv assignmentDaoFromCsv;

    public MentorController(User user) {
        this.user = user;
        userDaoFromCSV = new UserDaoFromCSV();
        studentsList = userDaoFromCSV.extractUserFromListByRoleGiven("student");
        assignmentsList = assignmentDaoFromCsv.extractAllAssignments();
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
//                    displayStudents();
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
                    int studentId = TerminalManager.askForInt("Enter id of student you want to edit");
                    User studentToEdit = getStudentFromListById(studentId);
                    MentorMenu.displaySecondEditingStudentMenu();
                    editStudent(studentToEdit);
                    break;
                case 5:
                    Assignment assignmentToAdd = getAssignmentFromProvidedData();
                    addAssignment(assignmentToAdd);
                    break;
                case 6:
                    // TODO
                    displayStudents();
//                    int studentId = TerminalManager.askForInt("Enter id of student You want to grade");
//                    User studentToEdit = getStudentFromListById(studentId);
//
//                    gradeStudentAssignment();
                    break;
                case 7:
                    // TODO
                    checkAttendence();
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");

            }
        }
    }

    private Assignment getAssignmentFromProvidedData() {
        int id = this.assignmentDaoFromCsv.getLastIndex() - 1;
        String title = TerminalManager.askForString("Enter title of assignment: ");
        String studentUsername = TerminalManager.askForString("Enter student's username: ");

        return new Assignment(id, title, studentUsername, this.user.getName(), false);
    }

    public void addAssignment(Assignment assignment) {
        this.assignmentsList.add(assignment);
        this.assignmentDaoFromCsv.write(assignment);
    }

    public void gradeStudentAssignment(Student student, String assignmentTitle) {

    }

    public void addStudentToClass(Student student) {

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
        this.userDaoFromCSV.edit(student);
    }

    @Override
    public void displayStudents() {
        View.viewAllStudents(studentsList);
    }
}
