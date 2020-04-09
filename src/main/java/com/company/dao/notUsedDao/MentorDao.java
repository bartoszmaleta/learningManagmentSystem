package com.company.dao.notUsedDao;

import com.company.dao.UserDao;
import com.company.models.users.User;
import com.company.models.users.employees.Mentor;

import java.util.ArrayList;
import java.util.List;

public class MentorDao implements UserDao {
    @Override
    public void write(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public String[] toStringArray(User user) {
        return new String[0];
    }

    @Override
    public User readUserByUsernameAndPassword(String usernameGiven, String passwordGiven) {
        return null;
    }

    @Override
    public List<User> extractUserFromListByRoleGiven(String roleForList) {
        return null;
    }

    @Override
    public int getLastIndex() {
        return 0;
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
                mentorsArray.add(new Mentor(Integer.parseInt(id), login, password, name, surname, role));
            }
        }
        return mentorsArray;
    }
}
