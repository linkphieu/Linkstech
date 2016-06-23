/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.service;

import com.google.gson.Gson;
import com.linkstech.business.ProductProcess;
import com.linkstech.object.ProductObject;
import com.linkstech.object.response.BaseObjectResponse;
import com.linkstech.object.response.ProductResponse;
import com.linkstech.security.Security;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    public Response getProduct(@Context HttpServletRequest requestContext, @QueryParam("token") String token, @QueryParam("lat") double lat, @QueryParam("lon") double lon) {
        BaseObjectResponse baseObjectResponse = new BaseObjectResponse().buildResquestNotAllowed();
        if (token == null || token.equals("")) {
            return Response.status(200).entity(baseObjectResponse.buildNullValue().toString()).build();
        }
        String ip = requestContext.getRemoteAddr();
        if (!Security.isValidToken(token, ip)) {
            return Response.status(200).entity(baseObjectResponse.toString()).build();
        }
        ProductResponse productResponse = new ProductResponse();
        List<ProductObject> list = new ProductProcess().getAllProduct(token, ip, lat, lon);
        if (list != null) {
            productResponse.buildSuccess();
            productResponse.setData(list);
        } else {
            productResponse.buildError();
        }
        return Response.status(200).entity(productResponse.toString()).header("Content-Type", "application/json;charset=UTF-8").build();
    }

    @POST
    public Response insertProduct(@Context HttpServletRequest requestContext, @QueryParam("token") String token, @QueryParam("product") String product) {
        BaseObjectResponse baseObjectResponse = new BaseObjectResponse().buildResquestNotAllowed();
        if (token == null || token.equals("") || product == null || product.equals("")) {
            return Response.status(200).entity(baseObjectResponse.buildNullValue().toString()).build();
        }
        String ip = requestContext.getRemoteAddr();
        if (!Security.isValidToken(token, ip)) {
            return Response.status(200).entity(baseObjectResponse.toString()).build();
        }
//        ProductObject productObject = new Gson().fromJson(product, ProductObject.class);
        boolean result = new ProductProcess().insertProduct(product);
        if (result) {
            baseObjectResponse.buildSuccess();
        } else {
            baseObjectResponse.buildError();
        }
        return Response.status(200).entity(baseObjectResponse.toString()).header("Content-Type", "application/json;charset=UTF-8").build();
    }
}
