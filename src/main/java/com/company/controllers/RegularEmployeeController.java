package com.company.controllers;

import com.company.models.users.User;

public class RegularEmployeeController implements EmployeeController {
    private User user;

    public RegularEmployeeController(User user) {
        System.out.println("Regular Employee Controller constructor here");

    }

    @Override
    public void displayStudents() {

    }

    public void init() {
        System.out.println("Regular Employee Controller init here ");
    }
}
