/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.object.response;


import com.linkstech.object.UserInfo;

/**
 *
 * @author Link Larkin
 */
public class LoginResponse extends BaseObjectResponse{
    private UserInfo data;

    public LoginResponse(int status, String message, UserInfo data) {
        super.status = status;
        super.message = message;
        this.data = data;
    }

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }
    
}
