/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.AdminAction.UserAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import config.StaticVariables;
import dao.UserDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.user;

/**
 *
 * @author sonthanhnguyen
 */
public class UserListAction extends ActionSupport {

    private List<user> userList;
    private String logedIn;
    private StaticVariables staticVariables = new StaticVariables();

    public UserListAction() {
    }

    public String execute() throws SQLException, ClassNotFoundException {
        Map session = ActionContext.getContext().getSession();
        if (session.containsKey("loggedIn")) {
            UserDao userDao = new UserDao();
            this.userList = (List<user>) userDao.getAllUser();
            for (user u : userList) {
                u.setAvatar(staticVariables.getUploadPath() + staticVariables.getUserImageUploadPath() + u.getAvatar());
            }
            return "success";
        }
        return "error";
    }

    public List<user> getUserList() {
        return userList;
    }

    public void setUserList(List<user> userList) {
        this.userList = userList;
    }

}
