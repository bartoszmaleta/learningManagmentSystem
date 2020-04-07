package org.example.models.users.employees;

import org.example.models.users.User;

public class RegularEmployee extends User {

    public RegularEmployee(String username, String password, String name, String surname, String role) {
        super(username, password, name, surname, role);
    }
}
