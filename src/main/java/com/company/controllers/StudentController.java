package com.company.controllers;

import com.company.dao.AssignmentDaoFromCsv;
import com.company.models.Assignment;
import com.company.models.Grade;
import com.company.models.users.User;
import com.company.service.TerminalManager;
import com.company.view.View;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    Scanner scanner = new Scanner(System.in);
    private User user;
    private List<Assignment> assignments;
    private List<Grade> grades;
    AssignmentDaoFromCsv assignmentDAOFromCSV;
    GradesDAOFromCsv gradesDAOFromCsv;


    public StudentController(User user) {
        System.out.println("Student Controller constructor here");
        assignments = assignmentDAOFromCSV.extractAssignmentsFromListByStudentUsername(user.getUsername());
        grades = gradesDAOFromCsv.extractGradesListByUsername(user.getUsername());
    }

    public void init() {
        boolean isRunning = true;
//        TerminalView.displayWelcomeScreen();

        while (isRunning) {
//            TerminalView.clearScreen();
            StudentMenu.displayMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    View.viewAllGrades(grades);
                    break;
                case 2:
                    View.viewAllAssignments(assignments);
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

    private void submitAssignment(Grade gradeToEdit) {


    }

    public Grade getGradeFromListById(int idOfGrade) {
        for(Grade grade : grades) {
            if (grade.getId() == idOfGrade) {
                return grade;
            }
        }
        return null;
    }

    public Assignment getAssignmentFromListById(int idOfAssignment) {
        for(Assignment assignment : assignments) {
            if (assignment.getId() == idOfAssignment) {
                return assignment;
            }
        }
        return null;
    }


    public void displayGrades() {

    }

    public void submitAssignment(Assignment assignment) {
        assignment.setIsSubmittedTrue();
        this.assignmentDAOFromCSV.edit(assignment);
    }


}
