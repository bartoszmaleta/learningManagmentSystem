package com.company;

import com.company.controllers.LoginController;
import com.company.dao.Parser.CsvParser;
import com.company.dao.UserDAOFromCSV;
import com.company.models.users.User;
import com.company.view.View;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LoginController logging = new LoginController();
        logging.init();

//        UserDAOFromCSV userDAOFromCSV = new UserDAOFromCSV();
//        List<User> students = userDAOFromCSV.extractUserFromListByRoleGiven("student");
//
//        System.out.println(students);
//        View.viewAllStudents(students);

    }
}
