package Business;

import Dao.UserDao;
import Entity.User;

public class UserManager {

    // DAO for User operations
    private final UserDao userDao;

    // Constructor to initialize UserDao
    public UserManager() {
        this.userDao = new UserDao();
    }

    // Find a user by login credentials (username and password)
    public User findByLogin(String username, String password) {
        return this.userDao.findByLogin(username, password);
    }
}
