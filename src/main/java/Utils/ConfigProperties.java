package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
//
//    public ConfigProperties(){
//
//
//
//
//
//    }
//


public static String getPropertyValues(String key , String filename) throws IOException {

    FileReader reader=new FileReader(filename);
    Properties p=new Properties();
    p.load(reader);
    return p.getProperty(key);

}
}

