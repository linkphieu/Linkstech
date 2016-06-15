/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.security;

import com.linkstech.object.UserSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Link Larkin
 */
public class SessionHolder extends Thread {

    private static List<UserSession> sessions;
    private static SessionHolder sessionHolder;
    private static int count = 1;
    private SessionHolder() {
        sessions = new ArrayList<UserSession>();
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
                System.out.println("running session size:" + sessions.size() +" count" +count++);
                for (UserSession user : sessions) {
                    if (user.getLastRequest() < Calendar.getInstance().getTimeInMillis() - 1 * 60 * 1000) {
                        sessions.remove(user);
                    }
                }
                Thread.sleep(10000);
            } catch (Exception io) {

            } finally {
//				 closeNetwork();
            }

        }

    }

    public void addUser(UserSession user) {
        sessions.add(user);
    }

    public boolean isLogin(UserSession user) {
        return sessions.contains(user);
    }

    public UserSession getUser(int userId) {
        for (UserSession user : sessions) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }
}
