package com.denys.main;

import com.denys.main.exceptions.DBSystemException;
import com.denys.main.exceptions.NotUniqueLoginException;
import com.denys.main.exceptions.NotUniqueMailException;

import java.util.List;

public interface UserDao {

    public List<User> selectAll() throws DBSystemException;

    public int deleteById(int id) throws DBSystemException;

    public void insertUser(User user) throws DBSystemException, NotUniqueLoginException, NotUniqueMailException;

}
