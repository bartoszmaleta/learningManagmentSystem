package com.company.dao;

import com.company.models.users.User;

public interface UserDAO {
    public void write(User user);
    public void remove(User user);
    public void edit(User user);
    public User read(User user);

}
