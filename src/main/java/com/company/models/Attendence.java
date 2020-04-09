package com.company.models;

import java.time.LocalDate;

public class Attendence {
    private int id;
    private LocalDate localDate;
    private String studentUsername;

    public Attendence(int id, LocalDate localDate, String studentUsername) {
        this.id = id;
        this.localDate = localDate;
        this.studentUsername = studentUsername;
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
}
