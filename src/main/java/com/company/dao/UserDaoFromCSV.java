package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.users.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoFromCSV implements UserDao {

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

    public UserDaoFromCSV() { // with parameter??
        this.csvParser = new CsvParser(filepathOfUsersCsv);
        listOfRecords = csvParser.getUpdatedList();
    }

    public CsvParser getCsvParser() {
        return csvParser;
    }

    @Override
    public void write(User user) {
        String[] toStringArrayUser = toStringArray(user);
        this.csvParser.addNewRecord(toStringArrayUser);
    }

    @Override
    public String[] toStringArray(User user) {
        String[] userArray = {String.valueOf(user.getId())
                , user.getUsername()
                , user.getPassword()
                , user.getName()
                , user.getSurname()
                , user.getRole()};
        return userArray;
    }

    @Override
    public User readUserByUsernameAndPassword(String usernameGiven, String passwordGiven) {
        this.listOfRecords = csvParser.getUpdatedList();

        for (int i = 0; i < listOfRecords.size(); i++) {
            if (listOfRecords.get(i).get(usernameIndex).equals(usernameGiven)
                    && listOfRecords.get(i).get(passwordIndex).equals(passwordGiven)) {
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
    public List<User> extractUsersFromListOfRecordsByRoleGiven(String roleForList) {
        String id, login, password, name, surname, role;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            List<String> users = this.listOfRecords.get(i);
            id = users.get(0);
            login = users.get(1);
//            password = "*************";
            password = users.get(2);
            name = users.get(3);
            surname = users.get(4);
            role = users.get(5);

            if (roleForList.equals(role)) {
                userList.add(new User(Integer.parseInt(id), login, password, name, surname, role));
            }
        }
        return userList;
    }

    @Override
    public void remove(User user) {
        List<List<String>> newList;

        for (int i = 0; i < this.listOfRecords.size(); i++) {
            if (this.listOfRecords.get(i).get(0).equals(String.valueOf(user.getId()))) {
                this.listOfRecords.remove(this.listOfRecords.get(i));
            }
        }
        newList = this.listOfRecords;
        String header = "id,username,password,name,surname,role,";
        this.csvParser.updateFile(newList, header);
    }

    @Override
    public void edit(User user) {
        List<List<String>> newList;
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            if (this.listOfRecords.get(i).get(0).equals(String.valueOf(user.getId()))) {
                this.listOfRecords.get(i).set(1, user.getUsername());
                this.listOfRecords.get(i).set(2, user.getPassword()); // can't!
                this.listOfRecords.get(i).set(3, user.getName());
                this.listOfRecords.get(i).set(4, user.getSurname());
                this.listOfRecords.get(i).set(5, user.getRole());
            }
        }
        newList = this.listOfRecords;
        String header = "id,username,password,name,surname,role,";
        this.csvParser.updateFile(newList, header);
    }


    private String toString(User user) {

        return null;
    }

    @Override
    public int getLastIndex() {
        String lastElementIdString = this.listOfRecords.
                get(listOfRecords.size() - 1).
                get(idIndex);

        return Integer.parseInt(lastElementIdString);
    }
}
