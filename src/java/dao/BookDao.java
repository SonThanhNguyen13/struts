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
import model.book;

/**
 *
 * @author sonthanhnguyen
 */
public class BookDao {

    private final Connection conn;

    public BookDao() throws SQLException, ClassNotFoundException {
        this.conn = database.connect();
    }

    public List<book> getAllBook() throws SQLException {
        List<book> bookList = new ArrayList();
        String sql = "SELECT * FROM BOOKS ORDER BY bookID DESC;";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            book b = new book(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
            bookList.add(b);
        }
        stmt.close();
        return bookList;
    }

    public String getBookById(int id) throws SQLException {
        String sql = "Select * from books where bookID = " + id + ";";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        String info;
        if (result.next()) {
            book b = new book(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
            info = b.toString();
            return info;
        }
        return "";
    }

    public String createBook(String name, String author, String description, String image) throws SQLException {
        String sql = "INSERT INTO books(name, author, description, image) values (' " + name + "', '" + author + "', '" + description + "', '" + image + "');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        return name;
    }

    public String updateBook(int id, String name, String author, String desription, String image) throws SQLException {
        String sql;
        Statement stmt = conn.createStatement();
        if (!name.equals("")) {
            sql = "UPDATE books SET name = '" + name + "' WHERE bookID = " + id + ";";
            stmt.executeUpdate(sql);
        }
        if (!author.equals("")) {
            sql = "UPDATE books SET author = '" + author + "' WHERE bookID = " + id + ";";
            stmt.executeUpdate(sql);
        }
        if (!desription.equals("")) {
            sql = "UPDATE books SET description = '" + desription + "' WHERE bookID = " + id + ";";
            stmt.executeUpdate(sql);
        }
        if (image != null) {
            sql = "UPDATE books SET image = '" + image + "' WHERE bookID = " + id + ";";
            stmt.executeUpdate(sql);
        }
        stmt.close();
        return name;

    }

    public String deleteBook(int id) throws SQLException {
        String selectSQL = "Select name from books where bookID = " + id + ";";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(selectSQL);
        if (result.next()) {
            String deleteSQL = "Delete from books where bookID = " + id + ";";
            String deleteBook = result.getString(1);
            stmt.execute(deleteSQL);
            return deleteBook;
        } else {
            return "";
        }
    }

    public List<book> searchBook(String keyword) throws SQLException {
        List<book> bookList = new ArrayList();
        String searchSQL = "SELECT * FROM books where name LIKE '%" + keyword + "%' UNION SELECT * FROM books WHERE author like '%" + keyword + "%';";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(searchSQL);
        while (result.next()) {
            book b = new book(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
            bookList.add(b);
        }
        stmt.close();
        return bookList;
    }

}
