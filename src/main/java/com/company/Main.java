package com.company;

import com.company.controllers.ApplicationController;

import java.io.FileNotFoundException;

// TODO:
//      - Attendance file appears after closing program
//      - Delete empty branches (2)
//      - Handle more exceptions
//      - While loops for inputs
//      - Checks for nulls
//                  getMentorFromListByUsername() {
//                      return Optional.ofNullable(user)
//                    }
//      - more default accsess modifiers
//      - in controllers constructors(User user, UserDao, dao) {}
//      - more handled inputs and scanners
//      - possibly make abstraction class CsvLine instead of List<List<String>>

// comment just for push branch

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new ApplicationController();
    }
}
