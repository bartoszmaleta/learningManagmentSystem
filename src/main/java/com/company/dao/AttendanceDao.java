package com.company.dao;

import com.company.models.Attendance;

import java.util.List;

public interface AttendenceDao {
    void write(Attendance attendence);
    String[] toStringArray(Attendance attendence);
    int getLastIndex();
    void writeFirstRecord(Attendance attendence, String[] headers);
    List<Attendance> extractAllAttendences();


}
