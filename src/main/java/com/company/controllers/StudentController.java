package com.company.controllers;

import com.company.dao.AssignmentDaoFromCsv;
import com.company.dao.GradesDaoFromCsv;
import com.company.models.Assignment;
import com.company.models.Grade;
import com.company.models.users.User;
import com.company.service.DataHandler;
import com.company.service.TerminalManager;
import com.company.view.View;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class StudentController implements Controller {

    Path path = Paths.get("");
    Path absolutePath = path.toAbsolutePath();
    String location = absolutePath.toString() + "/src/main/resources/Menu CcMS/Small/";

    Scanner scanner = new Scanner(System.in);
    private User user;
    private List<Assignment> assignments;
    private List<Grade> grades;
    AssignmentDaoFromCsv assignmentDAOFromCSV;
    GradesDaoFromCsv gradesDaoFromCsv;


    public StudentController(User user) {
        System.out.println("Student Controller constructor here");
        assignmentDAOFromCSV = new AssignmentDaoFromCsv();
        assignments = assignmentDAOFromCSV.extractAssignmentsFromListByStudentUsername(user.getUsername());
        gradesDaoFromCsv = new GradesDaoFromCsv();
        grades = gradesDaoFromCsv.extractGradesFromListByStudentUsername(user.getUsername());
    }

    @Override
    public void init() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
//            TerminalView.clearScreen();
//            StudentMenu.displayMenu();

            DataHandler.printFromFile(location + "StudentMenu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayGrades();
                    break;
                case 2:
                    displayAssignments();
                    int indexOfAssignmentToSubmit = TerminalManager.askForInt("Which assignment You want to submit?");
                    Assignment assignmentToSubmit = getAssignmentFromListById(indexOfAssignmentToSubmit);
                    submitAssignment(assignmentToSubmit);
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

    public Grade getGradeFromListById(int idOfGrade) {
        for (Grade grade : grades) {
            if (grade.getId() == idOfGrade) {
                return grade;
            }
        }
        return null;
    }

    public Assignment getAssignmentFromListById(int idOfAssignment) {
        for (Assignment assignment : assignments) {
            if (assignment.getId() == idOfAssignment) {
                return assignment;
            }
        }
        return null;
    }

    public void displayAssignments() {
        View.viewAllAssignments(assignments);
    }


    public void displayGrades() {
        View.viewAllGrades(grades);
    }

    public void submitAssignment(Assignment assignment) {
        assignment.setIsSubmittedTrue();
        this.assignmentDAOFromCSV.edit(assignment);
    }


}
