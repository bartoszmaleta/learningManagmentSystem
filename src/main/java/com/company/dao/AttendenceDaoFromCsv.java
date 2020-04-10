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

public class AttendenceDaoFromCsv {
    private int idIndex = 0;
    private int localDateIndex = 1;
    private int studentUsernameIndex = 2;
    private int isPresentIndex = 3;

    private CsvParser csvParser;
    private List<List<String>> listOfRecords;
    private Attendence attendence;
    private String filepathOfCsv = "src/main/resources/attendence.csv";

    Path path = Paths.get("");
    Path absolutePath = path.toAbsolutePath();
    String location = absolutePath.toString() + "/src/main/resources/attendences/";

    String locationWithDate = location + "attendence" + LocalDate.now();


    public AttendenceDaoFromCsv() throws FileNotFoundException {
        this.csvParser = new CsvParser(locationWithDate);
//        this.listOfRecords = csvParser.getUpdatedList();
    }

    public void write(Attendence attendence) {
        String[] toStringArrayAssignment = attendence.toStringArray();
        this.csvParser.addNewRecord(toStringArrayAssignment);
    }

    public void writeFirstRecord(Attendence attendence, String[] headers) {
        String[] toStringArrayAssignment = attendence.toStringArray();
        this.csvParser.addFirstRecord(toStringArrayAssignment, headers);
    }

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
