/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.object;

/**
 *
 * @author Link Larkin
 */
public class UserSession {

    private String token;
    private long lastRequest;
    private String ip;
    private long loginTime;

    public UserSession(String token, long lastRequest, String ip, long loginTime) {
        this.token = token;
        this.lastRequest = lastRequest;
        this.ip = ip;
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


    public long getLastRequest() {
        return lastRequest;
    }

    public void setLastRequest(long lastRequest) {
        this.lastRequest = lastRequest;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
  
    
}
