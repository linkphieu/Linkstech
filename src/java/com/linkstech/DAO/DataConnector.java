/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Link
 */
public class DataConnector {

    private Connection conn = null;
    private static DataConnector data = null;

    private DataConnector() {
        try {
            Class.forName(com.mysql.jdbc.Driver.class.getName());
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notification", "root", "trung123");
        } catch (Exception ex) {
//            LoggerHelper.getINSTANCE().log("error", ex);
        }
    }

    public static DataConnector getInstance() {
        if (data == null) {
            data = new DataConnector();
        }
        return data;
    }

    public Connection getConnect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/linkstech", "root", "123456");
//            return DriverManager.getConnection("jdbc:mysql://localhost:3306/notifygame", "notify", "notify^&*");
        } catch (SQLException ex) {
//            LoggerHelper.getINSTANCE().log("error", ex);
        }
        return null;
    }
}
