/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.database;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.user;
import utils.Password;

/**
 *
 * @author sonthanhnguyen
 */
public class UserDao {

    private final Connection conn;

    public UserDao() throws SQLException, ClassNotFoundException {
        this.conn = database.connect();
    }

    public String validateLogin(String username, String password) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        Password pw = new Password();
        String hashedPassword = pw.makePassword(password);
        String sql = "SELECT * FROM users where username = '" + username + "' and password = '" + hashedPassword + "';";
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = stmt.executeQuery(sql);
        if (result.next()) {
            // count result
            result.beforeFirst();
            result.last();
            int rowCount = result.getRow();
            if (rowCount > 1) {
                // return null if more than 1
                stmt.close();
                return "";
            }
            String userID = result.getString(1);
            String loginUsername = result.getString(2);
            String returnResult = userID + ";" + loginUsername;
            stmt.close();
            return returnResult;
            // no result
        } else {
            stmt.close();
            return "";
        }
    }

    public List<user> getAllUser() throws SQLException, ClassNotFoundException {
        List<user> userList = new ArrayList();
        String sql = "SELECT * FROM USERS ORDER BY userID desc;";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            user u = new user(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4), result.getString(5), result.getString(6), result.getString(7));
            userList.add(u);
        }
        stmt.close();
        return userList;
    }

    public boolean checkByUsername(String username) throws SQLException, ClassNotFoundException {
        String sql = "SELECT username FROM users Where username = '" + username + "';";
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        if (resultSet.next()) {
            return false;
        }
        return true;
    }

    public String createUser(String username, String password, int isAdmin, String email, String name, String avatar) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        Password pw = new Password();
        String hasedPassword = pw.makePassword(password);
        String sql = "INSERT INTO users(username, password, isAdmin, email, name, avatar) VALUES ('" + username + "','" + hasedPassword + "','" + isAdmin + "','" + email + "','" + name + "','" + avatar + "');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        return username;
    }

    public boolean checkAdmin(String username) throws SQLException {
        String sql = "SELECT isAdmin FROM users WHERE username = '" + username + "';";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        result.next();
        System.out.println("" + result.getBoolean(1));
        return result.getBoolean(1);
    }

    public String updateUser(int id, String username, String password, int isAdmin, String email, String name, String avatar) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String sql;
        if (!password.equals("")) {
            Password pw = new Password();
            String hasedPassword = pw.makePassword(password);
            sql = "Update users set password = '" + hasedPassword + "' where userID = " + id;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        if (avatar != null) {
            sql = "Update users set avatar ='" + avatar + "'where userID = " + id + ";";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        sql = "Update users set isAdmin = '" + isAdmin + "', email = '" + email + "', name = '" + name + "' WHERE userID = " + id + ";";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        return username;
    }

    public String getUserByID(int id) throws SQLException {
        String sql = "Select * from users where userID = " + id + ";";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        String info;
        if (result.next()) {
            user u = new user(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4), result.getString(5), result.getString(6), result.getString(7));
            info = u.toString();
            return info;
        }
        return "";
    }

    public String getUsernameByID(int id) throws SQLException {
        String sql = "Select username from users where userID = " + id + ";";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        if (result.next()) {
            return result.getString(1);
        } else {
            return "";
        }
    }

    public String deleteUser(int id) throws SQLException {
        String selectSQL = "Select * from users where userID = " + id + ";";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(selectSQL);
        if (result.next()) {
            String deleteSQL = "Delete from users where userID = " + id + ";";
            String deleteUser = result.getString(1);
            stmt.execute(deleteSQL);
            return deleteUser;
        } else {
            return "";
        }

    }

}
