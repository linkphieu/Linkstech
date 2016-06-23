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
public class BaseSession {

    long lastRequest;
    String ip;

    public BaseSession() {
    }

    public BaseSession(String ip) {
        this.ip = ip;
    }
    
    public BaseSession(long lastRequest, String ip) {
        this.lastRequest = lastRequest;
        this.ip = ip;
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
