/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.service;

import com.linkstech.helper.LoggerHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 *
 * @author Link Larkin
 */
//@Path("/test")
public class test {

    @GET
    public Response getProduct(@Context HttpServletRequest request) {
        
        String oldline = "";
        File f = new File(System.getenv("OPENSHIFT_DATA_DIR") + "test.txt");
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

    @POST
    @Path("/uploadfile")
    public void post(File file) {
        try {
            Reader reader = new Reader(new FileInputStream(file)) {
                @Override
                public int read(char[] cbuf, int off, int len) throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void close() throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            // ... 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
