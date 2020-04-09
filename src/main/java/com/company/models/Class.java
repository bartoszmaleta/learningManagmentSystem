package com.company.models;

public class Class {
    private int id;
    private String title;
    private String studentUsername;
    private String mentorName;

    public Class(int id, String title, String studentUsername, String mentorName) {
        this.id = id;
        this.title = title;
        this.studentUsername = studentUsername;
        this.mentorName = mentorName;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
