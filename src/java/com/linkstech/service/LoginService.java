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
        String address = requestContext.getRemoteAddr();
        UserInfo user = new UserProcess().login(address,username, password);
        return Response.status(200).entity(requestContext.getRemoteAddr() + (user != null ? user.toString() : null)).build();

    }
}
