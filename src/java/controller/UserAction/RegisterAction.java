/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.UserAction;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import utils.Password;

/**
 *
 * @author sonthanhnguyen
 */
public class RegisterAction extends ActionSupport {

    private String username;
    private String password;
    private String retypePassword;
    private final int isAdmin = 0;
    private final String email = "null";
    private final String name = "null";
    private final String avatar = "user.png";

    public String execute() {
        return "success";
    }

    public String getRegister() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        Password pw = new Password();
        if (!pw.checkPasswordNotNull(password)) {
            addActionError("Please input password");
            return "error";
        }
        if (!pw.checkPasswordNotNull(retypePassword)) {
            addActionError("Please retype password");
            return "error";
        }
        if (!pw.checkPassword(this.password, this.retypePassword)) {
            addActionError("Password not match");
            return "error";
        }
        UserDao userDao = new UserDao();
        if (!userDao.checkByUsername(this.username)) {
            addActionError("User already exist");
            return "error";
        }
        String newUser = userDao.createUser(this.username, this.password, this.isAdmin, this.email, this.name, this.avatar);
        addActionMessage("Create user " + newUser + " successfully.");
        return "success";
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

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

}
