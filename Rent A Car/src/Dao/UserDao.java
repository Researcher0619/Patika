package Dao;

import Core.Db;
import Core.Helper;
import Entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {

    private final Connection con;

    // Constructor
    public UserDao() {
        this.con = Db.getInstance(); // Get a database connection instance
    }

    // Retrieve all users from the database
    public ArrayList<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.user";
        try {
            ResultSet resultSet = con.createStatement().executeQuery(sqlQuery);
            while (resultSet.next()) {
                userList.add(this.match(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    // Find a user by username and password for login
    public User findByLogin(String username, String password) {
        User obj = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND user_password = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // Map the ResultSet to a User object
    public User match(ResultSet rs) throws SQLException {
        User obj = new User();
        obj.setId(rs.getInt("user_id"));
        obj.setUsername(rs.getString("user_name"));
        obj.setPassword(rs.getString("user_password"));
        obj.setRole(rs.getString("user_role"));

        return obj;
    }
}
