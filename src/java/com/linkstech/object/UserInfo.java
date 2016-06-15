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
public class UserInfo extends BaseObject{
    private int id;
    private String username;
    private String token;

    public UserInfo(int id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
