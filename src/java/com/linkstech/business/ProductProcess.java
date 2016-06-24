/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.business;

import com.google.gson.Gson;
import com.linkstech.DAO.ProductDAO;
import com.linkstech.object.ProductObject;
import com.linkstech.security.BaseSession;
import com.linkstech.security.Security;
import com.linkstech.security.SessionHolder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Link Larkin
 */
public class ProductProcess {

    private ProductDAO productDAO;

    public ProductProcess() {
        productDAO = new ProductDAO();
    }

    public List<ProductObject> getAllProduct(String ip, double lat, double lon) {
//        SessionHolder.getINSTANCE().getUser(token);
        SessionHolder.getINSTANCE().addRequestSession(new BaseSession(Calendar.getInstance().getTimeInMillis(), ip));
        List<ProductObject> list = productDAO.getProduct(21.010711, 105.821999, 10000);
        for (ProductObject po : list) {
            po.setCommentCount(productDAO.getCommentCount(po.getId()));
        }
        return list;
    }

    public boolean insertProduct(String product) {
        ProductObject productObject = new Gson().fromJson(product, ProductObject.class);
        if (Security.isValidProduct(productObject)) {
            return productDAO.insertProduct(productObject);
        }
        return false;
    }
}
