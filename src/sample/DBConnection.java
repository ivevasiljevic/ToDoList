package sample;
import java.sql.*;
public class DBConnection {


    public Connection getConnection()
    {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:ToDoList");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
