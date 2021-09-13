package Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetHeaders {
    private static HashMap<String,String> headers;

 public static HashMap<String,String> getHeaders(String[] keys) throws IOException {
 try{
if(headers==null){
  headers=new HashMap<String, String>();
}
     for(String s : keys){
         String value=ConfigProperties.getPropertyValues(s,"C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties");
         headers.put(s ,value);
     }
 }
 catch (Exception e ){
     e.printStackTrace();
 }
     return headers;
    }
}
