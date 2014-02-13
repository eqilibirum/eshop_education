package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

    private static boolean initialized;

    public JdbcUtils() {
    }

    public static synchronized void initDriver(String classDriver){
        if (!initialized){
            try {
                Class.forName(classDriver);
            } catch (ClassNotFoundException e){
                e.printStackTrace();
                throw new RuntimeException("Can't load db driver", e);
            }
        } initialized = true;

    }
    public static void closeQuietly(ResultSet resultSet){
        if (resultSet != null){
            try{
                resultSet.close();
            } catch (SQLException e){
                //NOP
            }
        }

    }
    public static void rollbackQuietly(Connection conn){
        if (conn != null){
            try{
                conn.rollback();
            } catch (SQLException e){
                //NOP
            }
        }
    }

    public static void closeQuietly(Statement statement) {
        if (statement != null){
            try{
                statement.close();
            } catch (SQLException e){
                //NOP
            }
        }
    }

    public static void closeQuietly(Connection conn) {
        if (conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                //NOP
            }
        }
    }
}
