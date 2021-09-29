/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sonthanhnguyen
 */
public class database {
    private static String url = "jdbc:mysql://localhost:3306/strustdb";
    private static String host = "root";
    private static String password = "";
    public static Connection connect() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, host, password);
    }
}
