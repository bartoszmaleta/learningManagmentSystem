package com.company.view;

import com.company.models.Assignment;
import com.company.models.Class;
import com.company.models.Grade;
import com.company.models.users.User;
import com.company.models.users.employees.Mentor;
import com.company.models.users.employees.RegularEmployee;
import com.company.models.users.students.Student;
import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class View {

    public static void viewAllStudents(List<User> students) {

//        List<User> legacyDeepCopy = new ArrayList<>();
//        for (User originalHero : students) {
//            legacyDeepCopy.add(new User(originalHero));
//        }
//
//        for (User user : legacyDeepCopy) {
//            user.setPassword("*********");
//        }

//        System.out.println("normal student 0 pass = " + students.get(0).getPassword());
//        System.out.println("copied student 0 pass = " + legacyDeepCopy.get(0).getPassword());
        //        String[] studentsHeader = { "id", "login", "password", "name", "surname", "role" };
        System.out.println(FlipTableConverters.fromIterable(students, User.class));
//        System.out.println(FlipTableConverters.fromIterable(legacyDeepCopy, User.class));
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

    public static void viewAllClasses(List<Class> classesList) {
        System.out.println(FlipTableConverters.fromIterable(classesList, Class.class));
    }

    public static void viewClassesNames(List<Class> classList) {
        String[] header = {"ID", "Name"};
        Object[][] data = new Object[classList.size()][header.length];

        for (int i = 0; i < classList.size(); i++) {
            Class classObject = classList.get(i);
            data[i][0] = classObject.getId();
        }

        System.out.println(FlipTableConverters.fromObjects(header, data));
    }
}
