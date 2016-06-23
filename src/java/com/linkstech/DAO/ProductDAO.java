/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.DAO;

import com.linkstech.object.ProductObject;
import com.linkstech.object.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Link Larkin
 */
public class ProductDAO {

    private Connection connection;
    private DataConnector dataConnector;

    public ProductDAO() {
        dataConnector = DataConnector.getInstance();
    }

    private void closeConnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
//            LoggerHelper.getINSTANCE().log("error", ex);
        }
    }

    public List<ProductObject> getProduct(double lat, double lon, int distance) {
        List<ProductObject> list = new ArrayList<ProductObject>();
        connection = dataConnector.getConnect();
        try {
            PreparedStatement st = connection.prepareStatement("select a.*,b.screen_name from (select *,(111.1896 * DEGREES(ACOS(COS(RADIANS(?)) * COS(RADIANS(lat)) * COS(RADIANS(? - lon)) + SIN(RADIANS(?)) * SIN(RADIANS(lat)))) * 1000) as distance from product) a join user_info b on a.userId = b.user_id where a.distance < ?");
            st.setDouble(1, lat);
            st.setDouble(2, lon);
            st.setDouble(3, lat);
            st.setInt(4, distance);
            ResultSet result = st.executeQuery();
            while (result.next()) {
                list.add(new ProductObject(result.getInt("id"), result.getInt("userId"), result.getString("screen_name"), result.getString("ad_text"), result.getLong("price"), result.getString("price_unit"), result.getString("liked"), 0, result.getDouble("lat"), result.getDouble("lon"), result.getDouble("distance"), "m"));
            }
        } catch (Exception ex) {
//            LoggerHelper.getINSTANCE().log("error", ex);
            return null;
        } finally {
            closeConnect();
        }
        return list;
    }

    public int getCommentCount(int productId) {
        connection = dataConnector.getConnect();
        try {
            PreparedStatement st = connection.prepareStatement("select count(*) as count from product_comment where productId = ?");
            st.setInt(1, productId);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                return result.getInt("count");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            closeConnect();
        }
        return 0;
    }
}
