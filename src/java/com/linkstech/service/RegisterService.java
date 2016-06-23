/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.service;

import com.linkstech.business.UserProcess;
import com.linkstech.object.response.BaseObjectResponse;
import com.linkstech.security.Security;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 *
 * @author Link Larkin
 */
@Path("/register")
public class RegisterService {

    @POST
    public Response register(@Context HttpServletRequest request, @QueryParam("username") String username, @QueryParam("password") String password) {
        BaseObjectResponse baseObjectResponse = new BaseObjectResponse().buildResquestNotAllowed();
        if (username == null || username.equals("") || password == null || password.equals("")) {
            return Response.status(200).entity(baseObjectResponse.buildNullValue().toString()).build();
        }
        String ip = request.getRemoteAddr();
        if (!Security.isRegisted(ip)) {
            return Response.status(200).entity(baseObjectResponse.toString()).build();
        }

        boolean result = new UserProcess().register(request.getRemoteAddr(), username, password);
        if (result) {
            baseObjectResponse.buildSuccess();
        } else {
            baseObjectResponse.buildError();
        }
        return Response.status(200).entity(baseObjectResponse.toString()).build();
    }
}
