package com.company.controllers;

import com.company.dao.*;
import com.company.dao.Parser.CsvParser;
import com.company.models.Assignment;
import com.company.models.Attendence;
import com.company.models.Class;
import com.company.models.Grade;
import com.company.models.users.User;
import com.company.service.TerminalManager;
import com.company.service.TerminalView;
import com.company.view.View;
import com.company.view.menu.MentorMenu;
import com.github.tomaslanger.chalk.Chalk;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MentorController implements EmployeeController, Controller {
    private User user;
    UserDaoFromCSV userDaoFromCSV;
    private List<User> studentsList;
    private HashMap<String, ArrayList<User>> classes;
    private List<Assignment> assignmentsList;
    private AssignmentDaoFromCsv assignmentDaoFromCsv;
    private ClassesDaoFromCsv classesDaoFromCsv;
    private List<Class> classesList;
    private GradesDaoFromCsv gradesDaoFromCsv;
    private List<Grade> gradesList;

    public MentorController(User user) {
        this.user = user;

        userDaoFromCSV = new UserDaoFromCSV();
        studentsList = userDaoFromCSV.extractUsersFromListOfRecordsByRoleGiven("student");

        assignmentDaoFromCsv = new AssignmentDaoFromCsv();
        assignmentsList = assignmentDaoFromCsv.extractAllAssignments();

        classesDaoFromCsv = new ClassesDaoFromCsv();
        classesList = classesDaoFromCsv.extractAllClassesFromList();

        gradesDaoFromCsv = new GradesDaoFromCsv();
        gradesList = gradesDaoFromCsv.extractAllGrades();
    }

    @Override
    public void init() throws FileNotFoundException {
        boolean isRunning = true;

        TerminalView.clearScreen();

        while (isRunning) {
            MentorMenu.displayMenu();

            int choice = TerminalManager.takeIntInputWithoutMessage();
            switch (choice) {
                case 1:
                    displayStudents();
                    checkAttendence();
                    // TODO: to check! cant show because creates after stop!
//                    displayAttendances();
                    break;
                case 2:
                    TerminalView.clearScreen();
                    displayStudents();
                    int studentIdToAddToClass = TerminalManager.askForInt("Enter id of student You want to add to class");
                    User studentToClass = getStudentFromListById(studentIdToAddToClass);

                    displayAllClasses();
//                    displayAllClassesNames();  // TODO: should show just classes names
                    String className = TerminalManager.askForString("Enter name of class to which add student: ");
                    Class classToAdd = getClassFromListByClassName(studentToClass, className);

                    addStudentToClass(classToAdd);
                    break;
                case 3:
                    TerminalView.clearScreen();

                    displayAllClasses();
                    Class classFromWhichStudentShouldBeRemoved = getClassFromProvidedData();
                    removeStudentFromClass(classFromWhichStudentShouldBeRemoved);
                    break;
                case 4:
                    TerminalView.clearScreen();

                    MentorMenu.displayFirstEditingStudentMenu();
                    displayStudents();
//                    String studentUsernameToEdit = TerminalManager.askForString("Enter username of student you want to edit");
//                    User studentToEdit = getStudentFromListByUsername(studentUsernameToEdit);
                    int studentId = TerminalManager.askForInt("Enter id of student You want to edit");
                    User studentToEdit = getStudentFromListById(studentId);
                    MentorMenu.displaySecondEditingStudentMenu();
                    editStudent(studentToEdit);
                    break;
                case 5:
                    TerminalView.clearScreen();

                    displayAllAssignments();
                    Assignment assignmentToAdd = getAssignmentFromProvidedData();
                    addAssignment(assignmentToAdd);
                    break;
                case 6:
                    TerminalView.clearScreen();

                    // TODO: to check!
                    displayMyStudents();
                    int studentIdToGrade = TerminalManager.askForInt("Enter id of student You want to grade");
                    User studentToGrade = getStudentFromListById(studentIdToGrade);
                    String assignmentTitleToGrade = TerminalManager.askForString("Enter title of assignment to grade");

                    System.out.println("213");
                    System.out.println(studentToGrade.getName());
                    System.out.println("213");

                    Grade gradeToAdd = getGradeFromProvidedData(studentToGrade, assignmentTitleToGrade);

                    addGradeToGrades(gradeToAdd);
                    break;
                case 7:
                    TerminalView.clearScreen();
                    displayStudents();
                    break;
                case 8:
                    TerminalView.clearScreen();
                    displayMyStudents();
                    break;
                case 9:
                    TerminalView.clearScreen();
                    displayAllGrades();
                    break;
                case 10:
                    TerminalView.clearScreen();
                    displayAllAssignments();
                    break;
                case 11:
                    TerminalView.clearScreen();
                    displayAllClasses();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private void displayAllGrades() {
        View.viewAllGrades(gradesList);
    }

    private Grade getGradeFromProvidedData(User studentToGrade, String assignmentTitleToGrade) {
        int id = this.gradesList.get(this.gradesList.size() - 1).getId() + 1;
        System.out.println("21sd3");

        String assignmentTitle = assignmentTitleToGrade;
        System.out.println("213");
        String studentUsername = studentToGrade.getUsername();
        System.out.println("21ww3");

        int markForAssignment = TerminalManager.askForInt("Enter mark You want to grade "
                + Chalk.on(studentUsername).green() + " for assignment " + Chalk.on(assignmentTitle).green());

        Grade grade = new Grade(id, assignmentTitle, studentUsername, markForAssignment);
        return grade;
    }

    private void displayMyStudents() {
        List<Class> myClasses = classesDaoFromCsv.extractClassesFromListByMentorName(this.user.getName());
        View.viewAllClasses(myClasses);
    }

    private void displayAllClasses() {
        View.viewAllClasses(classesList);
    }

    private Class getClassFromProvidedData() {
        String studentUsernameToRemove = TerminalManager.askForString("Enter username of student You want to remove from class");
        String classToRemove = TerminalManager.askForString("Enter name of class You want to remove student from: ");

        for (Class classOb : classesList) {
            if (classOb.getStudentUsername().equals(studentUsernameToRemove)
                    && classOb.getTitle().equals(classToRemove)) {
                return classOb;
            }
        }
        TerminalManager.printString("No class found. Provide better data!");
        return null;
    }

    private Class getClassFromListByClassName(User student, String className) {
        int id = this.classesList.get(this.classesList.size() - 1).getId() + 1;
        String studentName = student.getName();
        String mentorName = this.user.getName();

        return new Class(id, className, studentName, mentorName);
    }

    private void displayAllClassesNames() {
        View.viewClassesNames(classesList);
//        View.viewAllClasses(classesList);
    }

    private Assignment getAssignmentFromProvidedData() {
//        int id = this.assignmentDaoFromCsv.getLastIndex() + 1;
        int id = this.assignmentsList.get(this.assignmentsList.size() - 1).getId() + 1;
        String title = TerminalManager.askForString("Enter title of assignment: ");
        String studentUsername = TerminalManager.askForString("Enter student's username: ");

        return new Assignment(id, title, studentUsername, this.user.getName(), false);
    }

    public void addAssignment(Assignment assignment) {
        this.assignmentsList.add(assignment);
        this.assignmentDaoFromCsv.write(assignment);
    }

    public void addGradeToGrades(Grade grade) {
        this.gradesList.add(grade);
        this.gradesDaoFromCsv.write(grade);
    }

    public void addStudentToClass(Class classToAdd) {
        this.classesList.add(classToAdd);
        this.classesDaoFromCsv.write(classToAdd);
    }

    public void removeStudentFromClass(Class classToRemoveFrom) {
        this.classesList.remove(classToRemoveFrom);
        this.classesDaoFromCsv.remove(classToRemoveFrom);
    }

    public void checkAttendence2() {
        Path path = Paths.get("");
        Path absolutePath = path.toAbsolutePath();
        String location = absolutePath.toString() + "/src/main/resources/attendences/";

        String locationWithDate = location + "attendence" + LocalDate.now();
        CsvParser csvParser = new CsvParser(locationWithDate);

        String[] headers = {"id", "studentUsername", "date", "isPresent"};

        for (int i = 0; i < this.studentsList.size(); i++) {
            String isPresentStudent = TerminalManager.
                    askForString("Is student with name "
                            + this.studentsList.get(i).getName() + " present today?");
            Attendence attendence = new Attendence(i + 1
                    , LocalDate.now()
                    , this.studentsList.get(i).getUsername()
                    , isPresentStudent);
            if (i == 0) {
                csvParser.addFirstRecord(attendence.toStringArray(), headers);
            } else {
                csvParser.addNewRecord(attendence.toStringArray());
            }
        }
    }

    public void checkAttendence() throws FileNotFoundException {
        AttendenceDaoFromCsv attendenceDaoFromCsv = new AttendenceDaoFromCsv();

        String[] headers = {"id", "studentUsername", "date", "isPresent"};

        for (int i = 0; i < this.studentsList.size(); i++) {
            String isPresentStudent = TerminalManager.
                    askForString("Is student with name "
                            + this.studentsList.get(i).getName() + " present today?");
            Attendence attendence = new Attendence(i + 1
                    , LocalDate.now()
                    , this.studentsList.get(i).getUsername()
                    , isPresentStudent);
            if (i == 0) {
                attendenceDaoFromCsv.writeFirstRecord(attendence, headers);
            } else {
                attendenceDaoFromCsv.write(attendence);
            }
        }
    }

    public User getStudentFromListByUsername(String username) {
        for (User user : studentsList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getStudentFromListById(int id) {
        for (User user : studentsList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void editStudent(User student) {
        int option = TerminalManager.takeIntInputWithoutMessage();
        switch (option) {
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
                String password = TerminalManager.askForString("Enter student's new password: ");
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

    public void displayAllAssignments() {
        View.viewAllAssignments(assignmentsList);
    }
}
