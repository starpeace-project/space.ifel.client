package client.servers.clients.models.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import client.servers.clients.models.galaxy.Galaxy;
import client.servers.clients.models.galaxy.GalaxyRoot;

public class GalaxyFactory {
    public static Galaxy load(String json) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GalaxyRoot root = objectMapper.readValue(json, GalaxyRoot.class);
            return root.getGalaxy();
        } catch (Exception e) {
            System.out.println("An error occurred parsing the galaxy string.");
            throw new Exception(e.getMessage());
        }
    }
}
