/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.object.response;

import com.linkstech.object.BaseObject;

/**
 *
 * @author Link Larkin
 */
public class BaseObjectResponse extends BaseObject{

    int status;
    String message;

    public BaseObjectResponse() {
    }

    public BaseObjectResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
