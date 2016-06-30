/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.object.response;

import com.linkstech.object.FileObject;

/**
 *
 * @author Link Larkin
 */
public class FileResponse extends BaseObjectResponse {

    private FileObject data;

    public FileObject getData() {
        return data;
    }

    public void setData(FileObject data) {
        this.data = data;
    }

}
