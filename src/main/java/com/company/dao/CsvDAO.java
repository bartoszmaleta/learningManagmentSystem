package com.company.dao;

import com.company.models.users.User;

public interface CsvDAO {
    public void write(User user);
    public void remove(User user);
    public void update(User user);
    public void read(User user);

}
