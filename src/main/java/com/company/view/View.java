package com.company.view;

import com.company.models.users.User;
import com.company.models.users.employees.Mentor;
import com.company.models.users.employees.RegularEmployee;
import com.company.models.users.students.Student;
import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;

import java.util.ArrayList;
import java.util.List;

public class View {

    public void viewAllStudents(List<User> students) {
        System.out.println(FlipTableConverters.fromIterable(students, User.class));
    }

    public void viewAllMentors(ArrayList<Mentor> mentors) {

    }

    public void viewAllRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {

    }

    public void viewGrades(Student student) {

    }
}
