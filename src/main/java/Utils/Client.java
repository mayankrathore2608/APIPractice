package Utils;

import org.apache.commons.collections.map.HashedMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Client {

    CloseableHttpClient httpclient;
    public Client(){
        try{
            if(httpclient==null){
                httpclient = HttpClients.createDefault();
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    public HttpResponse getrequest(String url, Map<String,String> headers) throws IOException {

        HttpGet httpget = new HttpGet(url);

        for(Map.Entry<String,String> h:headers.entrySet()){
            httpget.addHeader(h.getKey(),h.getValue());
        }

        CloseableHttpResponse httpresponse = httpclient.execute(httpget);
        return httpresponse ;
    }


    public HttpResponse postRequest(String url, Map<String,String> headers , String payload) throws IOException {

        HttpPost httppost = new HttpPost(url);
        for(Map.Entry<String,String> h:headers.entrySet()){
            httppost.addHeader(h.getKey(),h.getValue());
        }

        if (payload != null)
            httppost.setEntity(new StringEntity(payload, "UTF-8"));

        CloseableHttpResponse httpresponse = httpclient.execute(httppost);
        return httpresponse;

    }








}
