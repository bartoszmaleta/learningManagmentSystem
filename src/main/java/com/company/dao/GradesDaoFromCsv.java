package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.Assignment;
import com.company.models.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradesDaoFromCsv implements GradesDao {
    private final int idIndex = 0;
    private final int assignmentTitleIndex = 1;
    private final int studentUsernametIndex = 2;
    private final int markIndex = 3;

    private CsvParser csvParser;
    private List<List<String>> listOfRecords;
    private Grade grade;
    private String filepathOfGradesCsv = "src/main/resources/grades.csv";

    public GradesDaoFromCsv() {
        this.csvParser = new CsvParser(filepathOfGradesCsv);
        this.listOfRecords = csvParser.getUpdatedList();
    }

    @Override
    public List<Grade> extractGradesFromListByStudentUsername(String studentUsernameForList) {
        String id, assignmentTitle, studentUsername, mark;

        List<Grade> gradeList = new ArrayList<>();

        for (int i = 0; i < this.listOfRecords.size(); i++) {
            List<String> grades = this.listOfRecords.get(i);
            id = grades.get(idIndex);
            assignmentTitle = grades.get(assignmentTitleIndex);
            studentUsername = grades.get(studentUsernametIndex);
            mark = String.valueOf(grades.get(markIndex));

            if (studentUsernameForList.equals(studentUsername)) {
                gradeList.add(new Grade(Integer.parseInt(id), assignmentTitle, studentUsername, Integer.parseInt(mark)));
            }
        }
        return gradeList;
    }

    public List<Grade> extractAllGrades() {
        String id, assignmentTitle, studentUsername, mark;

        List<Grade> gradeList = new ArrayList<>();

        for (int i = 0; i < this.listOfRecords.size(); i++) {
            List<String> grades = this.listOfRecords.get(i);
            id = grades.get(idIndex);
            assignmentTitle = grades.get(assignmentTitleIndex);
            studentUsername = grades.get(studentUsernametIndex);
            mark = String.valueOf(grades.get(markIndex));

            gradeList.add(new Grade(Integer.parseInt(id), assignmentTitle, studentUsername, Integer.parseInt(mark)));
        }
        return gradeList;
    }


    @Override
    public void write(Grade grade) {
        String[] toStringArrayGrade = toStringArray(grade);
        this.csvParser.addNewRecord(toStringArrayGrade);
    }

    @Override
    public void remove(Grade grade) {
        List<List<String>> newList;
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            if (this.listOfRecords.get(i).get(0).equals(String.valueOf(grade.getId()))) {
                this.listOfRecords.remove(this.listOfRecords.get(i));
            }
        }
        newList = this.listOfRecords;
        String header = "id,assignmentTitle,studentUsername,mark,";
        this.csvParser.updateFile(newList, header);
    }

    @Override
    public void edit(Grade grade) {
        List<List<String>> newList;
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            if (this.listOfRecords.get(i).get(0).equals(String.valueOf(grade.getId()))) {
                this.listOfRecords.get(i).set(1, grade.getAssignmentTitle());
                this.listOfRecords.get(i).set(2, grade.getStudentUsername());
                this.listOfRecords.get(i).set(3, String.valueOf(grade.getMark()));
            }
        }
        newList = this.listOfRecords;
        String header = "id,assignmentTitle,studentUsername,mark,";
        this.csvParser.updateFile(newList, header);
    }

    @Override
    public String[] toStringArray(Grade grade) {
        String[] gradeArray = {String.valueOf(grade.getId())
                , grade.getAssignmentTitle()
                , grade.getStudentUsername()
                , String.valueOf(grade.getMark())};
        return gradeArray;
    }

    @Override
    public int getLastIndex() {
        String lastElementIdString = this.listOfRecords.
                get(listOfRecords.size() - 1).
                get(idIndex);
        return Integer.parseInt(lastElementIdString);
    }
}
