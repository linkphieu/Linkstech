/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.service;

import com.linkstech.object.response.BaseObjectResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Link Larkin
 */
@Path("/files")
public class FileService {

    @POST
    @Path("/uploadImage")
    @Consumes(MediaType.WILDCARD)
    public Response upload(String image) {
        System.out.println(image);
        writeToFile(image);
        return Response.status(200).entity(new BaseObjectResponse().buildSuccess()).build();
    }

    // save uploaded file to new location
    private void writeToFile(String image) {
        try {
            byte[] imageByteArray = decodeImage(image);
            // Write a image byte array into file system
            FileOutputStream imageOutFile = new FileOutputStream("C:/Users/Link Larkin/Desktop/test2.jpg");
            imageOutFile.write(imageByteArray);
            imageOutFile.close();

            System.out.println("Image Successfully Manipulated!");
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }

    }

    public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
    }

    /**
     * Decodes the base64 string into byte array
     *
     * @param imageDataString - a {@link java.lang.String}
     * @return byte array
     */
    public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }
}
