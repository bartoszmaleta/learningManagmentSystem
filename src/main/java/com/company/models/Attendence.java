package com.company.models;

import java.time.LocalDate;

public class Attendence {
    private int id;
    private LocalDate localDate;
    private String studentUsername;
    private boolean isPresent;

    public Attendence(int id, LocalDate localDate, String studentUsername, String isPresentString) {
        this.id = id;
        this.localDate = localDate;
        this.studentUsername = studentUsername;
        this.isPresent = setIsPresent(isPresentString);
    }

    public boolean getIsPresnt() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public boolean setIsPresent(String ifPresent) {
        if (ifPresent.toLowerCase().equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String[] toStringArray() {
        String[] attendenceArray = {String.valueOf(this.getId())
                , this.getStudentUsername()
                , String.valueOf(this.getLocalDate())
                , String.valueOf(this.getIsPresnt())};
        return attendenceArray;
    }
}
