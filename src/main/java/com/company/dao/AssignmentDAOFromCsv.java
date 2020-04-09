package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.Assignment;
import com.company.models.users.User;

import java.util.ArrayList;
import java.util.List;

public class AssignmentDAOFromCsv implements AssignmentDao {
    int idIndex = 0;
    int titleIndex = 1;
    int usernameIndex = 2;
    int mentorNameIndex = 3;
    int isSubmittedIndex = 4;

    private CsvParser csvParser;
    private List<List<String>> listOfRecords;
    private Assignment assignment;
    private String filepathOfAssignmentsCsv = "src/main/resources/assignments.csv";

    public AssignmentDAOFromCsv() {
        this.csvParser = new CsvParser(filepathOfAssignmentsCsv);
        this.listOfRecords = csvParser.getUpdatedList();
    }


    @Override
    public List<Assignment> extractAssignmentsFromListByStudentUsername(String studentUsernameForList) {
        String id, title, username, mentorName;
        boolean isSubmitted;
        List<Assignment> assignmentList = new ArrayList<>();
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            List<String> assignments = this.listOfRecords.get(i);
            id = assignments.get(idIndex);
            title = assignments.get(titleIndex);
            username = assignments.get(usernameIndex);
            mentorName = assignments.get(mentorNameIndex);
            isSubmitted = Boolean.parseBoolean(assignments.get(isSubmittedIndex));

            if (studentUsernameForList.equals(username)) {
                assignmentList.add(new Assignment(Integer.parseInt(id), title, username, mentorName, isSubmitted));
            }
        }
        return assignmentList;
    }

    @Override
    public void write(Assignment assignment) {
        String[] toStringArrayAssignment = toStringArray(assignment);
        this.csvParser.addNewRecord(toStringArrayAssignment);
    }

    @Override
    public String[] toStringArray(Assignment assignment) {
        String[] assignmentArray = {String.valueOf(assignment.getId())
                , assignment.getTitle()
                , assignment.getStudentUsername()
                , assignment.getMentorName()
                , String.valueOf(assignment.getIsSubmitted())};
        return assignmentArray;
    }

    @Override
    public void remove(Assignment assignment) {
        List<List<String>> newList;
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            if (this.listOfRecords.get(i).get(0).equals(String.valueOf(assignment.getId()))) {
                this.listOfRecords.remove(this.listOfRecords.get(i));
            }
        }
        newList = this.listOfRecords;
        String header = "id,title,studentUsername,mentorName,isSubmitted,";
        this.csvParser.updateFile(newList, header);
    }

    @Override
    public void edit(Assignment assignment) {
        List<List<String>> newList;
        for (int i = 0; i < this.listOfRecords.size(); i++) {
            if (this.listOfRecords.get(i).get(0).equals(String.valueOf(assignment.getId()))) {
                this.listOfRecords.get(i).set(1, assignment.getStudentUsername());
                this.listOfRecords.get(i).set(2, assignment.getStudentUsername()); // can't!
                this.listOfRecords.get(i).set(3, assignment.getMentorName());
                this.listOfRecords.get(i).set(4, String.valueOf(assignment.getIsSubmitted()));
            }
        }
        newList = this.listOfRecords;
        String header = "id,title,studentUsername,mentorName,isSubmitted,";
        this.csvParser.updateFile(newList, header);
    }

    @Override
    public int getLastIndex() {
        String lastElementIdString = this.listOfRecords.
                get(listOfRecords.size() - 1).
                get(idIndex);

        return Integer.parseInt(lastElementIdString);
    }
}
