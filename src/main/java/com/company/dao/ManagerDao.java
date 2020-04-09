package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.users.User;
import com.company.models.users.employees.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerDao implements UserDao {

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
    public ManagerDao() { // with parameter??
        this.csvParser = new CsvParser(filepathOfUsersCsv);
        listOfRecords = new ArrayList<>();
    }

    public CsvParser getCsvParser() {
        return csvParser;
    }

    @Override
    public void write(User user) {
        String[] toStringArrayManager = toStringArray(user);
        csvParser.addNewRecord(toStringArrayManager);
    }

    public String[] toStringArray(User user) {
        String[] managaerArray = {String.valueOf(user.getId())
                , user.getUsername()
                , user.getName()
                , user.getSurname()
                , user.getRole()};
        return managaerArray;
    }

    @Override
    public User readUserByUsernameAndPassword(String usernameGiven, String passwordGiven) {
        return null;
    }

    @Override
    public List<User> extractUserFromListByRoleGiven(String roleForList) {
        return null;
    }

    @Override
    public int getLastIndex() {
        return 0;
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
    public void remove(User user) {

    }

    @Override
    public void edit(User user) {

    }

    private String toString(User user) {

        return null;
    }
}
