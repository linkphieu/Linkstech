/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.DAO;

import com.linkstech.object.UserInfo;
import java.sql.Connection;
import com.linkstech.object.UserSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Link Larkin
 */
public class UserDAO {
    private Connection connection;
    private DataConnector dataConnector;

    public UserDAO() {
        dataConnector = DataConnector.getInstance();
    }
    private void closeConnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
//            LoggerHelper.getINSTANCE().log("error", ex);
        }
    }
    public UserInfo login(String username,String password){
        connection = dataConnector.getConnect();
        try {
            PreparedStatement st = connection.prepareStatement("select * from user where username=? and password=? and status = 1");
            st.setString(1, username);
            st.setString(2,password);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                return new UserInfo(result.getInt("id"),result.getString("username"),result.getString("token"));
            }
        } catch (Exception ex) {
//            LoggerHelper.getINSTANCE().log("error", ex);
            return null;
        } finally {
            closeConnect();
        }
        return null;
    }

}
