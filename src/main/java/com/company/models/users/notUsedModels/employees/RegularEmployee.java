package com.company.models.users.employees;

import com.company.models.users.User;

public class RegularEmployee extends User {

    public RegularEmployee(int id, String username, String password, String name, String surname, String role) {
        super(id, username, password, name, surname, role);
    }
}
