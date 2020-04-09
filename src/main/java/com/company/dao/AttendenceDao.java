package com.company.dao;

public interface AttendenceDao {
    void write(Attendence attendence);
    String[] toStringArray(Attendence attendence);
    int getLastIndex();

}
