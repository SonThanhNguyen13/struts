/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.UserAction;

import config.StaticVariables;
import dao.BookDao;
import dao.CommentDao;
import java.sql.SQLException;
import java.util.List;
import model.comment;

/**
 *
 * @author sonthanhnguyen
 */
public class BookDetailAction {

    private String bookID;
    private int id;
    private String name;
    private String author;
    private String description;
    private String image;
    private StaticVariables staticVariables = new StaticVariables();
    private List<comment> commentList;

    public String execute() throws SQLException, ClassNotFoundException {
        try{
        this.id = Integer.parseInt(bookID);
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
            CommentDao commentDao = new CommentDao();
            commentList = commentDao.listCommentByBook(id);
            return "success";
        } else {
            return "error";
        }}
        catch (NumberFormatException e){
            return  "error";
        }
    }

    public BookDetailAction() {
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

    public List<comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<comment> commentList) {
        this.commentList = commentList;
    }

}
