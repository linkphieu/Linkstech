
import com.linkstech.DAO.DataConnector;
import com.linkstech.business.ProductProcess;
import com.linkstech.object.response.ProductResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import org.apache.tomcat.util.codec.binary.Base64;

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

    public static void main(String[] args) {
 
        File file = new File("C:/Users/Link Larkin/Desktop/test.jpg");
 
        try {            
            // Reading a Image file from file system
            FileInputStream imageInFile = new FileInputStream(file);
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
 
            // Converting Image byte array into Base64 String
            String imageDataString = encodeImage(imageData);
            System.out.println(imageDataString);
            // Converting a Base64 String into Image byte array
            byte[] imageByteArray = decodeImage(imageDataString);
 
            // Write a image byte array into file system
            FileOutputStream imageOutFile = new FileOutputStream(
                    "C:/Users/Link Larkin/Desktop/test2.jpg");
// 
            imageOutFile.write(imageByteArray);
 
            imageInFile.close();
            imageOutFile.close();
 
            System.out.println("Image Successfully Manipulated!");
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
    }
 
    /**
     * Encodes the byte array into base64 string
     *
     * @param imageByteArray - byte array
     * @return String a {@link java.lang.String}
     */
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
