/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.service;

import com.linkstech.DAO.UserDAO;
import com.linkstech.helper.LoggerHelper;
import static com.linkstech.helper.LoggerHelper.getStackTrace;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Link Larkin
 */
@Path("/test")
public class test {

    @GET
    public Response getProduct() {
        String oldline = "";
        File f = new File(System.getenv("OPENSHIFT_DATA_DIR")+ "test.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            oldline = br.readLine();
        } catch (Exception ex) {
            Logger.getLogger(LoggerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PrintWriter out = new PrintWriter(System.getenv("OPENSHIFT_DATA_DIR") + "test.jpg");
            out.write(oldline);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoggerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.status(200).entity("test was uploaded to " + System.getenv("OPENSHIFT_DATA_DIR")).header("Content-Type", "application/json;charset=UTF-8").build();
    }

}
