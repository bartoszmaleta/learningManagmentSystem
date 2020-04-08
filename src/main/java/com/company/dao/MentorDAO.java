package com.company.dao;

import com.company.models.users.User;
import com.company.models.users.employees.Mentor;
import com.company.models.users.students.Student;

import java.util.ArrayList;
import java.util.List;

public class MentorDAO implements CsvDAO {
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

    public List<User> extractUserFromList(List<List<String>> listOfMentors) {
        String id, login, password, name, surname, role;
        List<User> mentorsArray = new ArrayList<>();
        for (int i = 0; i < listOfMentors.size(); i++) {
            List<String> mentors = listOfMentors.get(i);
            id = mentors.get(0);
            login = mentors.get(1);
            password = mentors.get(2);
            name = mentors.get(3);
            surname = mentors.get(4);
            role = mentors.get(5);
            if (role.equals("mentor")) {
                mentorsArray.add(new Mentor(login, password, name, surname, role));
            }
        }
        return mentorsArray;
    }
}
