/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.service;

import com.linkstech.DAO.UserDAO;
import java.io.File;
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
        File file = new File("././linkstech/images/smartcook.jpg");
        return Response.status(200).entity(file.getAbsolutePath()).header("Content-Type", "application/json;charset=UTF-8").build();
    }

    
}
