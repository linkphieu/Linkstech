/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.service;

import com.linkstech.business.ProductProcess;
import com.linkstech.business.UserProcess;
import com.linkstech.object.UserInfo;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 *
 * @author Link Larkin
 */
@Path("/product")
public class ProductService {
    @GET
    public Response login(@Context HttpServletRequest requestContext,@QueryParam("token") String token) {
        
        return Response.status(200).entity(new ProductProcess().getAllProduct(token,requestContext.getRemoteAddr())).build();

    }
}
