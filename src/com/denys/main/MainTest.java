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

        System.out.println("DELETE:");
        for (User user : dao.selectAll()){
            dao.deleteById(user.getId());
            System.out.println( "User id = " + user.getId() + " deleted");
        }

        System.out.println("INSERT");
        dao.isertU(newUser(2, "John", "john@mail"));
        dao.isertU(newUser(1, "Will", "will@mail"));
        dao.isertU(newUser(3, "Alex", "alex@mail"));
    }
/*        System.out.println("INSERT NEW:");
        dao.insertUser(newUser(1, "Phil", "phil@mail"));
        System.out.println(" Phil inserted. ");
        dao.insertUser(newUser(2, "John", "john@mail"));
        System.out.println(" John inserted. ");

    */

    private static User newUser(int id, String login, String email) {
        User result = new User(id);
        result.setLogin(login);
        result.setEmail(email);
        return result;
    }

}
