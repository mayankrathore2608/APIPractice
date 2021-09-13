import Utils.ConfigProperties;
import Utils.GetHeaders;
import org.apache.commons.collections.map.HashedMap;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
//import org.junit.Test;
import Utils.Client;
import org.testng.annotations.Test;

import java.io.IOException;
//import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Token {

    public static String accessToken;
    public static String apiUrl;
    public static HashMap headers;

    public static HashMap getHeaders() throws IOException {

        headers= new HashMap<String,String>();
        headers.put("Host",ConfigProperties.getPropertyValues("Host","C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties"));
        headers.put("Authorization",ConfigProperties.getPropertyValues("Authorization","C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties"));
        headers.put("Content-Type", ConfigProperties.getPropertyValues("Content-Type","C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties"));
        headers.put("X-CSRF-TOKEN", ConfigProperties.getPropertyValues("X-CSRF-TOKEN","C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties"));
        headers.put("Accept", ConfigProperties.getPropertyValues("Accept","C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties"));
        headers.put("Accept-Encoding", ConfigProperties.getPropertyValues("Accept-Encoding","C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties"));
        headers.put("Scheme", ConfigProperties.getPropertyValues("Scheme","C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties"));
        return headers;

    }

    public static String getURL() throws IOException {
        apiUrl= ConfigProperties.getPropertyValues("Host","C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties")+"/tblusers/additional/details";
        return apiUrl;
    }

    @Test
    public static void getAccessToken() throws IOException {


        Client client= new Client();
        String[] keys={"host"};
        CloseableHttpResponse httpResponse= (CloseableHttpResponse) client.getrequest(Token.getURL(), GetHeaders.getHeaders(keys));
        System.out.print(apiUrl);
        String responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");

//        JSONObject jsonObject= new JSONObject("{"+responseString+"}");
//        System.out.print(jsonObject);
        System.out.print(responseString);

        Header[] responseHeaders= httpResponse.getAllHeaders();

        HashMap<String,String> headerAll= new HashMap<String, String>();

        for(Header header:responseHeaders){
            headerAll.put(header.getName(),header.getValue());
        }

        System.out.print(httpResponse.getStatusLine().getStatusCode());

        System.out.print("Headers are : "+headerAll);
        System.out.println();
//        System.out.print("Response is : "+jsonObject);


    }

}
