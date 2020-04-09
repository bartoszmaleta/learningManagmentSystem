package com.company.view;

import com.company.models.Assignment;
import com.company.models.Grade;
import com.company.models.users.User;
import com.company.models.users.employees.Mentor;
import com.company.models.users.employees.RegularEmployee;
import com.company.models.users.students.Student;
import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;

import java.util.ArrayList;
import java.util.List;

public class View {

    public static void viewAllStudents(List<User> students) {
//        String[] studentsHeader = { "id", "login", "password", "name", "surname", "role" };
        System.out.println(FlipTableConverters.fromIterable(students, User.class));
    }

    public static void viewAllMentors(List<User> mentors) {
        System.out.println(FlipTableConverters.fromIterable(mentors, User.class));

    }

    public static void viewAllRegularEmployees(List<RegularEmployee> regularEmployees) {
//        System.out.println(FlipTableConverters.fromIterable(regularEmployees, User.class));
    }

    public static void viewAllGrades(List<Grade> grades) {
        // TODO is it okay Staszek?
        System.out.println(FlipTableConverters.fromIterable(grades, Grade.class));
    }

    public static void viewAllAssignments(List<Assignment> assignments) {
        // TODO is it okay Staszek?
        System.out.println(FlipTableConverters.fromIterable(assignments, Assignment.class));
    }
}
