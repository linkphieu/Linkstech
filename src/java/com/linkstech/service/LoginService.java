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
        BaseObjectResponse response = new BaseObjectResponse().buildResquestNotAllowed();
        if (username == null || username.equals("") || password == null || password.equals("")) {
            return Response.status(200).entity(response.buildNullValue().toString()).build();
        }
        String ip = requestContext.getRemoteAddr();
        if (!Security.isRegisted(ip)) {
            return Response.status(200).entity(response.toString()).build();
        }
        UserInfo user = new UserProcess().login(ip, username, password);
        LoginResponse loginResponse = new LoginResponse(UtilObject.SUCCESS, "Success", user);
        if (user == null) {
            loginResponse.setStatus(UtilObject.LOGIN_ERROR);
            loginResponse.setMessage("Login failed!");
        }
        return Response.status(200).entity(loginResponse.toString()).build();

    }

    @POST
    public Response logout(@Context HttpServletRequest requestContext, @QueryParam("token") String token) {
        BaseObjectResponse response = new BaseObjectResponse().buildResquestNotAllowed();
        if (token == null || token.equals("")) {
            return Response.status(200).entity(response.buildNullValue().toString()).build();
        }
        String ip = requestContext.getRemoteAddr();
        if (!Security.isRegisted(ip)) {
            return Response.status(200).entity(response.toString()).build();
        }
        boolean result = new UserProcess().logout(token);
        if (result) {
            response.buildSuccess();
        } else {
            response.buildError();
        }
        return Response.status(200).entity(response.toString()).build();
    }
}
