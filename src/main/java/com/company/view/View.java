package com.company.view;

import com.company.dao.UserDaoFromCSV;
import com.company.models.Assignment;
import com.company.models.Class;
import com.company.models.Grade;
import com.company.models.users.User;
import com.company.models.users.notUsedModels.employees.RegularEmployee;
import com.company.service.FileReader;
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
//        System.out.println(FlipTableConverters.fromIterable(legacyDeepCopy, User.class));


        //        -----------------------------------------------------------------------
        // THIS WORKS BELOW WITH HASH
        FileReader.printFromFile(location + "StudentsList");
        List<User> newList = new UserDaoFromCSV().extractUsersFromListOfRecordsByRoleGiven("student");
        String[] headers = {"id", "username", "password", "name", "surname", "role"};
        Object[][] data = new Object[newList.size()][headers.length];

        for (int i = 0; i < newList.size(); i++) {
            User user = newList.get(i);
            data[i][0] = user.getId();
            data[i][1] = user.getUsername();
//            data[i][2] = user.getPassword();
            data[i][2] = "*".repeat(user.getPassword().length());
            data[i][3] = user.getName();
            data[i][4] = user.getSurname();
            data[i][5] = user.getRole();
        }
        System.out.println(FlipTableConverters.fromObjects(headers, data));

        // THIS WORKS BELOW WITHOUT HASH
//        DataHandler.printFromFile(location + "AllStudents");
//        System.out.println(FlipTableConverters.fromIterable(students, User.class));
    }

    public static void viewAllMentors(List<User> mentors) throws FileNotFoundException {
        FileReader.printFromFile(location + "MentorsList");
        System.out.println(FlipTableConverters.fromIterable(mentors, User.class));
    }

    public static void viewAllRegularEmployees(List<RegularEmployee> regularEmployees) {
//        System.out.println(FlipTableConverters.fromIterable(regularEmployees, User.class));
    }

    public static void viewAllGrades(List<Grade> grades) throws FileNotFoundException {
        FileReader.printFromFile(location + "Grades");
        System.out.println(FlipTableConverters.fromIterable(grades, Grade.class));
    }

    public static void viewAllAssignments(List<Assignment> assignments) throws FileNotFoundException {
        FileReader.printFromFile(location + "Assignments");
        System.out.println(FlipTableConverters.fromIterable(assignments, Assignment.class));
    }

    public static void viewAllClasses(List<Class> classesList) throws FileNotFoundException {
        FileReader.printFromFile(location + "MentorClassList");
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
