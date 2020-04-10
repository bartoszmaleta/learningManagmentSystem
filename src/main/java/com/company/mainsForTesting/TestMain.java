package com.company.mainsForTesting;

import com.company.dao.Parser.CsvParser;
import com.company.models.Attendance;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<String> arrayListObject = new ArrayList<>();

        arrayListObject.add("A");
        arrayListObject.add("B");
        arrayListObject.add("C");
        arrayListObject.add("D");

        System.out.println(arrayListObject);

        ArrayList<String> arrayListClone =  (ArrayList<String>) arrayListObject.clone();

        System.out.println(arrayListClone);

        arrayListClone.set(2, "qwe");
        System.out.println("--------------------");
        System.out.println(arrayListObject);
        System.out.println(arrayListClone);

        System.out.println("--------------------");

        arrayListClone.set(0, "qweqweasdasd");
        System.out.println(arrayListObject);
        System.out.println(arrayListClone);


        List<String> clonedList = arrayListClone.stream().map(String::new).collect(Collectors.toList());

        System.out.println("--------------------");

        System.out.println(LocalDate.now().getDayOfYear());
        System.out.println(LocalDate.now());

        Path path = Paths.get("");
        Path absolutePath = path.toAbsolutePath();
        String location = absolutePath.toString()+"/src/main/resources/attendences/";

        String locationWithDate = location + "attendence" + LocalDate.now();
        System.out.println(locationWithDate);


        System.out.println("--------------------");
        CsvParser csvParser = new CsvParser(locationWithDate);
        Attendance attendence = new Attendance(1, LocalDate.now(), "qwe", "y");
//        csvParser.addFirstRecord(attendence.toStringArray());
//        csvParser.addNewRecord(attendence.toStringArray());



    }
}
