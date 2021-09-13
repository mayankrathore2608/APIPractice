import Utils.APIUrl;
import Utils.Client;
import Utils.GetHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class CreatePullRequest {
   private static String path="/repos/encode/django-rest-framework/pulls";
   private static String payload;



   public static void createPayload(){
       JSONObject jsonObj = new JSONObject();

       jsonObj.put("title","Creating PR");
       jsonObj.put("head","gh-pages");
       jsonObj.put("base","master");
       jsonObj.put("body","Testing");
       jsonObj.put("maintainer_can_modify","true");

       payload = jsonObj.toString();
       System.out.println(payload);

   }
@Test
    public static void testCreationOfPR() throws IOException {
        String keys[]={"accept"};
        Client client = new Client();
        createPayload();
        System.out.println(APIUrl.getURL(path));
        CloseableHttpResponse response=(CloseableHttpResponse) client.postRequest(APIUrl.getURL(path), GetHeaders.getHeaders(keys),payload);
        int status =response.getStatusLine().getStatusCode();
        Assert.assertEquals(status,201);
    }










}
