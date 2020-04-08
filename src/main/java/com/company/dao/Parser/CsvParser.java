package com.company.dao.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvParser implements Parser {
    private List<List<String>> listOfLines;
    private String fileName;
    private String fileString;
    private List<String> lineAsList;

    public CsvParser(String filenameToParse) {
        listOfLines = new ArrayList<>();
        this.fileName = filenameToParse;
    }

    @Override
    public List<List<String>> getListOfLines() {
        return listOfLines;
    }

    @Override
    public void convertFileToString() {
        this.fileString = "";
        try {
            File file = new File(this.fileName);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNext()) {
                fileString += scanner.nextLine();
                fileString += "\n";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // TODO how to handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void convertStringToList() {
        this.listOfLines = new ArrayList<>();
        this.lineAsList = Arrays.asList(this.fileString.split("\\r?\\n"));
        for (String line : lineAsList) {
            this.listOfLines.add(Arrays.asList(line.split(",")));
        }
    }

    @Override
    public List<List<String>> getUpdatedList() {
        fillList();
        return listOfLines;
    }

    @Override
    public void fillList() {
        convertFileToString();
        convertStringToList();
    }

    @Override
    public void addNewRecord(String[] newRecord) {
//        String newLineToFile = "\n" + String.join(",", newRecord) + ",";
        try {
            FileWriter fw = new FileWriter(this.fileName, true);
            fw.append("\n" + String.join(",", newRecord) + ",");
//            fw.write(newLineToFile + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFile(List<List<String>> newList, String header) {
//        String newFileInString = "id, username, password, name, surname, role,\n";
        String newFileInString = header + "\n";
        for (List<String> oneLineAsList : newList) {
            for (int i = 0; i < oneLineAsList.size(); i++) {
                newFileInString += oneLineAsList.get(i);
                newFileInString += ",";
            }
            newFileInString += "\n";
        }

        try {
            FileWriter fw = new FileWriter(this.fileName, false);
            fw.write(newFileInString + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}