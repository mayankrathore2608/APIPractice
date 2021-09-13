import Utils.APIUrl;
import Utils.Client;
import Utils.ConfigProperties;
import Utils.GetHeaders;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class GetListOfPublicRepo {

    private static String path="/repositories";


@Test
    public static void testGetListOfPublicRepo() throws IOException {
           String[] keys={"accept"};
           Client client= new Client();
        String url= APIUrl.getURL(path);
        HashMap<String,String> hdr=GetHeaders.getHeaders(keys);
        CloseableHttpResponse httpResponse= (CloseableHttpResponse) client.getrequest( url, hdr );

           String responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
//        JSONObject jsonObject= new JSONObject("{"+responseString+"}");
//        System.out.print(jsonObject);
//           System.out.print(responseString);

           Header[] responseHeaders= httpResponse.getAllHeaders();

           HashMap<String,String> headerAll= new HashMap<String, String>();

           for(Header header:responseHeaders){
               headerAll.put(header.getName(),header.getValue());
           }

           int status=httpResponse.getStatusLine().getStatusCode();
    Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),200);
//           System.out.print(httpResponse.getStatusLine().getStatusCode());

       }
}
