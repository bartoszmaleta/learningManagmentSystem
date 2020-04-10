package com.company.view;

import com.company.models.Assignment;
import com.company.models.Class;
import com.company.models.Grade;
import com.company.models.users.User;
import com.company.models.users.notUsedModels.employees.RegularEmployee;
import com.company.service.DataHandler;
import com.jakewharton.fliptables.FlipTableConverters;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class View {

    private final static Path path = Paths.get("");
    private final static Path absolutePath = path.toAbsolutePath();
    private final static String location = absolutePath.toString() + "/src/main/resources/Menu CcMS/Small/";

    public static void viewAllStudents(List<User> students) throws FileNotFoundException {

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
        //
        DataHandler.printFromFile(location + "AllStudents");
        System.out.println(FlipTableConverters.fromIterable(students, User.class));
//        System.out.println(FlipTableConverters.fromIterable(legacyDeepCopy, User.class));
    }

    public static void viewAllMentors(List<User> mentors) throws FileNotFoundException {
        DataHandler.printFromFile(location + "MentorsList");
        System.out.println(FlipTableConverters.fromIterable(mentors, User.class));
    }

    public static void viewAllRegularEmployees(List<RegularEmployee> regularEmployees) {
//        System.out.println(FlipTableConverters.fromIterable(regularEmployees, User.class));
    }

    public static void viewAllGrades(List<Grade> grades) throws FileNotFoundException {
        DataHandler.printFromFile(location + "AllGrades");
        System.out.println(FlipTableConverters.fromIterable(grades, Grade.class));
    }

    public static void viewAllAssignments(List<Assignment> assignments) throws FileNotFoundException {
        DataHandler.printFromFile(location + "Assignments");
        System.out.println(FlipTableConverters.fromIterable(assignments, Assignment.class));
    }

    public static void viewAllClasses(List<Class> classesList) throws FileNotFoundException {
        DataHandler.printFromFile(location + "MentorClassList");
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
