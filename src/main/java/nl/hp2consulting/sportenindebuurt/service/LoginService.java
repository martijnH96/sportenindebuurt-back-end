package nl.hp2consulting.sportenindebuurt.service;

import nl.hp2consulting.sportenindebuurt.dao.UserDAO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;

import javax.inject.Inject;
import java.sql.*;

public class LoginService {

    private UserDAO userDAO;
    @Inject
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int login(String username, String password) throws ConnectionException {
        return userDAO.login(username, password);
    }
}
