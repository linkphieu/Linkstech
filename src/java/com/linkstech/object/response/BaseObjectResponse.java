/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.object.response;

import com.linkstech.object.BaseObject;
import com.linkstech.object.UtilObject;

/**
 *
 * @author Link Larkin
 */
public class BaseObjectResponse extends BaseObject {

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

    public BaseObjectResponse buildSuccess() {
        this.status = UtilObject.SUCCESS;
        this.message = "Sucess";
        return this;
    }

    public BaseObjectResponse buildError() {
        this.status = UtilObject.ERROR;
        this.message = "Error!";
        return this;
    }
    public BaseObjectResponse buildNullValue(){
        this.status = UtilObject.ERROR;
        this.message = "Null value!";
        return this;
    }
    public BaseObjectResponse buildResquestNotAllowed(){
        this.status = UtilObject.ERROR;
        this.message = "Request not allowed!";
        return this;
    }
}
