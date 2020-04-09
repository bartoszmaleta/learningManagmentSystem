package com.company.models;

public class Grade {
    private int id;
    private String assignmentTitle;
    private String studentUsername;
    private int mark;

    public Grade(int id, String assignmentTitle,  String studentUsername, int mark) {
        this.id = id;
        this.assignmentTitle = assignmentTitle;
        this.studentUsername = studentUsername;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }
}
