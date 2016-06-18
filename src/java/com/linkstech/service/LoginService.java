/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.linkstech.object.UserInfo;
import com.linkstech.DAO.*;
import com.linkstech.business.UserProcess;
import com.linkstech.object.UtilObject;
import com.linkstech.object.response.BaseObjectResponse;
import com.linkstech.object.response.LoginResponse;
import com.linkstech.security.Security;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

/**
 *
 * @author Link Larkin
 */
@Path("/login")
public class LoginService {

    @GET
    public Response login(@Context HttpServletRequest requestContext, @QueryParam("username") String username, @QueryParam("password") String password) {
        BaseObjectResponse baseObjectResponse = new BaseObjectResponse(UtilObject.ERROR, "Request not allowed!");
        if (username == null || username.equals("") || password == null || password.equals("")) {
            baseObjectResponse.setMessage("username or password null!");
            return Response.status(200).entity(baseObjectResponse.toString()).build();
        }
        String ip = requestContext.getRemoteAddr();
        if (!Security.isRegisted(ip)) {
            return Response.status(401).entity(baseObjectResponse.toString()).build();
        }
        UserInfo user = new UserProcess().login(ip, username, password);
        LoginResponse loginResponse = new LoginResponse(UtilObject.SUCCESS, "success", user);
        if (user == null) {
            loginResponse.setStatus(UtilObject.LOGIN_ERROR);
            loginResponse.setMessage("Login failed!");
        }
        return Response.status(200).entity(loginResponse.toString()).build();

    }

    @POST
    public Response logout(@Context HttpServletRequest requestContext, @QueryParam("token") String token) {
        String ip = requestContext.getRemoteAddr();
        BaseObjectResponse baseObjectResponse = new BaseObjectResponse(UtilObject.ERROR, "Request not allowed!");
        if (!Security.isRegisted(ip)) {
            return Response.status(200).entity(baseObjectResponse.toString()).build();
        }
        boolean result = new UserProcess().logout(token);
        if (result) {
            baseObjectResponse.setStatus(UtilObject.SUCCESS);
            baseObjectResponse.setMessage("success");
        } else {
            baseObjectResponse.setMessage("Error! Check your username and password!");
        }
        return Response.status(200).entity(baseObjectResponse.toString()).build();
    }
}
