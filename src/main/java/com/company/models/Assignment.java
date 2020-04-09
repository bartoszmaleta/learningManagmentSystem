package com.company.models;

public class Assignment {

    private int id;
    private String title;
    private String studentUsername;
    //    private int grade;
    private String mentorName;
    private boolean isSubmitted = false;

    public Assignment(int id, String title, String studentUsername, String mentorName, boolean isSubmitted) {
        this.id = id;
        this.title = title;
        this.studentUsername = studentUsername;
//        this.grade = grade;
        this.mentorName = mentorName;
        this.isSubmitted = isSubmitted;
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

    public boolean getIsSubmitted() {
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

//    public int getGrade() {
//        return grade;
//    }
//
//    public void setGrade(int grade) {
//        this.grade = grade;
//    }

    public void setIsSubmittedTrue() {
        isSubmitted = true;
    }

    public boolean checkIfAssignmentIsSubmitted() {
        return isSubmitted;
    }


}
