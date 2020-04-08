package com.company.controllers;

import com.company.models.Assignment;
import com.company.models.users.User;

public class StudentController {
    private User user;

    public StudentController(User user) {
        System.out.println("Student Controller constructor here");

    }

    public void displayGrades() {

    }

    public void submitAssignment(Assignment assignment) {

    }

    public void init() {
        System.out.println("Student Controller init here");

    }
}
