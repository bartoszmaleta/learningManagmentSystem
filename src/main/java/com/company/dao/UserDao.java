package com.company.dao;

import com.company.models.users.User;

import java.util.List;

public interface UserDao {
    void write(User user);
    void remove(User user);
    void edit(User user);
    String[] toStringArray(User user);
    User readUserByUsernameAndPassword(String usernameGiven, String passwordGiven);
    List<User> extractUsersFromListOfRecordsByRoleGiven(String roleForList);
    int getLastIndex();

}
