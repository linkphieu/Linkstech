/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.security;

import java.util.Calendar;

/**
 *
 * @author Link Larkin
 */
public class Security {

    public static String generateToken(String pass, String adminPass) {
        return StringEncoder.encode(pass + Calendar.getInstance().getTimeInMillis() + adminPass);
    }

    public static boolean isValidToken(String token, String address) {
        UserSession userSession = SessionHolder.getINSTANCE().getUser(token);
        long now = Calendar.getInstance().getTimeInMillis();
        if (userSession == null || userSession.getLastRequest() > now - 15 * 1000 || 
                !userSession.getIp().equals(address) || 
                userSession.getLoginTime() < Calendar.getInstance().getTimeInMillis() - 30 * 60 * 1000) {
            return false;
        }
        userSession.setLastRequest(now);
        return true;
    }
    public static boolean isRegisted(String ip){
        BaseSession registerSession = SessionHolder.getINSTANCE().getRequestSession(ip);
        if(registerSession==null){
            return true;
        }
        return false;
    }
}
