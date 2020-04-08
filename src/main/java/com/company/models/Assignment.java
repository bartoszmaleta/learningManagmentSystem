package com.company.models;

public class Assignment {
    private String title;
    private int grade;
    private boolean isSubmitted = false;
    private String mentorName;

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
