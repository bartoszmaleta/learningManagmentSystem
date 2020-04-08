package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.users.User;
import com.company.models.users.employees.Manager;

import java.util.ArrayList;
import java.util.List;

public class UserDAOFromCSV implements UserDAO {

    int idIndex = 0;
    int usernameIndex = 1;
    int passwordIndex = 2;
    int nameIndex = 3;
    int surnameIndex = 4;
    int roleIndex = 5;

    private CsvParser csvParser;
    private List<List<String>> listOfRecords;
    private User user;
    private String filepathOfUsersCsv = "src/main/resources/users.csv";

    public UserDAOFromCSV() { // with parameter??
        this.csvParser = new CsvParser(filepathOfUsersCsv);
        listOfRecords = new ArrayList<>();
    }

    public CsvParser getCsvParser() {
        return csvParser;
    }

    @Override
    public void write(User user) {
        String[] toStringArrayUser = toStringArray(user);
        csvParser.addNewRecord(toStringArrayUser);
    }

    private String[] toStringArray(User user) {
        String[] userArray = {String.valueOf(user.getId())
                , user.getUsername()
                , user.getName()
                , user.getSurname()
                , user.getRole()};
        return userArray;
    }

    public User readUserByUsernameAndPassword(String usernameGiven, String passwordGiven) {
        this.listOfRecords = csvParser.getUpdatedList();

        for (int i = 0; i < listOfRecords.size(); i++) {
            if (listOfRecords.get(i).get(usernameIndex).equals(usernameGiven)
                    && listOfRecords.get(i).get(passwordIndex).equals(passwordGiven)) {
                System.out.println("Found!");

                this.user = new User(Integer.parseInt(listOfRecords.get(i).get(idIndex))
                        , listOfRecords.get(i).get(usernameIndex)
                        , listOfRecords.get(i).get(passwordIndex)
                        , listOfRecords.get(i).get(nameIndex)
                        , listOfRecords.get(i).get(surnameIndex)
                        , listOfRecords.get(i).get(roleIndex)) {
                };
            }
        }
        return this.user;
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User read(User user) {
        return null;
    }

    private String toString(User user) {

        return null;
    }
}
