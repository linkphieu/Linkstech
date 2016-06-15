/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.business;

import com.linkstech.DAO.UserDAO;
import com.linkstech.object.UltilObject;
import com.linkstech.object.UserInfo;
import com.linkstech.security.StringEncoder;

/**
 *
 * @author Link Larkin
 */
public class UserProcess {
    
    public boolean isValidUser(String username, String password) {
        return false;
    }

    public UserInfo login(String username, String password) {
        password += UltilObject.admin_pass;
        password = StringEncoder.encode(password);
        return new UserDAO().login(username, password);
//        return null;
    }
}
