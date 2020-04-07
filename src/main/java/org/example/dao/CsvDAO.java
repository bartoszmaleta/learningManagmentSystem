package org.example.dao;

import org.example.models.users.User;

public interface CsvDAO {
    public void write(User user);
    public void remove(User user);
    public void update(User user);
    public void read(User user);

}
