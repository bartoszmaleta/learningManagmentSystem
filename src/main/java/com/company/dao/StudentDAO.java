package com.company.dao;

import com.company.models.users.User;
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
        ArrayList<User> studentsArray = new ArrayList<>();
        for (int i = 0; i < listOfStudents.size(); i++) {
            List<String> students = listOfStudents.get(i);
            id = students.get(0);
            login = students.get(1);
            password = students.get(2);
            name = students.get(3);
            surname = students.get(4);
            role = students.get(5);
            studentsArray.add(new Student(id, login, password, name, surname, role));
        }
        for (int o = 0; o < studentsArray.size(); o++) {
            System.out.println(studentsArray.get(o).getName());
        }

        return studentsArray;
    }
}
