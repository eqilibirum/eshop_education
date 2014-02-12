package com.denys.main;

import com.denys.main.exceptions.DBException;
import com.denys.main.exceptions.DBSystemException;
import com.denys.main.exceptions.NotUniqueLoginException;
import com.denys.main.exceptions.NotUniqueMailException;
import sun.jdbc.odbc.JdbcOdbcUtils;

public class MainTest {

    public static void main(String args[]) throws DBSystemException, NotUniqueLoginException, NotUniqueMailException {

        UserDao dao = new UserDaoJdbc();
        System.out.println("ALL CURRENT USERS:");
        for (User user : dao.selectAll()){
            System.out.println("   " + user.toString());
        }

/*        System.out.println("DELETE:");
        for (User user : dao.selectAll()){
            System.out.println( "User id = " + user.getId() + " deleted");
        }*/

/*        System.out.println("INSERT NEW:");
        dao.insertUser(new User(1, "Mike" , "mike@mail"));
        System.out.println("User inserted. INSERT NEW:");
        dao.insertUser(new User(2, "John", "john@mail"));*/
    }

}
