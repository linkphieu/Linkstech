/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.security;

/**
 *
 * @author Link Larkin
 */
public class UserSession extends BaseSession{

    private String token;
    private long loginTime;

    public UserSession(String token, long lastRequest, String ip, long loginTime) {
        this.token = token;
        super.lastRequest = lastRequest;
        super.ip = ip;
        this.loginTime = loginTime;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

   

    public String getToken() {
        return token;
    }

    public void setToken(String id) {
        this.token = id;
    }
    
}
