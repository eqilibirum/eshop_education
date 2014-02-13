package db;

import db.exceptions.DBSystemException;
import db.exceptions.NotUniqueLoginException;
import db.exceptions.NotUniqueMailException;

import java.util.List;

public interface UserDao {

    public List<User> selectAll() throws DBSystemException;

    public int deleteById(int id) throws DBSystemException;

    public void insertUser(User user) throws DBSystemException, NotUniqueLoginException, NotUniqueMailException;

    /*public void isertU(User user) throws DBSystemException;*/
}
