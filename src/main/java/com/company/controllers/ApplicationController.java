package com.company.controllers;

import com.company.service.TerminalManager;
import com.company.service.TerminalView;

import java.io.FileNotFoundException;

public class ApplicationController {

    public ApplicationController() throws FileNotFoundException {
        TerminalView.displayWelcomeScreen();
        LoginController loginController = new LoginController();
        loginController.init();
    }
}
