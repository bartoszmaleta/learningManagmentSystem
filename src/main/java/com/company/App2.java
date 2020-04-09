package com.company;

import com.company.controllers.LoginController;
import com.company.controllers.MentorController;
import com.company.dao.Parser.CsvParser;
import com.company.dao.UserDAOFromCSV;
import com.company.models.users.User;
import com.company.view.View;


import java.io.FileNotFoundException;

public class App2 {
    public static void main(String[] args) throws Exception {
//        LoginController logging = new LoginController();
//        logging.init();

//        UserDAOFromCSV userDAOFromCSV = new UserDAOFromCSV();
//        List<User> students = userDAOFromCSV.extractUserFromListByRoleGiven("student");
//
//        System.out.println(students);
//        View.viewAllStudents(students);
        MentorController mentorController = new MentorController(new User(1, "2", "3", "4", "5", "6"));
        mentorController.init();
    }
}
