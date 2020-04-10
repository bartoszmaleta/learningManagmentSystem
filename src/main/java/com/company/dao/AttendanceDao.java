package com.company.dao;

import com.company.models.Attendance;

import java.util.List;

public interface AttendanceDao {
    void write(Attendance attendance);
    String[] toStringArray(Attendance attendance);
    int getLastIndex();
    void writeFirstRecord(Attendance attendance, String[] headers);
    List<Attendance> extractAllAttendances();


}
