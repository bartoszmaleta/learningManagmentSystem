package com.company.dao;

import com.company.models.Assignment;
import com.company.models.Grade;

import java.util.List;

public interface GradesDao {
    void write(Grade grade);
    void remove(Grade grade);
    void edit(Grade grade);
    String[] toStringArray(Grade grade);
    List<Grade> extractGradesFromListByStudentUsername(String studentUsernameForList);
    int getLastIndex();

    //    User readUserByUsernameAndPassword(String usernameGiven, String passwordGiven);
}
