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

    private int id;
    private long lastRequest;
    private String ip;

    public UserSession(int id, long lastRequest, String ip) {
        this.id = id;
        this.lastRequest = lastRequest;
        this.ip = ip;
    }

    public UserSession(String string, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
