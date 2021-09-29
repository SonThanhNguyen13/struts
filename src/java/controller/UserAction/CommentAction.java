/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.UserAction;

import com.opensymphony.xwork2.ActionSupport;
import dao.CommentDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonthanhnguyen
 */
public class CommentAction extends ActionSupport {

    private String commentContent;
    private String bookID;
    private String userID;
    private String commentID;

    public String createComment() {
        CommentDao commentDao;
        try {
            if (!userID.equals("")) {
                int uID = Integer.parseInt(userID);
                int bID = Integer.parseInt(bookID);
                System.out.println("" + commentContent);
                commentDao = new CommentDao();
                commentDao.addComment(commentContent, bID, uID);
                return "success";
            } else {
                return "error";
            }

        } catch (SQLException ex) {
            return "error";
        } catch (ClassNotFoundException ex) {
            return "error";
        }
    }

    public String deleteComment() {
        try {
            int cmtID = Integer.parseInt(commentID);
            CommentDao commentDao;
            commentDao = new CommentDao();
            commentDao.deleteComment(cmtID);
            return "success";
        } catch (SQLException ex) {
            return "error";
        } catch (ClassNotFoundException ex) {
            return "error";
        }
    }

    public CommentAction() {
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

}
