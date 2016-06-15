/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.business;

import com.linkstech.security.Security;

/**
 *
 * @author Link Larkin
 */
public class ProductProcess {
    public String getAllProduct(String token,String address){
//        SessionHolder.getINSTANCE().getUser(token);
        if(!Security.isValidToken(token, address)){
            return "false";
        }
        return "success";
    }
}
