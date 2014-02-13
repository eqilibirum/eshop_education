package db;

import db.exceptions.DBSystemException;
import db.exceptions.NotUniqueLoginException;
import db.exceptions.NotUniqueMailException;

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

/*        System.out.println("INSERT");
        dao.isertU(newUser(3, "Alex", "alex@mail"));
        dao.isertU(newUser(5, "Kris", "kris@mail"));
        dao.isertU(newUser(7, "Frank", "frank@mail"));
    }*/
        System.out.println("INSERT NEW:");
        dao.insertUser(newUser(1, "Phil", "phil@mail"));
        System.out.println(" Phil inserted. ");
        dao.insertUser(newUser(2, "John", "john@mail"));
        System.out.println(" John inserted. ");
        dao.insertUser(newUser(2, "Claus", "claus@mail"));
        System.out.println(" Claus inserted. ");
    }

    private static User newUser(int id, String login, String email) {
        User result = new User(id);
        result.setLogin(login);
        result.setEmail(email);
        return result;
    }

}
