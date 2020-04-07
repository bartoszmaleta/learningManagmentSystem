package org.example.models.users.students;

import org.example.models.users.User;

public class Student extends User {

    public Student(String username, String password, String name, String surname, String role) {
        super(username, password, name, surname, role);
    }
}
