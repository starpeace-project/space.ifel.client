package client.servers.clients.models.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import client.servers.clients.models.user.User;

public class UserFactory {
    public static User load(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, User.class);
        } catch (Exception e) {
            System.out.println("An error occurred parsing the galaxy string.");
            throw new Exception(e.getMessage());
        }
    }
}
