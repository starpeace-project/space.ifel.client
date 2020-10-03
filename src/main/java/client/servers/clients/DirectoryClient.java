package client.servers.clients;

import client.servers.clients.models.factories.GalaxyFactory;
import client.servers.clients.models.factories.UserFactory;
import client.servers.clients.models.galaxy.Galaxy;
import client.servers.clients.models.user.User;

public class DirectoryClient {
    public DirectoryClient() {
    }

    public Galaxy getGalaxy() throws Exception {
        // Call directory server and get galaxy string (json)
        String fakeJsonString = "{\n" +
                "  \"galaxy\": {\n" +
                "    \"quadrants\": [\n" +
                "      {\n" +
                "        \"name\": \"Free Play Worlds\",\n" +
                "        \"worlds\": [\n" +
                "          {\n" +
                "            \"name\": \"Zorcon\",\n" +
                "            \"image\": \"world1.png\",\n" +
                "            \"eclipsed\": false,\n" +
                "            \"population\": 12340000,\n" +
                "            \"investors\": 32,\n" +
                "            \"online\": 6,\n" +
                "            \"interface\": \"123.123.123.123\",\n" +
                "            \"interface_port\": 6000,\n" +
                "            \"model\": \"234.234.234.234\",\n" +
                "            \"model_direct_access_port\": 7000\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Subscriber Worlds\",\n" +
                "        \"worlds\": [\n" +
                "          {\n" +
                "            \"name\": \"Xalion\",\n" +
                "            \"image\": \"world2.png\",\n" +
                "            \"eclipsed\": false,\n" +
                "            \"population\": 12340000,\n" +
                "            \"investors\": 32,\n" +
                "            \"online\": 6,\n" +
                "            \"interface\": \"123.123.123.123\",\n" +
                "            \"interface_port\": 6000,\n" +
                "            \"model\": \"234.234.234.234\",\n" +
                "            \"model_direct_access_port\": 7000\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"Angelicus\",\n" +
                "            \"image\": \"world3.png\",\n" +
                "            \"eclipsed\": false,\n" +
                "            \"population\": 12340000,\n" +
                "            \"investors\": 32,\n" +
                "            \"online\": 6,\n" +
                "            \"interface\": \"123.123.123.123\",\n" +
                "            \"interface_port\": 6000,\n" +
                "            \"model\": \"234.234.234.234\",\n" +
                "            \"model_direct_access_port\": 7000\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"Willow\",\n" +
                "            \"eclipsed\": false,\n" +
                "            \"image\": \"world4.png\",\n" +
                "            \"population\": 12340000,\n" +
                "            \"investors\": 32,\n" +
                "            \"online\": 6,\n" +
                "            \"interface\": \"123.123.123.123\",\n" +
                "            \"interface_port\": 6000,\n" +
                "            \"model\": \"234.234.234.234\",\n" +
                "            \"model_direct_access_port\": 7000\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Player Worlds\",\n" +
                "        \"worlds\": [\n" +
                "          {\n" +
                "            \"name\": \"Chipango\",\n" +
                "            \"eclipsed\": false,\n" +
                "            \"image\": \"world5.png\",\n" +
                "            \"population\": 12340000,\n" +
                "            \"investors\": 32,\n" +
                "            \"online\": 6,\n" +
                "            \"interface\": \"123.123.123.123\",\n" +
                "            \"interface_port\": 6000,\n" +
                "            \"model\": \"234.234.234.234\",\n" +
                "            \"model_direct_access_port\": 7000\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        try {
            return GalaxyFactory.load(fakeJsonString);
        } catch (Exception e) {
            System.out.println("Exception throw obtaining galaxy.");
            throw new Exception(e.getMessage());
        }
    }

    public User getUser() throws Exception {
        String fakeJsonString = "{\n" +
                "  \"alias\": \"dodgerid\",\n" +
                "  \"session_id\": \"3453245234\",\n" +
                "  \"worlds\": [\n" +
                "    {\n" +
                "      \"name\": \"Zorcon\",\n" +
                "      \"last_x\": 640,\n" +
                "      \"last_y\": 430\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Chipango\",\n" +
                "      \"last_x\": 640,\n" +
                "      \"last_y\": 430\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        try {
            return UserFactory.load(fakeJsonString);
        } catch (Exception e) {
            System.out.print("Exception thrown obtaining user.");
            throw new Exception(e.getMessage());
        }
    }

    public boolean checkPlayerAlias(String alias) {
        return !alias.equals("dodgerid");
    }
}