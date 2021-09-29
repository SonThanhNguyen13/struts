/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.UserAction;

import com.opensymphony.xwork2.ActionSupport;
import config.StaticVariables;
import dao.UserDao;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import utils.Password;

/**
 *
 * @author sonthanhnguyen
 */
public class UpdateUserAction extends ActionSupport {

    private StaticVariables staticVariables;
    private String userID;
    private int id;
    private String username;
    private String password;
    private String retypePassword;
    private String email;
    private String name;
    private String avatar;
    private File userImage;
    private String userImageFileName;
    private String userImageContentType;

    private String getUserByID(int id){
        try {
            UserDao userDao = new UserDao();
            String userInfo = userDao.getUserByID(this.id);
            if (!userInfo.equals("")) {
                String[] parts = userInfo.split(";");
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].equals("null")) {
                        parts[i] = "";
                    }
                }
                setUsername(parts[1]);
                setEmail(parts[4]);
                setName(parts[5]);
                String imageName = parts[6];
                String avatarPath = staticVariables.getUploadPath() + staticVariables.getUserImageUploadPath() + imageName;
                setAvatar(avatarPath);
                return "success";
            } else {
                return "error";
            }
        } catch (SQLException e) {
            return "error";
        } catch (ClassNotFoundException e) {
            return "error";
        }
    }

    public String execute() throws SQLException, ClassNotFoundException {
        try {
            this.id = Integer.parseInt(this.userID);
            String result = getUserByID(id);
            return result;
        } catch (NumberFormatException e) {
            return "error";
        }

    }

    public String updateUser() throws NoSuchAlgorithmException, IOException, InterruptedException, SQLException, ClassNotFoundException {
        try {
            this.id = Integer.parseInt(this.userID);
            Password pw = new Password();
            if (!pw.checkPassword(this.password, this.retypePassword)) {
                addActionError("Password not match");
                return "error";
            }
            UserDao userDao = new UserDao();
            int isSetAdmin = 0;
            if (this.name.equals("")) {
                setName("null");
            }
            if (this.email.equals("")) {
                setEmail("null");
            }
            String updatedUser;
            try {
                if (userImageFileName != null) {
                    final String uuid = UUID.randomUUID().toString().replace("-", "");
                    String fileDestination = staticVariables.getImageUploadFolderPath() + staticVariables.getUserImageUploadPath();
                    String newFileName = uuid + userImageFileName;
                    System.out.println("" + newFileName);
                    File fileToCreate = new File(fileDestination, newFileName);
                    FileUtils.copyFile(userImage, fileToCreate);//copying source file to new file  
                    // done
                    this.avatar = newFileName;
                }
                updatedUser = userDao.updateUser(this.id, this.username, this.password, isSetAdmin, this.email, this.name, this.avatar);
                addActionMessage("Update user " + updatedUser + " successfully.");
                sleep(1500);
                String result = getUserByID(id);
                return result;
            } catch (SQLException ex) {
                addActionError("User not exist or something when wrong");
                return "error";
            } catch (ClassNotFoundException ex) {
                addActionError("Something when wrong");
                return "error";
            }
        } catch (NumberFormatException e) {
            return "error";
        }
    }

    public UpdateUserAction() {
        staticVariables = new StaticVariables();
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public StaticVariables getStaticVariables() {
        return staticVariables;
    }

    public void setStaticVariables(StaticVariables staticVariables) {
        this.staticVariables = staticVariables;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
