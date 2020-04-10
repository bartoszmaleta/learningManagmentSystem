package com.company.dao;

import com.company.models.Assignment;
import com.company.models.Class;

import java.util.List;

public interface ClassDao {
    void write(Class classes);
    void remove(Class classes);
    void edit(Class classes);
    String[] toStringArray(Class classes);
    List<Class> extractClassesFromListByMentorName(String mentorNameForList);
    int getLastIndex();
}
