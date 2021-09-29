/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.comment;

/**
 *
 * @author sonthanhnguyen
 */
public class CommentDao {

    private final Connection conn;

    public List<comment> listCommentByBook(int bookID) throws SQLException, ClassNotFoundException {
        List<comment> commentList = new ArrayList();
        String sql = "SELECT * FROM comments where bookID = '" + bookID + "';";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            comment c = new comment(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
            UserDao userDao = new UserDao();
            String username = userDao.getUsernameByID(result.getInt(4));
            c.setUsername(username);
            commentList.add(c);
        }
        return commentList;
    }

    public void addComment(String commentContent, int bookID, int userID) throws SQLException {
        String addCommentSQL = "Insert into comments(content, bookID, userID) values ('" + commentContent + "','" + bookID + "','" + userID + "');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(addCommentSQL);
    }

    public void deleteComment(int id) throws SQLException {
        String deleteComment = "Delete from comments where commentID= '" + id + "';";
        System.out.println(""+deleteComment);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(deleteComment);
    }

    public CommentDao() throws SQLException, ClassNotFoundException {
        this.conn = database.connect();
    }

}
