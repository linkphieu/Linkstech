/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.business;

import com.linkstech.DAO.UserDAO;
import com.linkstech.object.UltilObject;
import com.linkstech.object.UserInfo;
import com.linkstech.object.UserSession;
import com.linkstech.security.Security;
import com.linkstech.security.SessionHolder;
import com.linkstech.security.StringEncoder;
import java.util.Calendar;

/**
 *
 * @author Link Larkin
 */
public class UserProcess {

    private UserDAO userDAO;

    public UserProcess() {
        userDAO = new UserDAO();
    }

    public boolean isValidUser(String username, String password) {
        return false;
    }

    public UserInfo login(String address, String username, String password) {
        password += UltilObject.admin_pass;
        password = StringEncoder.encode(password);
        UserInfo userInfo = new UserDAO().login(username, password);
        if (userInfo != null) {
            String token = Security.generateToken(password, UltilObject.admin_pass);
            long now = Calendar.getInstance().getTimeInMillis();
            SessionHolder.getINSTANCE().addUser(new UserSession(token, now-10*1000, address, now));
            userInfo.setToken(token);
//        this.userDAO.saveToken(userInfo.getId(), Calendar.getInstance().getTimeInMillis(), token);
        }
        return userInfo;
//        return null;
    }
}
