/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.service;

import com.linkstech.DAO.UserDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Link Larkin
 */
@Path("/test")
public class test {

    @GET
    public Response getProduct() {
        return Response.status(200).entity(new UserDAO().insertUser2("test", "test")).header("Content-Type", "application/json;charset=UTF-8").build();
    }
}
