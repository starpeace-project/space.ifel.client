package client.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigFactory {
    public static ClientConfig load(String json, String configClass) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return (ClientConfig) objectMapper.readValue(json, Class.forName(configClass));
        } catch (Exception e) {
            System.out.println("An error occurred parsing the config string.");
            throw new Exception(e.getMessage());
        }
    }

    public static void save(File file, ClientConfig config) {
        try {
            ObjectMapper om = new ObjectMapper();
            om.writeValue(file, config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
