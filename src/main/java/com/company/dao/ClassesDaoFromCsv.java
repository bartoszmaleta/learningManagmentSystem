package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.Class;

import java.util.ArrayList;
import java.util.List;

public class ClassesDaoFromCsv implements ClassesDao {
    int idIndex = 0;
    int titleIndex = 1;
    int studentUsernameIndex = 2;
    int mentorNameIndex = 3;

    private CsvParser csvParser;
    private List<List<String>> listOfRecords;
    private Class classes;
    private String filepathOfClassesCsv = "src/main/resources/classes.csv";

    public ClassesDaoFromCsv() {
        this.csvParser = new CsvParser(filepathOfClassesCsv);
        this.listOfRecords = csvParser.getUpdatedList();
    }

    @Override
    public List<Class> extractClassesFromListByMentorName(String mentorNameForList) {
        String id, title, studentUsername, mentorName;
        List<Class> classesList = new ArrayList<>();
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            List<String> classes = this.listOfRecords.get(i);
            id = classes.get(idIndex);
            title = classes.get(titleIndex);
            studentUsername = classes.get(studentUsernameIndex);
            mentorName = classes.get(mentorNameIndex);

            if (mentorNameForList.equals(mentorName)) {
                classesList.add(new Class(Integer.parseInt(id), title, studentUsername, mentorName));
            }
        }
        return classesList;
    }

    @Override
    public void write(Class classes) {
        String[] toStringArrayClass = toStringArray(classes);
        this.csvParser.addNewRecord(toStringArrayClass);
    }

    @Override
    public void remove(Class classes) {
        List<List<String>> newList;
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            if (this.listOfRecords.get(i).get(0).equals(String.valueOf(classes.getId()))) {
                this.listOfRecords.remove(this.listOfRecords.get(i));
            }
        }
        newList = this.listOfRecords;
        String header = "id,title,studentUsername,mentorName,";
        this.csvParser.updateFile(newList, header);
    }

    @Override
    public void edit(Class classes) {
        List<List<String>> newList;
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            if (this.listOfRecords.get(i).get(0).equals(String.valueOf(classes.getId()))) {
                this.listOfRecords.get(i).set(1, classes.getTitle());
                this.listOfRecords.get(i).set(2, classes.getStudentUsername());
                this.listOfRecords.get(i).set(3, classes.getMentorName());
            }
        }
        newList = this.listOfRecords;
        String header = "id,title,studentUsername,mentorName,";
        this.csvParser.updateFile(newList, header);
    }


    @Override
    public String[] toStringArray(Class classes) {
        String[] classesArray = {String.valueOf(classes.getId())
                , classes.getTitle()
                , classes.getStudentUsername()
                , classes.getMentorName()};
        return classesArray;
    }

    @Override
    public int getLastIndex() {
        String lastElementIdString = this.listOfRecords.
                get(this.listOfRecords.size() - 1).
                get(this.idIndex);
        return Integer.parseInt(lastElementIdString);
    }

    public List<Class> extractAllClassesFromList() {
        String id, title, studentUsername, mentorName;

        List<Class> classesList = new ArrayList<>();

        for (int i = 0; i < this.listOfRecords.size(); i++) {
            List<String> classes = this.listOfRecords.get(i);
            id = classes.get(idIndex);
            title = classes.get(titleIndex);
            studentUsername = classes.get(studentUsernameIndex);
            mentorName = classes.get(mentorNameIndex);

            classesList.add(new Class(Integer.parseInt(id), title, studentUsername, mentorName));
        }
        return classesList;
    }
}
