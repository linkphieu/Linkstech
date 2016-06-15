
import com.linkstech.business.UserProcess;
import com.linkstech.object.UserInfo;
import com.linkstech.security.StringEncoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Link Larkin
 */
public class test {
    public static void main(String[] args) {
        UserInfo ui = new UserProcess().login("admin", "trung123");
        System.out.println(ui.toString());
    }
}
