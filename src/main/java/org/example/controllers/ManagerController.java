package org.example.controllers;

import org.example.models.users.User;
import org.example.models.users.employees.Mentor;
import org.example.models.users.employees.RegularEmployee;
import org.example.models.users.students.Student;

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
