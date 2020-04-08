package com.company.dao;

import com.company.models.users.User;
import com.company.models.users.employees.Mentor;
import com.company.models.users.students.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements CsvDAO {

    @Override
    public void write(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void read(User user) {

    }

    public List<User> extractUserFromList(List<List<String>> listOfStudents) {
        String id, login, password, name, surname, role;
        List<User> studentsArray = new ArrayList<>();
        for (int i = 0; i < listOfStudents.size(); i++) {
            List<String> students = listOfStudents.get(i);
            id = students.get(0);
            login = students.get(1);
            password = "*************";
            name = students.get(3);
            surname = students.get(4);
            role = students.get(5);
            if (role.equals("student")) {
                studentsArray.add(new Student(login, password, name, surname, role));
            }
        }
        return studentsArray;
    }
}
