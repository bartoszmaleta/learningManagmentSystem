package com.company;

import com.company.controllers.LoginController;
import com.company.dao.Parser.CsvParser;
import com.company.dao.UserDAOFromCSV;
import com.company.models.users.User;
import com.company.view.View;

import java.io.FileNotFoundException;
import java.util.List;

public class App2 {
    public static void main(String[] args) throws FileNotFoundException {
//        LoginController logging = new LoginController();
//        logging.init();

        CsvParser csvParser = new CsvParser("src/main/resources/users.csv");
        UserDAOFromCSV userDAOFromCSV = new UserDAOFromCSV();
        List<User> students = userDAOFromCSV.extractUserFromListByRoleGiven("student");
//        view.viewAllStudents(studentDAO.extractUserFromList(csvParser.getListOfLines()));

        System.out.println(students);
//        System.out.println(students.get(0).getName());
        View.viewAllStudents(students);

    }
}
