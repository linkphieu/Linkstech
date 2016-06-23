/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.business;

import com.linkstech.DAO.UserDAO;
import com.linkstech.object.UtilObject;
import com.linkstech.object.UserInfo;
import com.linkstech.security.BaseSession;
import com.linkstech.security.RegisterSession;
import com.linkstech.security.UserSession;
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
        SessionHolder sessionHolder = SessionHolder.getINSTANCE();
        long now = Calendar.getInstance().getTimeInMillis();
        password = StringEncoder.encodePassword(password);
        UserInfo userInfo = new UserDAO().login(username, password);
        if (userInfo != null) {
            String token = Security.generateToken(password, UtilObject.ADMIN_PASS);
            sessionHolder.addUser(new UserSession(token, now - 5 * 1000, address, now));
//            sessionHolder.addRequestSession(new BaseSession(now - 5 * 1000, address));
            userInfo.setToken(token);
//        this.userDAO.saveToken(userInfo.getId(), Calendar.getInstance().getTimeInMillis(), token);
        }

        return userInfo;
//        return null;
    }

    public boolean register(String ip, String username, String password) {
        if (!Security.isRegisted(ip)) {
            return false;
        }
        password = StringEncoder.encodePassword(password);
        if (this.userDAO.insertUser(username, password)) {
            RegisterSession registerSession = new RegisterSession();
            registerSession.setIp(ip);
            registerSession.setLastRequest(Calendar.getInstance().getTimeInMillis());
            SessionHolder.getINSTANCE().addRequestSession(registerSession);
            return true;
        }
        return false;
    }

    public boolean logout(String token) {
        return SessionHolder.getINSTANCE().removeUser(token);
    }
}
