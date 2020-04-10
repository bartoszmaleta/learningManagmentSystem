package com.company.controllers;

import com.company.dao.AssignmentDaoFromCsv;
import com.company.dao.GradeDaoFromCsv;
import com.company.models.Assignment;
import com.company.models.Grade;
import com.company.models.users.User;
import com.company.service.DataHandler;
import com.company.service.TerminalManager;
import com.company.service.TerminalView;
import com.company.view.View;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class StudentController implements Controller {

    private final Path path = Paths.get("");
    private final Path absolutePath = path.toAbsolutePath();
    private final String location = absolutePath.toString() + "/src/main/resources/Menu CcMS/Small/";

    private Scanner scanner = new Scanner(System.in);

    private User user;
    private List<Assignment> assignments;
    private List<Grade> grades;
    private AssignmentDaoFromCsv assignmentDAOFromCSV;
    private GradeDaoFromCsv gradeDaoFromCsv;


    public StudentController(User user) {
        this.user = user;
        assignmentDAOFromCSV = new AssignmentDaoFromCsv();
        assignments = assignmentDAOFromCSV.extractAssignmentsFromListByStudentUsername(user.getUsername());
        gradeDaoFromCsv = new GradeDaoFromCsv();
        grades = gradeDaoFromCsv.extractGradesFromListByStudentUsername(user.getUsername());
    }

    @Override
    public void init() throws FileNotFoundException {
        boolean isRunning = true;

        while (isRunning) {
            TerminalView.clearScreen();

            DataHandler.printFromFile(location + "StudentMenu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TerminalView.clearScreen();
                    displayGrades();
                    break;
                case 2:
                    TerminalView.clearScreen();
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

    public void displayAssignments() throws FileNotFoundException {
        View.viewAllAssignments(assignments);
    }


    public void displayGrades() throws FileNotFoundException {
        View.viewAllGrades(grades);
    }

    public void submitAssignment(Assignment assignment) {
        assignment.setIsSubmittedTrue();
        this.assignmentDAOFromCSV.edit(assignment);
    }


}
