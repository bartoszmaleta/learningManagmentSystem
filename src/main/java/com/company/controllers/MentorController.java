package com.company.controllers;

import com.company.models.Assignment;
import com.company.models.users.User;
import com.company.models.users.students.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class MentorController implements Employee {
    private User user;
    private ArrayList<Student> studentsList;
    private HashMap<String, ArrayList<Student>> classes; //there will be class name as string
    private ArrayList<Assignment> assignmentsList;

    public MentorController(User user) {
        System.out.println("Mentor Controller here");

        this.user = user;
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

    @Override
    public void displayStudents() {

    }

    public void init() {
        System.out.println("Mentor Controller here");

    }
}
