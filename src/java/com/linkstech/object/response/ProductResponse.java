package com.linkstech.object.response;

import com.linkstech.object.ProductObject;

import java.util.List;

/**
 * Created by Link Larkin on 6/22/2016.
 */
public class ProductResponse extends BaseObjectResponse {
    private List<ProductObject> data;

    public List<ProductObject> getData() {
        return data;
    }

    public void setData(List<ProductObject> data) {
        this.data = data;
    }
}
