package com.denys.main;

import com.denys.main.exceptions.DBSystemException;
import com.denys.main.exceptions.NotUniqueLoginException;
import com.denys.main.exceptions.NotUniqueMailException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbc implements UserDao {

    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/production_shop?user=root&" +
            "password=kamdil539";
    private static final String SELECT_ALL_SQL = "SELECT user_id, user_name, user_mail FROM user";
    public static final String DELETE_BY_ID_SQL = "DELETE FROM user WHERE user_id = ?";
    public static final String INSERT_SQL = "INSERT INTO user (user_name, user_mail) VALUES (?, ?)";
    public static final String SELECT_BY_LOGIN = "SELECT id FROM user WHERE user_name = ?";
    public static final String SELECT_BY_MAIL = "SELECT id FROM user WHERE user_mail = ?";

    static {
        JdbcUtils.initDriver(DRIVER_CLASS_NAME);
    }

    private Connection getConnection() throws DBSystemException{
        try {
            return DriverManager.getConnection(JDBC_URL);
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection", e);
        }
    }

    public List<User> selectAll() throws DBSystemException {
        Connection conn = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_SQL);
            List<User> result = new ArrayList<User>();
            while (resultSet.next()){
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("user_name");
                String email = resultSet.getString("user_mail");
                User user = new User(id);
                user.setLogin(name);
                user.setEmail(email);
                result.add(user);
            }
            conn.commit();
            return result;
        } catch (SQLException e){
            JdbcUtils.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '" + SELECT_ALL_SQL + "' ");
        } finally {
            JdbcUtils.closeQuietly(resultSet);
            JdbcUtils.closeQuietly(statement);
            JdbcUtils.closeQuietly(conn);
        }
    }

    public int deleteById(int id) throws DBSystemException {
        Connection conn = getConnection();
        PreparedStatement preparedStatement = null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(DELETE_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            conn.commit();
            return result;
        } catch (SQLException e) {
            JdbcUtils.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '" + DELETE_BY_ID_SQL + "' ");
        } finally {
            JdbcUtils.closeQuietly(preparedStatement);
            JdbcUtils.closeQuietly(conn);
        }
    }

    public void insertUser(User user) throws DBSystemException, NotUniqueLoginException, NotUniqueMailException {

    }
}
