package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.Attendance;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDaoFromCsv implements AttendanceDao {
    private final int idIndex = 0;
    private final int localDateIndex = 1;
    private final int studentUsernameIndex = 2;
    private final int isPresentIndex = 3;

    private final CsvParser csvParser;
    private List<List<String>> listOfRecords;
    private final String pathFromContentRoot = "src/main/resources/attendance.csv";

    Path path = Paths.get("");
    Path absolutePath = path.toAbsolutePath();
    String location = absolutePath.toString() + pathFromContentRoot;
    String locationWithDate = location + "attendance" + LocalDate.now();

    public AttendanceDaoFromCsv() throws FileNotFoundException {
        this.csvParser = new CsvParser(locationWithDate);
    }

    @Override
    public void write(Attendance attendance) {
        String[] toStringArrayAssignment = attendance.toStringArray();
        this.csvParser.addNewRecord(toStringArrayAssignment);
    }

    @Override
    public String[] toStringArray(Attendance attendance) {
        return new String[0];
    }

    @Override
    public int getLastIndex() {
        return 0;
    }

    @Override
    public void writeFirstRecord(Attendance attendance, String[] headers) {
        String[] toStringArrayAssignment = attendance.toStringArray();
        this.csvParser.addFirstRecord(toStringArrayAssignment, headers);
    }

    @Override
    public List<Attendance> extractAllAttendances() {
        String id, username, isPresent;
        LocalDate localDate;

        List<Attendance> attendancesList = new ArrayList<>();

        for (int i = 0; i < this.listOfRecords.size(); i++) {
            List<String> attendances = this.listOfRecords.get(i);
            id = attendances.get(idIndex);
            localDate = LocalDate.parse(attendances.get(localDateIndex));
            username = attendances.get(studentUsernameIndex);
            if (attendances.get(isPresentIndex).equals("true")) {
                isPresent = "y";
            } else {
                isPresent = "n";
            }

            attendancesList.add(new Attendance(Integer.parseInt(id), localDate, username, isPresent));
        }
        return attendancesList;
    }

}
