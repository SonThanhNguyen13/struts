/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.UserAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.Map;
import dao.UserDao;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author sonthanhnguyen
 */
public class LoginAction extends ActionSupport {

    private String username;
    private String password;

    public String execute() {
        return SUCCESS;
    }

    public String checkLogin() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        UserDao userDao = new UserDao();
        String returnResult = userDao.validateLogin(username, password);
        if (!returnResult.equals("")) {
            String[] parts = returnResult.split(";");
            String userID = parts[0];
            String loginUsername = parts[1];
            boolean isAdmin = userDao.checkAdmin(loginUsername);
            Map session = ActionContext.getContext().getSession();
            session.put("loggedIn", "true");
            session.put("username", loginUsername);
            session.put("userID", userID);
            if (isAdmin) {
                session.put("isAdmin", "true");
            } else {
                session.put("isAdmin", "false");
            }
            return SUCCESS;
        } else {
            addActionError("Invalid username or password");
            return ERROR;
        }
    }

    public String logout() {
        Map session = ActionContext.getContext().getSession();
        session.remove("loggedIn");
        session.remove("username");
        session.remove("is-admin");
        session.remove("userID");
        session.clear();
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
