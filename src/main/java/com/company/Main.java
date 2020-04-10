package com.company;

import com.company.controllers.LoginController;
import com.company.controllers.MentorController;
import com.company.dao.Parser.CsvParser;
import com.company.models.users.User;
import com.company.view.View;


import java.io.FileNotFoundException;

// TODO:
//      - attendance file appears after closing program
//      -

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LoginController logging = new LoginController();
        logging.init();

    }
}
