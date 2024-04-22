package Milestones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mile4DB {
    static final String SERVER_IP = "localhost";
    static final String DB_NAME = "Milestone4";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://"+SERVER_IP + ":3306/" + DB_NAME;
    private Connection conn;

    public Mile4DB(){
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
