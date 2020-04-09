package com.company.models;

public class Assignment {

    private int id;
    private String title;
    private String studentUsername;
    private int grade;
    private boolean isSubmitted = false;
    private String mentorName;

    public Assignment(int id, String title, String studentUsername, int grade, boolean isSubmitted, String mentorName) {
        this.id = id;
        this.title = title;
        this.studentUsername = studentUsername;
        this.grade = grade;
        this.isSubmitted = isSubmitted;
        this.mentorName = mentorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public Assignment(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setIsSubmittedTrue() {
        isSubmitted = true;
    }

    public boolean checkIfAssignmentIsSubmitted() {
        return isSubmitted;
    }


}
