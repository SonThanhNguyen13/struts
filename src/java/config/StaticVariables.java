/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author sonthanhnguyen
 */
public class StaticVariables {

    private final String imageUploadFolderPath = "C:/Users/sonthanhnguyen/Desktop/BookStore/web/assest/upload/";
    private final String userImageUploadPath = "userImages/";
    private final String bookImageUploadPath = "bookImages/";
    private final String uploadPath = "assest/upload/";

    public StaticVariables() {
    }

    public String getImageUploadFolderPath() {
        return imageUploadFolderPath;
    }

    public String getUserImageUploadPath() {

        return userImageUploadPath;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public String getBookImageUploadPath() {
        return bookImageUploadPath;
    }

}
