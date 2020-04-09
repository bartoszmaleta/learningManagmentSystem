package com.company.models;

public class Class {
    private int id;
    private String title;
    private String mentorName;

    public Class(int id, String title, String mentorName) {
        this.title = title;
        this.mentorName = mentorName;
        this.id = id;
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
