package com.company.dao;

import com.company.models.Attendence;

public interface AttendenceDao {
    void write(Attendence attendence);
    String[] toStringArray(Attendence attendence);
    int getLastIndex();

}
