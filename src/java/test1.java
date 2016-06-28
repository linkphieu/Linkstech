
import java.io.File;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

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

    public static void main(String[] args) throws Exception {
        MultipartEntity entity = new MultipartEntity();
        entity.addPart("file", new FileBody(new File("C:\\Users\\Link Larkin\\Desktop\\test.jpg")));
        
        HttpPost request = new HttpPost("http://localhost:8084/linkstech/upload");
        request.setEntity(entity);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(request);
    }

}
