
import com.linkstech.DAO.DataConnector;
import com.linkstech.business.ProductProcess;
import com.linkstech.object.response.ProductResponse;
import java.sql.SQLException;
import java.text.DecimalFormat;

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
        double x = 1763.2343543005602;
        DecimalFormat df = new DecimalFormat("#.#");
        String dx = df.format(x/1000);
        x = Double.valueOf(dx);
        System.out.println(x);
    }
}
