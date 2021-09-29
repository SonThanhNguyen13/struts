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
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.UUID;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author sonthanhnguyen
 */
public class UpdateBookAction extends ActionSupport {

    private StaticVariables staticVariables = new StaticVariables();
    private String bookID;
    private int id;
    private String name;
    private String author;
    private String description;
    private String image;
    private File bookImage;
    private String bookImageFileName;
    private String bookImageContentType;

    private String getBookByID(int id) throws SQLException, ClassNotFoundException {
        try {
            BookDao bookDao = new BookDao();
            String bookInfo = bookDao.getBookById(id);
            if (!bookInfo.equals("")) {
                String[] parts = bookInfo.split(";");
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].equals("null")) {
                        parts[i] = "";
                    }
                }
                setName(parts[1]);
                setAuthor(parts[2]);
                setDescription(parts[3]);
                String imageName = parts[4];
                String imagePath = staticVariables.getUploadPath() + staticVariables.getBookImageUploadPath() + imageName;
                setImage(imagePath);
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
        try{
        this.id = Integer.parseInt(bookID);
        String result = getBookByID(id);
        return result;
        }
        catch (NumberFormatException e){
            return "error";
        }
    }

    public String updateBook() throws SQLException, ClassNotFoundException, IOException, InterruptedException {
        this.id = Integer.parseInt(this.bookID);
        if (bookImageFileName != null) {
            final String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileDestination = staticVariables.getImageUploadFolderPath() + staticVariables.getBookImageUploadPath();
            String newFileName = uuid + bookImageFileName;
            File fileToCreate = new File(fileDestination, newFileName);
            FileUtils.copyFile(bookImage, fileToCreate);//copying source file to new file  
            // done
            this.image = newFileName;
        }
        BookDao bookDao = new BookDao();
        String updateBook = bookDao.updateBook(id, name, author, description, image);
        String result = getBookByID(id);
        sleep(1500);
        addActionMessage("Update " + updateBook + " successfully");
        return result;
    }

    public UpdateBookAction() {
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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

    public StaticVariables getStaticVariables() {
        return staticVariables;
    }

    public void setStaticVariables(StaticVariables staticVariables) {
        this.staticVariables = staticVariables;
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
