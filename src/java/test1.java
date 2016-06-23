
import com.linkstech.DAO.DataConnector;
import com.linkstech.business.ProductProcess;
import com.linkstech.object.response.ProductResponse;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Link Larkin
 */
public class test1 {
    
	public static void main(String[] args) throws SQLException {

            ProductResponse productResponse = new ProductResponse();
            productResponse.buildSuccess();
//            productResponse.setData(new ProductProcess().getAllProduct("", ""));
            System.out.println(productResponse.toString());
	}
}
