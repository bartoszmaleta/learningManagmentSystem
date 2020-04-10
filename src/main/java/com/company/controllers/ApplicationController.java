package com.company.controllers;

import java.io.FileNotFoundException;

public class ApplicationController {

    public ApplicationController() throws FileNotFoundException {
        LoginController loginController = new LoginController();
        loginController.init();
    }
}
