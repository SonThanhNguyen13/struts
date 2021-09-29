/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.AdminAction.BookAction;

import com.opensymphony.xwork2.ActionSupport;
import config.StaticVariables;
import dao.BookDao;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author sonthanhnguyen
 */
public class CreateBookAction extends ActionSupport {

    private StaticVariables staticVariables = new StaticVariables();
    private int id;
    private String name;
    private String author;
    private String description;
    private String image;
    private File bookImage;
    private String bookImageFileName;
    private String bookImageContentType;

    public String execute() {
        return "success";
    }

    public String createBook() throws SQLException, ClassNotFoundException, IOException {
        if (name.isEmpty()) {
            addActionError("Book must have a name");
            return "error";
        }
        if (author.isEmpty()) {
            addActionError("Book must have an author");
            return "error";
        }
        if (description.isEmpty()) {
            description = "null";
        }
        if (bookImageFileName != null) {
            final String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileDestination = staticVariables.getImageUploadFolderPath() + staticVariables.getBookImageUploadPath();
            String newFileName = uuid + bookImageFileName;
            File fileToCreate = new File(fileDestination, newFileName);
            FileUtils.copyFile(bookImage, fileToCreate);//copying source file to new file  
            // done
            this.image = newFileName;
        } else {
            addActionError("Book must have an image");
            return "error";
        }
        BookDao bookDao = new BookDao();
        String bookName = bookDao.createBook(name, author, description, image);
        addActionMessage("Create book " + bookName + " successfully");
        return "success";
    }

    public CreateBookAction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public File getBookImage() {
        return bookImage;
    }

    public void setBookImage(File bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookImageFileName() {
        return bookImageFileName;
    }

    public void setBookImageFileName(String bookImageFileName) {
        this.bookImageFileName = bookImageFileName;
    }

    public String getBookImageContentType() {
        return bookImageContentType;
    }

    public void setBookImageContentType(String bookImageContentType) {
        this.bookImageContentType = bookImageContentType;
    }

}
