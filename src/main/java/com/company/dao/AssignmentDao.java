package com.company.dao;

import com.company.models.Assignment;
import com.company.models.users.User;

import java.util.List;

public interface AssignmentDao {
    void write(Assignment assignment);
    void remove(Assignment assignment);
    void edit(Assignment assignment);
    String[] toStringArray(Assignment assignment);
    List<Assignment> extractAssignmentsFromListByStudentUsername(String studentUsernameForList);
//    User readUserByUsernameAndPassword(String usernameGiven, String passwordGiven);
    int getLastIndex();
}
