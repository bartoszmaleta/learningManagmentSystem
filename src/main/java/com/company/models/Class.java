package com.company.models;

public class Class {
    private String title;
    private String mentorName;

    public Class(String title, String mentorName) {
        this.title = title;
        this.mentorName = mentorName;
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
}
