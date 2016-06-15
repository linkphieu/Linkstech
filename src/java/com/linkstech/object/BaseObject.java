/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.object;

import com.google.gson.Gson;

/**
 *
 * @author Link Larkin
 */
public class BaseObject {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
    
}
