/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.AdminAction.UserAction;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import java.sql.SQLException;

/**
 *
 * @author sonthanhnguyen
 */
public class DeleteUserAction extends ActionSupport {

    private String userID;
    private String username;
    private int id;

    public String execute() throws SQLException, ClassNotFoundException {
        this.id = Integer.parseInt(this.userID);
        UserDao userDao = new UserDao();
        String userInfo = userDao.getUserByID(id);
        String[] parts = userInfo.split(";");
        setUsername(parts[1]);
        return "success";
    }

    public String deleteUser() throws SQLException, ClassNotFoundException {
        this.id = Integer.parseInt(this.userID);
        UserDao userDao = new UserDao();
        String deleteUser = userDao.deleteUser(id);
        if (deleteUser.isEmpty()) {
            addActionError("User not found");
            return "error";
        } else {
            addActionMessage("Delete user " + deleteUser + " successfully");
            return "success";
        }
    }

    public DeleteUserAction() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
