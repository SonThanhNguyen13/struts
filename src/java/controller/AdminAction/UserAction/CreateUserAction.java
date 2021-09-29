/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.AdminAction.UserAction;

import com.opensymphony.xwork2.ActionSupport;
import config.StaticVariables;
import dao.UserDao;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import utils.Password;

/**
 *
 * @author sonthanhnguyen
 */
public class CreateUserAction extends ActionSupport {

    private final StaticVariables staticVariables;
    private String username;
    private String password;
    private String retypePassword;
    private boolean isAdmin;
    private String email;
    private String name;
    private File userImage;
    private String userImageFileName;
    private String userImageContentType;
    private String avatar;

    @Override
    public String execute() {
        System.out.println("" + this.avatar);
        return "success";
    }

    public String createUser() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException, IOException {
        Password pw = new Password();
        if (!pw.checkPasswordNotNull(password)) {
            addActionError("Please enter password");
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
        int isSetAdmin = 0;
        if (this.isAdmin) {
            isSetAdmin = 1;
        }
        if (this.name.equals("")) {
            setName("null");
        }
        if (this.email.equals("")) {
            setEmail("null");
        }
        // Save file
        if (userImageFileName != null) {
            final String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileDestination = staticVariables.getImageUploadFolderPath() + staticVariables.getUserImageUploadPath();
            String newFileName = uuid + userImageFileName;
            File fileToCreate = new File(fileDestination, newFileName);
            FileUtils.copyFile(userImage, fileToCreate);//copying source file to new file  
            // done
            this.avatar = newFileName;
        } else {
            this.avatar = "user.png";
        }
        String newUser = userDao.createUser(this.username, this.password, isSetAdmin, this.email, this.name, this.avatar);
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public File getUserImage() {
        return userImage;
    }

    public void setUserImage(File userImage) {
        this.userImage = userImage;
    }

    public String getUserImageFileName() {
        return userImageFileName;
    }

    public void setUserImageFileName(String userImageFileName) {
        this.userImageFileName = userImageFileName;
    }

    public String getUserImageContentType() {
        return userImageContentType;
    }

    public void setUserImageContentType(String userImageContentType) {
        this.userImageContentType = userImageContentType;
    }

    public CreateUserAction() {
        staticVariables = new StaticVariables();
    }

}
