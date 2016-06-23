/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.business;

import com.linkstech.DAO.ProductDAO;
import com.linkstech.object.ProductObject;
import com.linkstech.security.Security;
import java.util.ArrayList;
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
    
    public List<ProductObject> getAllProduct(String token, String ip, double lat, double lon) {
//        SessionHolder.getINSTANCE().getUser(token);
        if (!Security.isValidToken(token, ip)) {
            return null;
        }
        List<ProductObject> list = productDAO.getProduct(21.010711, 105.821999, 10000);
        for (ProductObject po : list) {
            po.setCommentCount(productDAO.getCommentCount(po.getId()));
        }
        return list;
    }
}
