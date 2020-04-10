package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.Assignment;
import com.company.models.Attendence;
import com.company.service.DataHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendenceDaoFromCsv implements AttendenceDao{
    private final int idIndex = 0;
    private final int localDateIndex = 1;
    private final int studentUsernameIndex = 2;
    private final int isPresentIndex = 3;

    private final CsvParser csvParser;
    private List<List<String>> listOfRecords;
    private Attendence attendence;
    private final String pathFromContentRoot = "src/main/resources/attendance.csv";

    Path path = Paths.get("");
    Path absolutePath = path.toAbsolutePath();
    String location = absolutePath.toString() + pathFromContentRoot;
    String locationWithDate = location + "attendance" + LocalDate.now();

    public AttendenceDaoFromCsv() throws FileNotFoundException {
        this.csvParser = new CsvParser(locationWithDate);
    }

    @Override
    public void write(Attendence attendence) {
        String[] toStringArrayAssignment = attendence.toStringArray();
        this.csvParser.addNewRecord(toStringArrayAssignment);
    }

    @Override
    public String[] toStringArray(Attendence attendence) {
        return new String[0];
    }

    @Override
    public int getLastIndex() {
        return 0;
    }

    @Override
    public void writeFirstRecord(Attendence attendence, String[] headers) {
        String[] toStringArrayAssignment = attendence.toStringArray();
        this.csvParser.addFirstRecord(toStringArrayAssignment, headers);
    }

    @Override
    public List<Attendence> extractAllAttendences() {
        String id, username, isPresent;
        LocalDate localDate;

        List<Attendence> attendancesList = new ArrayList<>();

        for (int i = 0; i < this.listOfRecords.size(); i++) {
            List<String> attendences = this.listOfRecords.get(i);
            id = attendences.get(idIndex);
            localDate = LocalDate.parse(attendences.get(localDateIndex));
            username = attendences.get(studentUsernameIndex);
            if (attendences.get(isPresentIndex).equals("true")) {
                isPresent = "y";
            } else {
                isPresent = "n";
            }

            attendancesList.add(new Attendence(Integer.parseInt(id), localDate, username, isPresent));
        }
        return attendancesList;
    }

}
