package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.users.User;
import com.company.models.users.employees.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerDAO implements UserDAO {

    int idIndex = 0;
    int usernameIndex = 1;
    int passwordIndex = 2;
    int nameIndex = 3;
    int surnameIndex = 4;
    int roleIndex = 5;

    private CsvParser csvParser;
    private List<List<String>> listOfRecords;
    private Manager manager;
    private String filepathOfUsersCsv = "src/main/resources/users.csv";

    public ManagerDAO() { // with parameter??
        this.csvParser = new CsvParser(filepathOfUsersCsv);
        listOfRecords = new ArrayList<>();
    }

    @Override
    public void write(User user) {
        String[] toStringArrayManager = toStringArray(this.manager);
        csvParser.addNewRecord(toStringArrayManager);
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }

    public User readManager() {
        this.listOfRecords = csvParser.getUpdatedList();
        for (int i = 0; i < listOfRecords.size(); i++) {
            if (listOfRecords.get(i).get(roleIndex).equals("manager")) {
                this.manager = new Manager(Integer.parseInt(listOfRecords.get(i).get(idIndex))
                        , listOfRecords.get(i).get(usernameIndex)
                        , listOfRecords.get(i).get(passwordIndex)
                        , listOfRecords.get(i).get(nameIndex)
                        , listOfRecords.get(i).get(surnameIndex)
                        , listOfRecords.get(i).get(roleIndex));
            }
        }
        return this.manager;
    }

    @Override
    public User read(User user) {
        return null;
    }

    private String toString(Manager manager) {

        return null;
    }

    private String[] toStringArray(Manager manager) {

        return null;
    }
}
