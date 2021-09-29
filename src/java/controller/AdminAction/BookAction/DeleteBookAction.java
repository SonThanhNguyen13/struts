/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.AdminAction.BookAction;

import com.opensymphony.xwork2.ActionSupport;
import config.StaticVariables;
import dao.BookDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonthanhnguyen
 */
public class DeleteBookAction extends ActionSupport {

    private StaticVariables staticVariables = new StaticVariables();
    private String bookID;
    private String name;
    private int id;
    private String image;

    public String execute() throws SQLException, ClassNotFoundException {
        try {
            this.id = Integer.parseInt(this.bookID);
            BookDao bookDao = new BookDao();
            String bookInfo = bookDao.getBookById(id);
            if (bookInfo.equals("")){
                return "error";
            }
            String[] parts = bookInfo.split(";");
            setName(parts[1]);
            String imageName = parts[4];
            String imagePath = staticVariables.getUploadPath() + staticVariables.getBookImageUploadPath() + imageName;
            setImage(imagePath);
            return "success";
        } catch (SQLException e) {
            return "error";
        } catch (ClassNotFoundException e) {
            return "error";
        } catch (NumberFormatException e) {
            return "error";
        }
    }

    public String deleteBook() throws ClassNotFoundException {
        try {
            this.id = Integer.parseInt(this.bookID);
            BookDao bookDao = new BookDao();
            String deleteBook = bookDao.deleteBook(id);
            setName(deleteBook);
            addActionMessage("Successfully delete book " + deleteBook);
            return "success";
        } catch (SQLException e) {
            addActionError("Not found");
            return "error";
        }
    }

    public DeleteBookAction() {
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
