/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.security;

import com.linkstech.object.ProductObject;
import java.util.Calendar;

/**
 *
 * @author Link Larkin
 */
public class Security {

    public static String generateToken(String pass) {
        return StringEncoder.encodePassword(pass + Calendar.getInstance().getTimeInMillis());
    }

    public static boolean isValidToken(String token, String address) {
        UserSession userSession = SessionHolder.getINSTANCE().getUser(token);
        long now = Calendar.getInstance().getTimeInMillis();
        if (userSession == null || userSession.getLastRequest() > now - 5 * 1000
                || !userSession.getIp().equals(address)) {
            return false;
        }
        userSession.setLastRequest(now);
        return true;
    }

    public static boolean isRegisted(String ip) {
        BaseSession registerSession = SessionHolder.getINSTANCE().getRequestSession(ip);
        if (registerSession == null) {
            return true;
        }
        return false;
    }

    public static boolean isValidProduct(ProductObject po) {
        if (po.getUserId() == 0) {
            return false;
        }
        if (po.getAdText() == null || po.getAdText().equals("")) {
            return false;
        }
        if (po.getPrice() < 1) {
            return false;
        }
        if (po.getPriceUnit() == null || po.getPriceUnit().equals("")) {
            return false;
        }
        if (po.getImage() == null || po.getImage().equals("")) {
            return false;
        }
        if (po.getLat() == null) {
            return false;
        }
        return po.getLon() != null;
    }
}
