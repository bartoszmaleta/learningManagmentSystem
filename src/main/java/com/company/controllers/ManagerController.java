package com.company.controllers;

import com.company.models.users.User;
import com.company.models.users.employees.Mentor;
import com.company.models.users.employees.RegularEmployee;
import com.company.models.users.students.Student;

import java.util.ArrayList;

public class ManagerController implements Employee{
    private User user;
    private ArrayList <Mentor> mentorList;
    private ArrayList <Student> studentsList;
    private ArrayList <RegularEmployee> regularEmployees;


    public void addMentor(Mentor mentor) {

    }

    public void removeMentor(Mentor mentor) {

    }

    public void editMentor() {

    }

    @Override
    public void displayStudents() {

    }
}
