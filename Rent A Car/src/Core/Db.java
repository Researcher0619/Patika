package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private static Db instance = null;
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/rentacar";
    public static final String DB_USER= "postgres";
    public static final String DB_PASSWORD = "postgres";
    Connection conn = null;

    private Db(){
        try {
            this.conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }

    public static Connection getInstance(){
        try {
            if (instance == null || instance.getConn().isClosed()){
               instance = new Db();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return instance.getConn();
    }
}
