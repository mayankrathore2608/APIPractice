package Utils;

import java.io.IOException;

public class APIUrl {

    public static String getURL(String path) throws IOException {
        String apiUrl= ConfigProperties.getPropertyValues("Host","C:\\Users\\mayank.rathore\\IdeaProjects\\Hybrid Framework\\src\\main\\java\\EnvConfig\\EUSB.properties")+path;
        return apiUrl;
    }
}
