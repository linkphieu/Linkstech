/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.security;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Link Larkin
 */
public class SessionHolder extends Thread {

    private static List<UserSession> userSession;
    private static List<BaseSession> requestSessions;
    private static SessionHolder sessionHolder;

    private SessionHolder() {
        userSession = new ArrayList<UserSession>();
        requestSessions = new ArrayList<BaseSession>();
        this.start();
    }

    public static SessionHolder getINSTANCE() {
        if (sessionHolder == null) {
            sessionHolder = new SessionHolder();
        }
        return sessionHolder;
    }

    public void run() {
        while (true) {
            Thread.yield();
            try {
                for (UserSession user : userSession) {
                    long now = Calendar.getInstance().getTimeInMillis();
                    if (user.getLastRequest() < now - 10 * 60 * 1000 || user.getLoginTime() < now - 30 * 60 * 1000) {
                        userSession.remove(user);
                    }
                }
                for (BaseSession registerSession : requestSessions) {
                    if (registerSession.getLastRequest() < Calendar.getInstance().getTimeInMillis() - 3 * 1000) {
                        requestSessions.remove(registerSession);
                    }
                }
                Thread.sleep(1000);
            } catch (Exception io) {

            } finally {
//				 closeNetwork();
            }

        }

    }

    public void addUser(UserSession user) {
        userSession.add(user);
    }

    public boolean isLogin(UserSession user) {
        return userSession.contains(user);
    }

    public UserSession getUser(String token) {
        for (UserSession user : userSession) {
            if (user.getToken().equals(token)) {
                return user;
            }
        }
        return null;
    }

    public boolean removeUser(String token) {
        for (UserSession user : userSession) {
            if (user.getToken().equals(token)) {
                userSession.remove(user);
                return true;
            }
        }
        return false;
    }

    public void addRequestSession(BaseSession registerSession) {
        requestSessions.add(registerSession);
    }

    public BaseSession getRequestSession(String ip) {
        for (BaseSession registerSession : requestSessions) {
            if (registerSession.getIp() == ip) {
                return registerSession;
            }
        }
        return null;
    }
}
